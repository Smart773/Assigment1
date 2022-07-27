package com.mango.assigment1;

import android.os.Parcel;
import android.os.Parcelable;

public class PreviousSemesterGPA implements Parcelable {
    int semesterNumber;
    float obtainedGpa;

    protected PreviousSemesterGPA(Parcel in) {
        semesterNumber = in.readInt();
        obtainedGpa = in.readFloat();
    }

    public static final Creator<PreviousSemesterGPA> CREATOR = new Creator<PreviousSemesterGPA>() {
        @Override
        public PreviousSemesterGPA createFromParcel(Parcel in) {
            return new PreviousSemesterGPA(in);
        }

        @Override
        public PreviousSemesterGPA[] newArray(int size) {
            return new PreviousSemesterGPA[size];
        }
    };

    public int getSemesterNumber() {
        return semesterNumber;
    }

    public void setSemesterNumber(int semesterNumber) {
        this.semesterNumber = semesterNumber;
    }

    public float getObtainedGpa() {
        return obtainedGpa;
    }

    public void setObtainedGpa(float obtainedGpa) {
        this.obtainedGpa = obtainedGpa;
    }

    public PreviousSemesterGPA(int semesterNumber, float obtainedGpa) {
        this.semesterNumber = semesterNumber;
        this.obtainedGpa = obtainedGpa;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(semesterNumber);
        dest.writeFloat(obtainedGpa);
    }
}
