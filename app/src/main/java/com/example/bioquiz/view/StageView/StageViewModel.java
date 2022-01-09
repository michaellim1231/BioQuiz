package com.example.bioquiz.view.StageView;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.bioquiz.Model.Stage;
import com.example.bioquiz.repositories.StageRepository;

public class StageViewModel extends AndroidViewModel {

    private StageRepository stageRepository;
    private static final String TAG = "StageViewModel";
    public StageViewModel(@NonNull Application application) {
        super(application);
    }
    public void init(String token){
        Log.d(TAG, "init: " + token);
        stageRepository = StageRepository.getInstance(token);
    }


    // == Begin of view model to get all course
    private MutableLiveData<Stage> resultStage = new MutableLiveData<>();

    public void getStage(){
        resultStage = stageRepository.getStage();
    }

    public MutableLiveData<Stage> getResultStage(){
        return resultStage;
    }
}



