package com.mango.assigment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView newView;
   static   List data = new ArrayList<SemesterRegistrationForm>();
     List gpaData = new ArrayList<PreviousSemesterGPA>();
     List courseData = new ArrayList<RegisterCourse>();
     List courseData2 = null;
    SemesterRegistrationForm d1=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this,new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);

        gpaData.add(new PreviousSemesterGPA(1, 2.6f));
            gpaData.add(new PreviousSemesterGPA(2, 2.3f));
            gpaData.add(new PreviousSemesterGPA(3, 1.7f));
            gpaData.add(new PreviousSemesterGPA(4, 2.8f));
            gpaData.add(new PreviousSemesterGPA(5, 2.4f));
            gpaData.add(new PreviousSemesterGPA(6, 3.0f));
            gpaData.add(new PreviousSemesterGPA(8, 2.9f));
            gpaData.add(new PreviousSemesterGPA(9, 2.9f));
            gpaData.add(new PreviousSemesterGPA(10, 2.9f));

            courseData.add(new RegisterCourse("BSCS", "CS-256", 3, 1.0f, 'D'));
            courseData.add(new RegisterCourse("BSCS", "SE-108", 2, 0.0f, 'W'));
            courseData.add(new RegisterCourse("BSCS", "BR-204", 3, 0.0f, 'F'));
            courseData.add(new RegisterCourse("BSCS", "CS-256", 3, 1.0f, 'D'));
            courseData.add(new RegisterCourse("BSCS", "SE-108", 2, 0.0f, 'W'));

        if (data.isEmpty()) {
            data.add(new SemesterRegistrationForm(8, "BSCS", "Usama", 6, gpaData, courseData, "1548-5448814-005", 1));
            data.add(new SemesterRegistrationForm(8, "BSCS", "Usama", 6, gpaData, courseData, "5569-7451814-155", 2));
            data.add(new SemesterRegistrationForm(8, "BSIT", "Ahmed", 7, gpaData, courseData, "5569-7451814-155", 2));
            data.add(new SemesterRegistrationForm(8, "BSSE", "Salman", 7, gpaData, courseData, "5569-7451814-155", 1));
            data.add(new SemesterRegistrationForm(8, "BSCS", "Usama", 6, gpaData, courseData, "1548-5448814-005", 1));
            data.add(new SemesterRegistrationForm(8, "BSCS", "Usama", 6, gpaData, courseData, "5569-7451814-155", 2));
            data.add(new SemesterRegistrationForm(8, "BSIT", "Ahmed", 7, gpaData, courseData, "5569-7451814-155", 1));
            data.add(new SemesterRegistrationForm(8, "BSSE", "Salman", 7, gpaData, courseData, "5569-7451814-155", 2));
        }
        newView=findViewById(R.id.recyclerView);
    MyAdopter myAdopter = new MyAdopter(this,data);
    newView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    newView.setAdapter(myAdopter);


    d1= getIntent().getParcelableExtra("Tag2");
    courseData2= (List) getIntent().getSerializableExtra("Tag3");
    Boolean flag =getIntent().getBooleanExtra("Flag",false);
    int Position=getIntent().getIntExtra("Postion",-1);


    if (d1!=null) {
        d1.setPreviousSemesterGPA(gpaData);
        if (courseData2!=null)
            d1.setRegisterCourse(courseData2);

//        Log.i("TAG", "onCreate: "+flag+Position);
            Toast.makeText(this, "Step "+flag+Position, Toast.LENGTH_SHORT).show();

        if (flag){
            Toast.makeText(this, "REmove", Toast.LENGTH_SHORT).show();
            data.remove(Position);
            data.add(Position,d1);
        }

        if(!flag) {

            data.add(d1);
        }
    newView.setAdapter(myAdopter);
    }


    findViewById(R.id.btnNewForm).setOnClickListener(v->{
        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);
    });

    }

}