package com.example.authenticationapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    EditText usnEditText, passwordEditText;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usnEditText = findViewById(R.id.usnEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginBtn = findViewById(R.id.loginBtn);
        String registeredEmail = getIntent().getStringExtra("usn");
        String registeredPassword = getIntent().getStringExtra("password");

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = usnEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                if (!isValidPassword(password)) {
                    Toast.makeText(Login.this, "Password doesn't match rules", Toast.LENGTH_SHORT).show();
                    //return;
                }
                if (!isValidName(email)) {
                    Toast.makeText(Login.this, "Name doesn't match rules", Toast.LENGTH_SHORT).show();
                    //return;
                }
                Intent intent = new Intent(Login.this, MenuPageS.class);
                startActivity(intent);


            }


        });
    }
    private Boolean isValidPassword(String password) {
        if(!(password =="***"))
            return false;
        else
            return true;


    }
    private Boolean isValidName(String Username) {
        if(!(Username =="###"))
            return false;
        else
            return true;
    }
}