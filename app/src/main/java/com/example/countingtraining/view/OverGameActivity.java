package com.example.countingtraining.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.countingtraining.MainActivity;
import com.example.countingtraining.R;

public class OverGameActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TextView tvPoints, tvRightAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_over_game);

        recyclerView = findViewById(R.id.rvbestPoints);
        tvPoints = findViewById(R.id.Points);
        tvRightAnswers = findViewById(R.id.RightAnswers);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}