package com.example.authenticationapp;

public class StudentInfo {

    // string variable for
    // storing employee name.
    private String studentName;

    // string variable for storing
    // employee contact number
    private String studentUsn;

    // string variable for storing
    // employee address.
    private String studentdetails;

    // an empty constructor is
    // required when using
    // Firebase Realtime Database.
    public StudentInfo() {


}
    // created getter and setter methods
    // for all our variables.
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentUsn() {
        return studentUsn;
    }

    public void setStudentUsn(String studentUsn) {
        this.studentUsn = studentUsn;
    }

    public String getStudentdetails() {
        return studentdetails;
    }

    public void setStudentdetails(String studentdetails) {
        this.studentdetails = studentdetails;
    }
}


