package com.mango.assigment1;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class RegisterCourse implements Serializable {
    String courseTitle;
    String courseCode;
    int creditHours;
    float gpaInLastAttempt;
    Character gradeInLastAttempt;


    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public float getGpaInLastAttempt() {
        return gpaInLastAttempt;
    }

    public void setGpaInLastAttempt(float gpaInLastAttempt) {
        this.gpaInLastAttempt = gpaInLastAttempt;
    }

    public Character getGradeInLastAttempt() {
        return gradeInLastAttempt;
    }

    public void setGradeInLastAttempt(Character gradeInLastAttempt) {
        this.gradeInLastAttempt = gradeInLastAttempt;
    }

    public RegisterCourse(String courseTitle, String courseCode, int creditHours, float gpaInLastAttempt, Character gradeInLastAttempt) {
        this.courseTitle = courseTitle;
        this.courseCode = courseCode;
        this.creditHours = creditHours;
        this.gpaInLastAttempt = gpaInLastAttempt;
        this.gradeInLastAttempt = gradeInLastAttempt;
    }


}
