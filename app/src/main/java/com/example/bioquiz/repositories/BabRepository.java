package com.example.bioquiz.repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.bioquiz.Model.Bab;
import com.example.bioquiz.retrofit.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BabRepository {

    private static BabRepository babRepository;
    private RetrofitService apiService;
    private static final String TAG = "BabRepository";

    private BabRepository (String token){
        Log.d(TAG, "token: " + token);
        apiService = RetrofitService.getInstance(token);
    }

    public static BabRepository getInstance(String token){
        if (babRepository == null){
            babRepository = new BabRepository(token);
        }
        return babRepository;
    }

    public synchronized void resetInstance(){
        if (babRepository != null){
            babRepository = null;
        }else {
            babRepository = null;
        }
    }

    public MutableLiveData<Bab> getBab(){
        final MutableLiveData<Bab> listBab = new MutableLiveData<>();

        apiService.getBab().enqueue(new Callback<Bab>() {
            @Override
            public void onResponse(Call<Bab> call, Response<Bab> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if (response.isSuccessful()){
                    if (response.body() != null){
                        Log.d(TAG, "onResponse" + response.body().getBabs().size());
                        listBab.postValue(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<Bab> call, Throwable t) {
                    Log.e(TAG, "onFailure: " + t.getMessage());
                }
            });
        return listBab;
    }
}
