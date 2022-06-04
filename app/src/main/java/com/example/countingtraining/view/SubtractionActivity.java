package com.example.countingtraining.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.countingtraining.MainActivity;
import com.example.countingtraining.R;
import com.example.countingtraining.other.Constants;
import com.example.countingtraining.other.Helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubtractionActivity extends AppCompatActivity {

    private int currentExIndexSub = 0;
    private TextView tvExampleSub, tvExampleNumberSub;
    Button btnNextSub;
    private List<String> examplesSub;
    private int correctAnswerSub;
    EditText etAnswerSub;
    private HashMap<String, String> exampleAnswerMapSub;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subtraction);

        exampleAnswerMapSub = (HashMap<String, String>) Helper.getRandomExampleAdd(Constants.EXAMPLES_COUNT);
        examplesSub = new ArrayList<>(exampleAnswerMapSub.keySet());
        tvExampleNumberSub = findViewById(R.id.tvCurrentExSub);
        tvExampleSub = findViewById(R.id.ExampleSub);
        btnNextSub = findViewById(R.id.btnNextSub);
        etAnswerSub = findViewById(R.id.etAnswerSub);

        btnNextSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer = etAnswerSub.getText().toString();

                if (answer.isEmpty()) {
                    Toast.makeText(SubtractionActivity.this, "Заполните поле ответа", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (exampleAnswerMapSub.get(examplesSub.get(currentExIndexSub)).equals(answer)) {
                    correctAnswerSub++;
                }

                currentExIndexSub++;

                if (btnNextSub.getText().equals("Next")) {
                    diplayNextQuestions();
                }
                else {
                    Intent intent = new Intent(SubtractionActivity.this, FinalResultActivity.class);

                    intent.putExtra(Constants.CORRECT, correctAnswerSub);
                    intent.putExtra(Constants.INCORRECT, Constants.EXAMPLES_COUNT - correctAnswerSub);
                    startActivity(intent);
                    finish();

                }
            }
        });

        displayData();

    }

    private void diplayNextQuestions() {
        etAnswerSub.setText("");
        tvExampleSub.setText(examplesSub.get(currentExIndexSub) + " = ?");
        tvExampleNumberSub.setText("Номер вопроса : " + (currentExIndexSub == Constants.EXAMPLES_COUNT - 1));{
            btnNextSub.setText("ФИНИШ");
        }
    }


    private void displayData() {
        tvExampleSub.setText(examplesSub.get(currentExIndexSub) + " = ?");
        tvExampleNumberSub.setText("Номер вопроса : " + (currentExIndexSub + 1));
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}