package com.example.authenticationapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity implements android.view.View.OnClickListener {
    EditText e2, e1,e3;
    Button Insert,Delete,Update,View,ViewAll,bt;
    SQLiteDatabase db;
    Spinner s;
    String [] dept_array={"CSE","ECE","IT","Mech","Civil"};
    String Name,Rollno,Option,dept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        e2 =(EditText)findViewById(R.id.Rollno);
        e1 =(EditText)findViewById(R.id.Name);
        e3=(EditText)findViewById(R.id.Option);
        bt= (Button) findViewById(R.id.button);
        s= (Spinner) findViewById(R.id.spinner);

        Insert=(Button)findViewById(R.id.Insert);
        Delete=(Button)findViewById(R.id.Delete);
        Update=(Button)findViewById(R.id.Update);
        View=(Button)findViewById(R.id.View);
        ViewAll=(Button)findViewById(R.id.ViewAll);

        Insert.setOnClickListener(this);
        Delete.setOnClickListener(this);
        Update.setOnClickListener(this);
        View.setOnClickListener(this);
        ViewAll.setOnClickListener(this);
        // Creating database and table
        db=openOrCreateDatabase("StudentDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS student(rollno VARCHAR,name VARCHAR,marks VARCHAR);");



        ArrayAdapter adapter= new
                ArrayAdapter(MainActivity2.this,android.R.layout.simple_spinner_item,dept_array);
        s.setAdapter(adapter);
        bt.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {

                //Getting the Values from Views(Edittext & Spinner)
                Name = e1.getText().toString();
                Rollno = e2.getText().toString();
                Option = e3.getText().toString();
                dept = s.getSelectedItem().toString();

                Intent i = new Intent(MainActivity2.this, SecondActivity.class);
                //For Passing the Values to Second Activity
                i.putExtra("name_key", Name);
                i.putExtra("reg_key", Rollno);
                i.putExtra("opt_key", Option);
                i.putExtra("dept_key", dept);
                startActivity(i);
                finish();
///////////////////////////////////////////////////////////////////////
                if (view == bt) {
                    Cursor c = db.rawQuery("SELECT * FROM student", null);
                    if (c.getCount() == 0) {
                        showMessage("Error", "No records found");
                        return;
                    }
                    StringBuffer buffer = new StringBuffer();
                  while (c.moveToNext()) {
                        buffer.append("Rollno: " + c.getString(0) + "\n");
                        buffer.append("Name: " + c.getString(1) + "\n");
                        buffer.append("Marks: " + c.getString(2) + "\n\n");
                    }
                    showMessage("Student Details", buffer.toString());


              }

            }
        });



    }
    public void onClick(android.view.View view) {
        // Inserting a record to the Student table
        if (view == Insert) {
            // Checking for empty fields
            if (e2.getText().toString().trim().length() == 0 ||
                    e1.getText().toString().trim().length() == 0 ||
                    e3.getText().toString().trim().length() == 0) {
                showMessage("Error", "Please enter all values");
                return;
            }
            db.execSQL("INSERT INTO student VALUES('" + e2.getText() + "','" + e1.getText() +
                    "','" + e3.getText() + "');");
            showMessage("Success", "Record added");
            clearText();
        }
        // Deleting a record from the Student table
        if (view == Delete) {
            // Checking for empty roll number
            if (e2.getText().toString().trim().length() == 0) {
                showMessage("Error", "Please enter Rollno");
                return;
            }
            Cursor c = db.rawQuery("SELECT * FROM student WHERE rollno='" + e2.getText() + "'", null);
            if (c.moveToFirst()) {
                db.execSQL("DELETE FROM student WHERE rollno='" + e2.getText() + "'");
                showMessage("Success", "Record Deleted");
            } else {
                showMessage("Error", "Invalid Rollno");
            }
            clearText();
        }
        // Updating a record in the Student table
        if (view == Update) {
            // Checking for empty roll number
            if (e2.getText().toString().trim().length() == 0) {
                showMessage("Error", "Please enter Rollno");
                return;
            }
            Cursor c = db.rawQuery("SELECT * FROM student WHERE rollno='" + e2.getText() + "'", null);
            if (c.moveToFirst()) {
                db.execSQL("UPDATE student SET name='" + e1.getText() + "',marks='" + e3.getText() +
                        "' WHERE rollno='" + e2.getText() + "'");
                showMessage("Success", "Record Modified");
            } else {
                showMessage("Error", "Invalid Rollno");
            }
            clearText();
        }
        // Display a record from the Student table
        if (view == View) {
            // Checking for empty roll number
            if (e2.getText().toString().trim().length() == 0) {
                showMessage("Error", "Please enter Rollno");
                return;
            }
            Cursor c = db.rawQuery("SELECT * FROM student WHERE rollno='" + e2.getText() + "'", null);
            if (c.moveToFirst()) {
                e1.setText(c.getString(1));
                e3.setText(c.getString(2));
            } else {
                showMessage("Error", "Invalid Rollno");
                clearText();
            }
        }
        // Displaying all the records
        if (view == ViewAll) {
            Cursor c = db.rawQuery("SELECT * FROM student", null);
            if (c.getCount() == 0) {
                showMessage("Error", "No records found");
                return;
            }
            StringBuffer buffer = new StringBuffer();
            while (c.moveToNext()) {
                buffer.append("Rollno: " + c.getString(0) + "\n");
                buffer.append("Name: " + c.getString(1) + "\n");
                buffer.append("Option: " + c.getString(2) + "\n\n");


               // Intent i = new Intent(MainActivity2.this,viewall.class);
               // i.putExtra("name_key", Name);
               // i.putExtra("reg_key", Rollno);
               // i.putExtra("opt_key", Option);
              //  startActivity(i);

            }
            showMessage("Student Details", buffer.toString());


        }
    }
    public void showMessage(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);

        builder.setMessage(message);
        builder.show();
    }
    public void clearText()
    {
        e2.setText("");
        e1.setText("");
        e3.setText("");
        e2.requestFocus();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}
