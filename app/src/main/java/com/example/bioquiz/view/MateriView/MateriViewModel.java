package com.example.bioquiz.view.MateriView;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.bioquiz.Model.Material;
import com.example.bioquiz.repositories.MaterialRepository;

public class MateriViewModel extends AndroidViewModel {
    private MaterialRepository materialRepository;
    private static final String TAG = "MateriViewModel";

    public MateriViewModel(@NonNull Application application) {
        super(application);
    }
    public void init(String token){
        Log.d(TAG, "init: " + token);
        materialRepository = MaterialRepository.getInstance(token);
    }


    // == Begin of view model to get all course
    private MutableLiveData<Material> resultMaterial = new MutableLiveData<>();

    public void getQuestions(){
        resultMaterial = materialRepository.getMaterial();
    }

    public MutableLiveData<Material> getResultQuestions(){
        return resultMaterial;
    }
}

