package com.example.bioquiz.repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.bioquiz.Model.Material;
import com.example.bioquiz.retrofit.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MaterialRepository {

    private static MaterialRepository materialRepository;
    private RetrofitService apiService;
    private static final String TAG = "MaterialRepository";

    private MaterialRepository (String token){
        Log.d(TAG, "token: " + token);
        apiService = RetrofitService.getInstance(token);
    }

    public static MaterialRepository getInstance(String token){
        if (materialRepository == null){
            materialRepository = new MaterialRepository(token);
        }
        return materialRepository;
    }

    public synchronized void resetInstance(){
        if (materialRepository != null){
            materialRepository = null;
        }else {
            materialRepository = null;
        }
    }

    public MutableLiveData<Material> getMaterial(){
        final MutableLiveData<Material> listMateri = new MutableLiveData<>();

        apiService.getMateri().enqueue(new Callback<Material>() {
            @Override
            public void onResponse(Call<Material> call, Response<Material> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if (response.isSuccessful()){
                    if (response.body() != null){
                        Log.d(TAG, "onResponse" + response.body().getMateri().size());
                        listMateri.postValue(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<Material> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
        return listMateri;
    }
}
