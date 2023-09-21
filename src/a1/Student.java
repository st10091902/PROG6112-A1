package a1;

import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int studentID;
    String studentName;
    int studentAge;
    String studentEmail;
    String studentCourse;

    public Student(int studentID, String studentName, int studentAge, String studentEmail, String studentCourse) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentEmail = studentEmail;
        this.studentCourse = studentCourse;
    }

    public int getStudentID() {
        return studentID;
    }

    public String toString() {
        return "Student ID: " + studentID +
               "\nStudent Name: " + studentName +
               "\nSTUDENT AGE: " + studentAge +
               "\nSTUDENT EMAIL: " + studentEmail +
               "\nSTUDENT COURSE: " + studentCourse;
    }
}