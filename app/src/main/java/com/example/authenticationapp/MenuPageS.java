package com.example.authenticationapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MenuPageS extends AppCompatActivity {
    Button libraryBtn,hrdBtn,AdminBtn,hostelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_page_s);

        libraryBtn=findViewById(R.id.libraryBtn);
        hrdBtn=findViewById(R.id.hrdBtn);
        AdminBtn=findViewById(R.id.AdminBtn);
        hostelBtn=findViewById(R.id.hostelBtn);

        libraryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuPageS.this, MainActivity3.class);
                startActivity(i);
            }
        });

        hrdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPageS.this, MainActivity3.class);
                startActivity(intent);
            }
        });
        AdminBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPageS.this, MainActivity3.class);
                startActivity(intent);
            }
        });
        hostelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPageS.this, MainActivity3.class);
                startActivity(intent);
            }
        });

    }
}