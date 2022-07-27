package com.mango.assigment1;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class SemesterRegistrationForm implements Parcelable {

    private int ClassId;
    private String Department;
    private String StudentName;
    private int LastSemesterAttended;
    private List previousSemesterGPA =new ArrayList<PreviousSemesterGPA>();
    private List registerCourse = new ArrayList<RegisterCourse>();
    private String challanNO;
    private int imgIndex;

    protected SemesterRegistrationForm(Parcel in) {
        ClassId = in.readInt();
        Department = in.readString();
        StudentName = in.readString();
        LastSemesterAttended = in.readInt();
        challanNO = in.readString();
        imgIndex = in.readInt();
    }

    public static final Creator<SemesterRegistrationForm> CREATOR = new Creator<SemesterRegistrationForm>() {
        @Override
        public SemesterRegistrationForm createFromParcel(Parcel in) {
            return new SemesterRegistrationForm(in);
        }

        @Override
        public SemesterRegistrationForm[] newArray(int size) {
            return new SemesterRegistrationForm[size];
        }
    };

    public int getClassId() {
        return ClassId;
    }

    public void setClassId(int classId) {
        ClassId = classId;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public int getLastSemesterAttended() {
        return LastSemesterAttended;
    }

    public void setLastSemesterAttended(int lastSemesterAttended) {
        LastSemesterAttended = lastSemesterAttended;
    }

    public List getPreviousSemesterGPA() {
        return previousSemesterGPA;
    }

    public void setPreviousSemesterGPA(List previousSemesterGPA) {
        this.previousSemesterGPA = previousSemesterGPA;
    }

    public List getRegisterCourse() {
        return registerCourse;
    }

    public void setRegisterCourse(List registerCourse) {
        this.registerCourse = registerCourse;
    }

    public String getChallanNO() {
        return challanNO;
    }

    public void setChallanNO(String challanNO) {
        this.challanNO = challanNO;
    }

    public int getImgIndex() {
        return imgIndex;
    }

    public void setImgIndex(int imgIndex) {
        this.imgIndex = imgIndex;
    }

    public SemesterRegistrationForm(int classId, String department, String studentName, int lastSemesterAttended, List previousSemesterGPA, List registerCourse, String challanNO, int imgIndex) {
        ClassId = classId;
        Department = department;
        StudentName = studentName;
        LastSemesterAttended = lastSemesterAttended;
        this.previousSemesterGPA = previousSemesterGPA;
        this.registerCourse = registerCourse;
        this.challanNO = challanNO;
        this.imgIndex = imgIndex;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ClassId);
        dest.writeString(Department);
        dest.writeString(StudentName);
        dest.writeInt(LastSemesterAttended);
        dest.writeString(challanNO);
        dest.writeInt(imgIndex);
    }
}
