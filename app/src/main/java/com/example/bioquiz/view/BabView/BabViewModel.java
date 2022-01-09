package com.example.bioquiz.view.BabView;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.bioquiz.Model.Bab;
import com.example.bioquiz.repositories.BabRepository;

public class BabViewModel extends AndroidViewModel {

    private BabRepository babRepository;
    private static final String TAG = "BabViewModel";

    public BabViewModel(@NonNull Application application) {
        super(application);
    }
    public void init(String token){
        Log.d(TAG, "init: " + token);
       babRepository = BabRepository.getInstance(token);
    }


    // == Begin of view model to get all course
    private MutableLiveData<Bab> resultBab = new MutableLiveData<>();

    public void getBab(){
        resultBab = babRepository.getBab();
    }

    public MutableLiveData<Bab> getResultBab(){
        return resultBab;
    }
}


