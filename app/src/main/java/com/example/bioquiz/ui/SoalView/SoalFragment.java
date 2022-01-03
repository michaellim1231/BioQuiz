package com.example.bioquiz.ui.SoalView;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.bioquiz.Model.Question;
import com.example.bioquiz.R;
import com.example.bioquiz.helper.SharedPreferenceHelper;
import com.example.bioquiz.repositories.QuestionRepository;

public class SoalFragment extends AppCompatActivity{

    private TextView textviewSoal;
    private SharedPreferenceHelper helper;
    private QuestionViewModel questionViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soal);

        textviewSoal = findViewById(R.id.textviewSoal);

        helper = SharedPreferenceHelper.getInstance(SoalFragment.this);
        questionViewModel = new ViewModelProvider(SoalFragment.this).get(QuestionViewModel.class);
        questionViewModel.init(helper.getAccessToken());
        questionViewModel.getQuestions();

        questionViewModel.getResultQuestions().observe(SoalFragment.this, question -> {
            String soal = question.getSoal().get(0).getSoal_text();
            textviewSoal.setText(soal);
        });
    }
}
