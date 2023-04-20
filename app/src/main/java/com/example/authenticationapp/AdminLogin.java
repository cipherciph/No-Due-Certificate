package com.example.authenticationapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AdminLogin extends AppCompatActivity {

    EditText UsernameEditText,passwordEditText;
    Button okBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        UsernameEditText=findViewById(R.id.UsernameEditText);
        passwordEditText=findViewById(R.id.passwordEditText);
        okBtn=findViewById(R.id.okBtn);

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Username = UsernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                if (!isValidPassword(password)) {
                    Toast.makeText(AdminLogin.this, "Password doesn't match rules", Toast.LENGTH_SHORT).show();
                    //return;
                }
                if (!isValidName(Username)) {
                    Toast.makeText(AdminLogin.this, "Name doesn't match rules", Toast.LENGTH_SHORT).show();
                    //return;
                }
                Intent intent = new Intent(AdminLogin.this, MainActivity2.class);
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

