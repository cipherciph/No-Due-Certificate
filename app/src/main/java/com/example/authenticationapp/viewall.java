package com.example.authenticationapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class viewall extends AppCompatActivity {
    EditText t2, t1,t3;
    SQLiteDatabase db;
    String Name,Rollno,Option;
    Button viewall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewall);
        t2 =(EditText)findViewById(R.id.Rollno);
        t1 =(EditText)findViewById(R.id.Name);
        t3=(EditText)findViewById(R.id.Option);
        viewall= (Button) findViewById(R.id.button3);

        viewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Name = t1.getText().toString();
                Rollno = t2.getText().toString();
                Option = t3.getText().toString();
                Intent i = getIntent();
                //Getting the Values from First Activity using the Intent received
                Name=i.getStringExtra("name_key");
                Rollno=i.getStringExtra("reg_key");
                Option=i.getStringExtra("opt_key");
                //Setting the Values to Intent
                t1.setText(Name);
                t2.setText(Rollno);
                t3.setText(Option);
            }
        });

    }
}