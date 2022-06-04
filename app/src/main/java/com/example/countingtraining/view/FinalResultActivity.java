package com.example.countingtraining.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.countingtraining.MainActivity;
import com.example.countingtraining.R;
import com.example.countingtraining.other.Constants;

public class FinalResultActivity extends AppCompatActivity {
    private TextView tvSubject, tvCorrect, tvIncorrect, tvEarned, tvAllPoints, tvData;

    Button btnResStartAgain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_result);
        Intent intent = getIntent();
        int correctAnswer = intent.getIntExtra(Constants.CORRECT, 0);
        int incorrectAnswer = intent.getIntExtra(Constants.INCORRECT, 0);
        String subject = intent.getStringExtra(Constants.SUBJECT);
        int earnedPoints = (correctAnswer * Constants.CORRECT_POINTS) - (incorrectAnswer * Constants.INCORRECT_POINTS);

        tvSubject = findViewById(R.id.tv_ResSubject);
        tvCorrect = findViewById(R.id.tv_ResCorrectAns);
        tvIncorrect = findViewById(R.id.tv_ResIncorrectAns);
        tvEarned = findViewById(R.id.tv_ResEarned);
        tvAllPoints = findViewById(R.id.tv_ResAll);
        tvData = findViewById(R.id.tv_ResData);
        btnResStartAgain = findViewById(R.id.btnResStartAgain);

        btnResStartAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FinalResultActivity.this, MainActivity.class));
                finish();
            }
        });

    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
