package com.mango.assigment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    SemesterRegistrationForm data;
    EditText classid,name,dept,challan,lastSemester;
    SemesterRegistrationForm dataEdit;
    List courseEdit=null;
    Boolean flag=false;
    int Position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name=findViewById(R.id.txtName);
        classid=findViewById(R.id.txtClassId);
        dept=findViewById(R.id.txtDept);
        challan=findViewById(R.id.txtChallanNo);
        lastSemester=findViewById(R.id.txtLastSemesterAttended);

        dataEdit=getIntent().getParcelableExtra("Edit");
        Position=getIntent().getIntExtra("Postion",-1);

        if(dataEdit!=null) {
            Toast.makeText(this, "Entered " + dataEdit.getRegisterCourse().isEmpty(), Toast.LENGTH_LONG).show();
            setDataToUI(classid, name, dept, challan, lastSemester);
                flag=true;
                courseEdit = (List) getIntent().getSerializableExtra("EditCourse");
        }

        findViewById(R.id.btnNextPage).setOnClickListener(v->{
            Intent intent = new Intent(this,MainActivity3.class);
            if (name.getText().length()==0||classid.getText().length()==0||dept.getText().length()==0||challan.getText().length()==0||lastSemester.getText().length()==0){
                Toast.makeText(this, "Some Fields Are Missing Please fill Those", Toast.LENGTH_SHORT).show();
                return;
            }
            int ClassId = Integer.parseInt(classid.getText().toString());
            String Department = dept.getText().toString();
            String StudentName =name.getText().toString();
            int LastSemesterAttended=Integer.parseInt(lastSemester.getText().toString());
            String Challan = challan.getText().toString();
            int img=2;
            data= new SemesterRegistrationForm(ClassId,Department,StudentName,LastSemesterAttended,null,null,Challan,img);
                intent.putExtra("Tag1", data);
                if(flag){
                    intent.putExtra("Edit", (Serializable) courseEdit);
                    intent.putExtra("Postion",Position);
                    Toast.makeText(this, ""+Position, Toast.LENGTH_SHORT).show();
                }
            startActivity(intent);
        });
    }

    public  void setDataToUI(EditText classid,EditText name,EditText dept,EditText challan,EditText lastSemester){

        name.setText(dataEdit.getStudentName()+"");
        classid.setText(dataEdit.getClassId()+"");
        dept.setText(dataEdit.getDepartment()+"");
       challan .setText(dataEdit.getChallanNO()+"");
        lastSemester.setText(dataEdit.getLastSemesterAttended()+"");
    }
}