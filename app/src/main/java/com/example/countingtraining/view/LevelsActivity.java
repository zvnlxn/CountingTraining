package com.example.countingtraining.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.countingtraining.MainActivity;
import com.example.countingtraining.R;
import com.example.countingtraining.other.Constants;


public class LevelsActivity extends AppCompatActivity {

    Button addingbtn, subtractionbtn, increasebtn, divisionbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        addingbtn = findViewById(R.id.lvlBtn1);
        subtractionbtn = findViewById(R.id.lvlBtn2);
        divisionbtn = findViewById(R.id.lvlBtn3);
        increasebtn = findViewById(R.id.lvlBtn4);

        addingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LevelsActivity.this, AddingActivity.class);
                intent.putExtra(Constants.SUBJECT, "Сложение");
                startActivity(intent);

            }
        });
        subtractionbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LevelsActivity.this, DivisionActivity.class);
                intent.putExtra(Constants.SUBJECT, "Деление");
                startActivity(intent);
            }
        });
        divisionbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LevelsActivity.this, SubtractionActivity.class);
                intent.putExtra(Constants.SUBJECT, "Вычитание");
                startActivity(intent);
            }
        });
        increasebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LevelsActivity.this, IncreaseActivity.class);
                intent.putExtra(Constants.SUBJECT, "Умножение");
                startActivity(intent);
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