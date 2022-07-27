    package com.mango.assigment1;

    import androidx.appcompat.app.AppCompatActivity;

    import android.content.Intent;
    import android.os.Bundle;
    import android.os.Parcelable;
    import android.util.Log;
    import android.widget.EditText;
    import android.widget.Toast;

    import java.io.Serializable;
    import java.util.ArrayList;
    import java.util.Date;
    import java.util.List;

    public class MainActivity3 extends AppCompatActivity {

        EditText txtTitle1,txtTitle2,txtTitle3,txtTitle4,txtTitle5;
        EditText txtCode1,txtCode2,txtCode3,txtCode4,txtCode5;
        EditText txtch1,txtch2,txtch3,txtch4,txtch5;
        EditText txtGrade1,txtGrade2,txtGrade3,txtGrade4,txtGrade5;
        EditText txtgpa1,txtgpa2,txtgpa3,txtgpa4,txtgpa5;
        List Data=new ArrayList<RegisterCourse>();
        SemesterRegistrationForm d=null;
        List courseEdit=null;
        Boolean flag=false;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main3);
            txtTitle1=findViewById(R.id.txtTitle1);
            txtTitle2=findViewById(R.id.txtTitle2);
            txtTitle3=findViewById(R.id.txtTitle3);
            txtTitle4=findViewById(R.id.txtTitle4);
            txtTitle5=findViewById(R.id.txtTitle5);

            txtCode1=findViewById(R.id.txtCode1);
            txtCode2=findViewById(R.id.txtCode2);
            txtCode3=findViewById(R.id.txtCode3);
            txtCode4=findViewById(R.id.txtCode4);
            txtCode5=findViewById(R.id.txtCode5);

            txtch1=findViewById(R.id.txtch1);
            txtch2=findViewById(R.id.txtch2);
            txtch3=findViewById(R.id.txtch3);
            txtch4=findViewById(R.id.txtch4);
            txtch5=findViewById(R.id.txtch5);

            txtGrade1=findViewById(R.id.txtgrade1);
            txtGrade2=findViewById(R.id.txtgrade2);
            txtGrade3=findViewById(R.id.txtgrade3);
            txtGrade4=findViewById(R.id.txtgrade4);
            txtGrade5=findViewById(R.id.txtgrade5);

            txtgpa1=findViewById(R.id.txtgpa1);
            txtgpa2=findViewById(R.id.txtgpa2);
            txtgpa3=findViewById(R.id.txtgpa3);
            txtgpa4=findViewById(R.id.txtgpa4);
            txtgpa5=findViewById(R.id.txtgpa5);

            d=getIntent().getParcelableExtra("Tag1");
            courseEdit= (List) getIntent().getSerializableExtra("Edit");
            int Position=getIntent().getIntExtra("Postion",-1);
            if (courseEdit!=null){
                flag=true;
                Toast.makeText(this, "Entered "+ courseEdit.size(), Toast.LENGTH_SHORT).show();
                setDataToUI();
                Toast.makeText(this, ""+Position, Toast.LENGTH_SHORT).show();
            }

            findViewById(R.id.btnPre).setOnClickListener(v -> {
                Intent intent = new Intent(this,MainActivity2.class);
                startActivity(intent);
            });
            findViewById(R.id.btnSubmit).setOnClickListener(v->{
                Intent intent = new Intent(this,MainActivity.class);
                if(isRowEmpty(txtTitle1,txtCode1,txtch1,txtgpa1,txtGrade1)){
                    Toast.makeText(this, "PLease! At Least Fill First Row", Toast.LENGTH_SHORT).show();
                return;
                }
                Data.add(GenrateData(txtTitle1,txtCode1,txtch1,txtgpa1,txtGrade1));
                if(!isRowEmpty(txtTitle2,txtCode2,txtch2,txtgpa2,txtGrade2))
                Data.add(GenrateData(txtTitle2,txtCode2,txtch2,txtgpa2,txtGrade2));
                if(!isRowEmpty(txtTitle3,txtCode3,txtch3,txtgpa3,txtGrade3))
                Data.add(GenrateData(txtTitle3,txtCode3,txtch3,txtgpa3,txtGrade3));
                if(!isRowEmpty(txtTitle4,txtCode4,txtch4,txtgpa4,txtGrade4))
                Data.add(GenrateData(txtTitle4,txtCode4,txtch4,txtgpa4,txtGrade4));
                if(!isRowEmpty(txtTitle5,txtCode5,txtch5,txtgpa5,txtGrade5))
                Data.add(GenrateData(txtTitle5,txtCode5,txtch5,txtgpa5,txtGrade5));



                Log.i("TAG", "onCreate: "+Data.isEmpty());

                intent.putExtra("Tag2",d);
                intent.putExtra("Tag3",(Serializable) Data);
                intent.putExtra("Postion",(int) Position);
                intent.putExtra("Flag",(Boolean) flag);
                startActivity(intent);

            });
        }

        public  void setDataToUI(){
        if (courseEdit.size()<1)return;
        setGUIBlock(0,txtTitle1,txtCode1,txtch1,txtgpa1,txtGrade1);
        if (courseEdit.size()<2)return;
        setGUIBlock(1,txtTitle2,txtCode2,txtch2,txtgpa2,txtGrade2);
        if (courseEdit.size()<3)return;
        setGUIBlock(2,txtTitle3,txtCode3,txtch3,txtgpa3,txtGrade3);
        if (courseEdit.size()<4)return;
        setGUIBlock(3,txtTitle4,txtCode4,txtch4,txtgpa4,txtGrade4);
        if (courseEdit.size()<5)return;
        setGUIBlock(4,txtTitle5,txtCode5,txtch5,txtgpa5,txtGrade5);
        }

        private void setGUIBlock(int z,EditText a,EditText b,EditText c,EditText d,EditText e){
            RegisterCourse Dummy = (RegisterCourse) courseEdit.get(z);
            a.setText(Dummy.getCourseTitle()+"");
            b.setText(Dummy.getCourseCode()+"");
            c.setText(Dummy.getCreditHours()+"");
            d.setText(Dummy.getGpaInLastAttempt()+"");
            e.setText(Dummy.getGradeInLastAttempt()+"");
        }

        private  boolean isRowEmpty(EditText a,EditText b,EditText c,EditText d,EditText e){
            if(a.getText().length()==0)return true;
            if(b.getText().length()==0)return true;
            if(c.getText().length()==0)return true;
            if(d.getText().length()==0)return true;
            if(e.getText().length()==0)return true;
            return false;
        }

        private  RegisterCourse GenrateData(EditText a,EditText b,EditText c,EditText d,EditText e){
            String Title= a.getText().toString();
            String Code= b.getText().toString();
            int ch= Integer.parseInt(c.getText().toString());
            float gpa =Float.parseFloat(d.getText().toString());
            Character cd= e.getText().toString().charAt(0);
            return  new RegisterCourse(
                    Title,
                    Code,
                    ch,
                    gpa,
                    cd
            );
        }

    }