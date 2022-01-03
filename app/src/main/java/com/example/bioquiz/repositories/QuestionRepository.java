package com.example.bioquiz.repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.bioquiz.Model.Question;
import com.example.bioquiz.retrofit.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionRepository {

    private static QuestionRepository questionRepository;
    private RetrofitService apiService;
    private static final String TAG = "QuestionRepository";

    private QuestionRepository (String token){
        Log.d(TAG, "token: " + token);
        apiService = RetrofitService.getInstance(token);
    }

    public static QuestionRepository getInstance(String token){
        if (questionRepository == null){
            questionRepository = new QuestionRepository(token);
        }
        return questionRepository;
    }

    public synchronized void resetInstance(){
        if (questionRepository != null){
            questionRepository = null;
        }else {
            questionRepository = null;
        }
    }

    public MutableLiveData<Question> getQuestions(){
        final MutableLiveData<Question> listQuestions = new MutableLiveData<>();

        apiService.getQuestions().enqueue(new Callback<Question>() {
            @Override
            public void onResponse(Call<Question> call, Response<Question> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if (response.isSuccessful()){
                    if (response.body() != null){
                        Log.d(TAG, "onResponse" + response.body().getSoal().size());
                        listQuestions.postValue(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<Question> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
        return listQuestions;
    }
}
