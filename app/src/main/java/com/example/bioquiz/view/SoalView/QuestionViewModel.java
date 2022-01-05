package com.example.bioquiz.view.SoalView;

import android.app.Application;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.bioquiz.Model.Question;
import com.example.bioquiz.repositories.QuestionRepository;

public class QuestionViewModel extends AndroidViewModel {

    private QuestionRepository questionRepository;
    private static final String TAG = "QuestionViewModel";

    public QuestionViewModel(@NonNull Application application) {
        super(application);
    }

    public void init(String token){
        Log.d(TAG, "init: " + token);
        questionRepository = QuestionRepository.getInstance(token);
    }


    // == Begin of view model to get all course
    private MutableLiveData<Question> resultQuestions = new MutableLiveData<>();

    public void getQuestions(){
        resultQuestions = questionRepository.getQuestions();
    }

    public LiveData<Question> getResultQuestions(){
        return resultQuestions;
    }
}

