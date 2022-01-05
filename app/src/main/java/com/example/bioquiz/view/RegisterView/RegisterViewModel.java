package com.example.bioquiz.view.RegisterView;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.bioquiz.Model.RegisterResponse;
import com.example.bioquiz.repositories.AuthRepository;

public class RegisterViewModel extends AndroidViewModel {
    private AuthRepository authRepository;
    private static final String TAG = "RegisterViewModel";

    public RegisterViewModel(@NonNull Application application) {
        super(application);
        authRepository = AuthRepository.getInstance();
    }
    public MutableLiveData<RegisterResponse> register (String name, String city, String birthyear, String school, String email, String username, String password) {
        return authRepository.register(name, city, birthyear, school, email, username, password);
    }
}
