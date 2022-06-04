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

public class IncreaseActivity extends AppCompatActivity {

    private int currentExIndexInc = 0;
    private TextView tvExampleInc, tvExampleNumberInc;
    Button btnNextInc;
    private List<String> examplesInc;
    private int correctAnswerInc;
    EditText etAnswerInc;
    private HashMap<String, String> exampleAnswerMapInc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_increase);

        exampleAnswerMapInc = (HashMap<String, String>) Helper.getRandomExampleAdd(Constants.EXAMPLES_COUNT);
        examplesInc = new ArrayList<>(exampleAnswerMapInc.keySet());
        tvExampleNumberInc = findViewById(R.id.tvCurrentExInc);
        tvExampleInc = findViewById(R.id.ExampleInc);
        btnNextInc = findViewById(R.id.btnNextInc);
        etAnswerInc = findViewById(R.id.etAnswerInc);

        btnNextInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer = etAnswerInc.getText().toString();

                if (answer.isEmpty()) {
                    Toast.makeText(IncreaseActivity.this, "Заполните поле ответа", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (exampleAnswerMapInc.get(examplesInc.get(currentExIndexInc)).equals(answer)) {
                    correctAnswerInc++;
                }

                currentExIndexInc++;

                if (btnNextInc.getText().equals("Next")) {
                    diplayNextQuestions();
                }
                else {
                    Intent intent = new Intent(IncreaseActivity.this, FinalResultActivity.class);

                    intent.putExtra(Constants.CORRECT, correctAnswerInc);
                    intent.putExtra(Constants.INCORRECT, Constants.EXAMPLES_COUNT - correctAnswerInc);
                    startActivity(intent);
                    finish();

                }
            }
        });

        displayData();

    }

    private void diplayNextQuestions() {
        etAnswerInc.setText("");
        tvExampleInc.setText(examplesInc.get(currentExIndexInc) + " = ?");
        tvExampleNumberInc.setText("Номер вопроса : " + (currentExIndexInc == Constants.EXAMPLES_COUNT - 1));{
            btnNextInc.setText("ФИНИШ");
        }
    }


    private void displayData() {
        tvExampleInc.setText(examplesInc.get(currentExIndexInc) + " = ?");
        tvExampleNumberInc.setText("Номер вопроса : " + (currentExIndexInc + 1));
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}