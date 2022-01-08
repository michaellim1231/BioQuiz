package com.example.bioquiz.repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.bioquiz.Model.Stage;
import com.example.bioquiz.retrofit.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StageRepository {

    private static StageRepository stageRepository;
    private RetrofitService apiService;
    private static final String TAG = "StageRepository";

    private StageRepository (String token){
        Log.d(TAG, "token: " + token);
        apiService = RetrofitService.getInstance(token);
    }

    public static StageRepository getInstance(String token){
        if (stageRepository == null){
            stageRepository = new StageRepository(token);
        }
        return stageRepository;
    }

    public synchronized void resetInstance(){
        if (stageRepository != null){
            stageRepository = null;
        }else {
            stageRepository = null;
        }
    }

    public MutableLiveData<Stage> getStage(){
        final MutableLiveData<Stage> listStage = new MutableLiveData<>();

        apiService.getStage().enqueue(new Callback<Stage>() {
            @Override
            public void onResponse(Call<Stage> call, Response<Stage> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if (response.isSuccessful()){
                    if (response.body() != null){
                        Log.d(TAG, "onResponse" + response.body().getStages().size());
                        listStage.postValue(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<Stage> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });

        return listStage;
    }
}
