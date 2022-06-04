package com.example.countingtraining.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.countingtraining.MainActivity;
import com.example.countingtraining.R;
import com.example.countingtraining.controller.AuthController;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public class RegistrationActivity extends AppCompatActivity {

    EditText etUserName, etEmail, etPassword;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setTheme(R.style.Theme_CountingTraining);
        AuthController authController = new AuthController();

        if(authController.isRegistered()){
            startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
        }

        setContentView(R.layout.activity_registration);

        etUserName = findViewById(R.id.nameReg);
        etEmail = findViewById(R.id.emailReg);
        etPassword = findViewById(R.id.passwordReg);
        btnRegister = findViewById(R.id.btnStartReg);



        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUserName.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                authController.registerNewUser(email, password, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
                            Toast.makeText(RegistrationActivity.this, authController.getUser().getEmail(), Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(RegistrationActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}