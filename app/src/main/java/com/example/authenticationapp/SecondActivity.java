package com.example.authenticationapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    TextView t1,t2,t3,t4;
    String Name,Rollno,Option,dept;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        t1 = (TextView) findViewById(R.id.textView1);
        t2 = (TextView) findViewById(R.id.textView2);
        t3 = (TextView) findViewById(R.id.textView3);
        t4 = (TextView) findViewById(R.id.textView4);
        //Getting the Intent
       // Intent i = getIntent();
        //Getting the Values from First Activity using the Intent received
        Name = "Name:   " + getIntent().getExtras().getString("name_key");
        Rollno = "Rollno:   " + getIntent().getExtras().getString("reg_key");
        Option="Option:   " + getIntent().getExtras().getString("opt_key");
        dept = "dept:   "+getIntent().getExtras().getString("dept_key");
        //Setting the Values to Intent
        t1.setText( Name);
        t2.setText(Rollno);
        t3.setText(Option);
        t4.setText(dept);

    }
}
