package com.example.authenticationapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class DataEntry extends AppCompatActivity {

    // creating variables for
    // EditText and buttons.
    private EditText studentName, studentUsn, studentdetails;
    private Button sendDatabtn;
    private ListView listView;


    // creating a variable for our
    // Firebase Database.
    FirebaseDatabase firebaseDatabase;

    // creating a variable for our Database
    // Reference for Firebase.
    DatabaseReference databaseReference;

    // creating a variable for
    // our object class
    StudentInfo studentInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_entry);

        // initializing our edittext and button
        studentName = findViewById(R.id.idEdtStudentName);
        studentUsn = findViewById(R.id.idEdtStudentUsn);
        studentdetails = findViewById(R.id.idEdtStudentdetails);
        listView=findViewById(R.id.idLVCourses);

        // below line is used to get the
        // instance of our FIrebase database.
        firebaseDatabase = FirebaseDatabase.getInstance();

        // below line is used to get reference for our database.
        databaseReference = firebaseDatabase.getReference("StudentInfo");

        // initializing our object
        // class variable.
        studentInfo = new StudentInfo();

        sendDatabtn = findViewById(R.id.idBtnSendData);

        // adding on click listener for our button.
        sendDatabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // getting text from our edittext fields.
                String name = studentName.getText().toString();
                String usn = studentUsn.getText().toString();
                String details = studentdetails.getText().toString();

                // below line is for checking weather the
                // edittext fields are empty or not.
                if (TextUtils.isEmpty(name) && TextUtils.isEmpty(usn) && TextUtils.isEmpty(details)) {
                    // if the text fields are empty
                    // then show the below message.
                    Toast.makeText(DataEntry.this, "Please add some data.", Toast.LENGTH_SHORT).show();
                } else {
                    // else call the method to add
                    // data to our database.
                    addDatatoFirebase(name, usn, details);
                }
            }
        });



    }

    private void addDatatoFirebase(String name, String usn, String details) {
        // below 3 lines of code is used to set
        // data in our object class.
        studentInfo.setStudentName(name);
        studentInfo.setStudentUsn(usn);
        studentInfo.setStudentdetails(details);

        // we are use add value event listener method
        // which is called with database reference.
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // inside the method of on Data change we are setting
                // our object class to our database reference.
                // data base reference will sends data to firebase.
                databaseReference.setValue(studentInfo);

                // after adding this data we are showing toast message.
                Toast.makeText(DataEntry.this, "data added", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // if the data is not added or it is cancelled then
                // we are displaying a failure toast message.
                Toast.makeText(DataEntry.this, "Fail to add data " + error, Toast.LENGTH_SHORT).show();
            }
        });
    }
}