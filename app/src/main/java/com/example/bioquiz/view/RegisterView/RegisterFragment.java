package com.example.bioquiz.view.RegisterView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.bioquiz.R;
import com.example.bioquiz.view.Main.MainActivity;
import com.google.android.material.textfield.TextInputLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegisterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegisterFragment extends Fragment {

    TextView login_btn;

    TextInputLayout name_register, city_register, birthyear_register, school_register, email_register, username_register, pass_register;
    Button btn_reg;
    private RegisterViewModel registerViewModel;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RegisterFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegisterFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegisterFragment newInstance(String param1, String param2) {
        RegisterFragment fragment = new RegisterFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        login_btn = getActivity().findViewById(R.id.login_btn);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //NavDirections action = RegisterFragmentDirectiond.actionRegisterFragmentToLoginFragment();
                //Navigation.findNavController(view).navigate(action);
//                getActivity().finish();
            }
        });

        name_register = view.findViewById(R.id.editText_name);
        city_register = view.findViewById(R.id.editText_city);
        birthyear_register = view.findViewById(R.id.editText_birthyear);
        school_register = view.findViewById(R.id.editText_school);
        email_register = view.findViewById(R.id.editText_email);
        username_register = view.findViewById(R.id.editText_username);
        pass_register = view.findViewById(R.id.editText_password);
        btn_reg = view.findViewById(R.id.btn_register);

        registerViewModel = new ViewModelProvider(getActivity()).get(RegisterViewModel.class);

        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!name_register.getEditText().getText().toString().isEmpty()
                        && !city_register.getEditText().getText().toString().isEmpty()
                        && !birthyear_register.getEditText().getText().toString().isEmpty()
                        && !school_register.getEditText().getText().toString().isEmpty()
                        && !email_register.getEditText().getText().toString().isEmpty()
                        && !username_register.getEditText().getText().toString().isEmpty()
                        && !pass_register.getEditText().getText().toString().isEmpty()) {
                    String name = name_register.getEditText().getText().toString().trim();
                    String city = city_register.getEditText().getText().toString().trim();
                    String birthyear = birthyear_register.getEditText().getText().toString().trim();
                    String school = school_register.getEditText().getText().toString().trim();
                    String email = email_register.getEditText().getText().toString().trim();
                    String username = username_register.getEditText().getText().toString().trim();
                    String pass = pass_register.getEditText().getText().toString().trim();
                    registerViewModel.register(name, city, birthyear, school, email, username, pass).observe(requireActivity(), registerResponse -> {
                        if (registerResponse != null) {
                           // NavDirections actions = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment();
                           // Navigation.findNavController(view).navigate(actions);
                            Toast.makeText(requireActivity(), "Register Failed", Toast.LENGTH_SHORT).show();
                        }
                    });

                } else {
                    Toast.makeText(requireActivity(), "All field must not be empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        ((MainActivity) getActivity()).getSupportActionBar().hide();
    }

    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity) getActivity()).getSupportActionBar().hide();
    }

    @Override
    public void onStop() {
        super.onStop();
        ((MainActivity)getActivity()).getSupportActionBar().hide();
    }
}
