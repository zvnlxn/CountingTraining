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

public class AddingActivity extends AppCompatActivity {

    private int currentExIndexAdd = 0;
    private TextView tvExampleAdd, tvExampleNumberAdd;
    Button btnNextAdd;
    private List<String> examplesAdd;
    private int correctAnswerAdd;
    EditText etAnswerAdd;
    private HashMap<String, String> exampleAnswerMapAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding);

        exampleAnswerMapAdd = (HashMap<String, String>) Helper.getRandomExampleAdd(Constants.EXAMPLES_COUNT);
        examplesAdd = new ArrayList<>(exampleAnswerMapAdd.keySet());
        tvExampleNumberAdd = findViewById(R.id.tvCurrentExAdd);
        tvExampleAdd = findViewById(R.id.ExampleAdd);
        btnNextAdd = findViewById(R.id.btnNextAdd);
        etAnswerAdd = findViewById(R.id.etAnswerAdd);

        btnNextAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer = etAnswerAdd.getText().toString();

                if (answer.isEmpty()) {
                    Toast.makeText(AddingActivity.this, "Заполните поле ответа", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (exampleAnswerMapAdd.get(examplesAdd.get(currentExIndexAdd)).equals(answer)) {
                    correctAnswerAdd++;
                }

                currentExIndexAdd++;

                if (btnNextAdd.getText().equals("Next")) {
                    diplayNextQuestions();
                }
                else {
                    Intent intent = new Intent(AddingActivity.this, FinalResultActivity.class);

                    intent.putExtra(Constants.CORRECT, correctAnswerAdd);
                    intent.putExtra(Constants.INCORRECT, Constants.EXAMPLES_COUNT - correctAnswerAdd);
                    startActivity(intent);
                    finish();

                }
            }
        });

        displayData();

    }

    private void diplayNextQuestions() {
        etAnswerAdd.setText("");
        tvExampleAdd.setText(examplesAdd.get(currentExIndexAdd) + " = ?");
        tvExampleNumberAdd.setText("Номер вопроса : " + (currentExIndexAdd == Constants.EXAMPLES_COUNT - 1));{
            btnNextAdd.setText("ФИНИШ");
        }
    }


    private void displayData() {
        tvExampleAdd.setText(examplesAdd.get(currentExIndexAdd) + " = ?");
        tvExampleNumberAdd.setText("Номер вопроса : " + (currentExIndexAdd + 1));
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}