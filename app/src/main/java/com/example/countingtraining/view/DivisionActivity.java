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

public class DivisionActivity extends AppCompatActivity {

    private int currentExIndexDiv = 0;
    private TextView tvExampleDiv, tvExampleNumberDiv;
    Button btnNextDiv;
    private List<String> examplesDiv;
    private int correctAnswerDiv;
    EditText etAnswerDiv;
    private HashMap<String, String> exampleAnswerMapDiv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_division);

        exampleAnswerMapDiv = (HashMap<String, String>) Helper.getRandomExampleAdd(Constants.EXAMPLES_COUNT);
        examplesDiv = new ArrayList<>(exampleAnswerMapDiv.keySet());
        tvExampleNumberDiv = findViewById(R.id.tvCurrentExDiv);
        tvExampleDiv = findViewById(R.id.ExampleDiv);
        btnNextDiv = findViewById(R.id.btnNextDiv);
        etAnswerDiv = findViewById(R.id.etAnswerDiv);

        btnNextDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer = etAnswerDiv.getText().toString();

                if (answer.isEmpty()) {
                    Toast.makeText(DivisionActivity.this, "Заполните поле ответа", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (exampleAnswerMapDiv.get(examplesDiv.get(currentExIndexDiv)).equals(answer)) {
                    correctAnswerDiv++;
                }

                currentExIndexDiv++;

                if (btnNextDiv.getText().equals("Next")) {
                    diplayNextQuestions();
                }
                else {
                    Intent intent = new Intent(DivisionActivity.this, FinalResultActivity.class);

                    intent.putExtra(Constants.CORRECT, correctAnswerDiv);
                    intent.putExtra(Constants.INCORRECT, Constants.EXAMPLES_COUNT - correctAnswerDiv);
                    startActivity(intent);
                    finish();

                }
            }
        });

        displayData();

    }

    private void diplayNextQuestions() {
        etAnswerDiv.setText("");
        tvExampleDiv.setText(examplesDiv.get(currentExIndexDiv) + " = ?");
        tvExampleNumberDiv.setText("Номер вопроса : " + (currentExIndexDiv == Constants.EXAMPLES_COUNT - 1));{
            btnNextDiv.setText("ФИНИШ");
        }
    }


    private void displayData() {
        tvExampleDiv.setText(examplesDiv.get(currentExIndexDiv) + " = ?");
        tvExampleNumberDiv.setText("Номер вопроса : " + (currentExIndexDiv + 1));
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
