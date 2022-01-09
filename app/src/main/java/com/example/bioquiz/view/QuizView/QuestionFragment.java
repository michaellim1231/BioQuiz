package com.example.bioquiz.view.QuizView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.bioquiz.Model.Question;
import com.example.bioquiz.R;
import com.example.bioquiz.helper.SharedPreferenceHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuestionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestionFragment<helper> extends Fragment {
    TextView textViewSoal;

    private QuestionViewModel questionViewModel;
    private SharedPreferenceHelper helper;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public QuestionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QuestionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QuestionFragment newInstance(String param1, String param2) {
        QuestionFragment fragment = new QuestionFragment();
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
        return inflater.inflate(R.layout.fragment_question, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        textViewSoal = view.findViewById(R.id.textviewSoal);

        helper = SharedPreferenceHelper.getInstance(requireActivity());;
        questionViewModel = new ViewModelProvider(getActivity()).get(QuestionViewModel.class);
        questionViewModel.init(helper.getAccessToken());
        questionViewModel.getQuestions();
        questionViewModel.getResultQuestions().observe(getActivity(), showQuestion);

    }
    List<Question.Soal> results = new ArrayList<>();
    LinearLayoutManager linearLayoutManager;

    private Observer<Question> showQuestion = new Observer<Question>() {
        @Override
        public void onChanged(Question question) {
            results = question.getSoal();
            String soal = question.getSoal().get(0).getSoal_text();
            textViewSoal.setText(soal);
        }
    };

    @Override
    public void onDetach() {
        super.onDetach();
    }
}

