package com.example.authenticationapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Menupage extends AppCompatActivity {
    Button libraryBtn,hrdBtn,AdminBtn,hostelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menupage);
        libraryBtn=findViewById(R.id.libraryBtn);
        hrdBtn=findViewById(R.id.hrdBtn);
        AdminBtn=findViewById(R.id.AdminBtn);
        hostelBtn=findViewById(R.id.hostelBtn);

        libraryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menupage.this, AdminLogin.class);
                startActivity(intent);
            }
        });
        hrdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menupage.this, AdminLogin.class);
                startActivity(intent);
            }
        });
        AdminBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menupage.this, AdminLogin.class);
                startActivity(intent);
            }
        });
        hostelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menupage.this, AdminLogin.class);
                startActivity(intent);
            }
        });

    }
}