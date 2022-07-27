package com.mango.assigment1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Environment;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pdfview.PDFView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

import javax.xml.namespace.QName;

public class MyAdopter extends RecyclerView.Adapter<MyAdopter.ViewHolder> {

    // 1-data Sourec
   Activity activity;
    List<SemesterRegistrationForm> Data;

    public MyAdopter(Activity activity,List data) {
        Data = data;
        this.activity= activity;
    }


    //2-ViewHolder Class
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name,dept,classID,lastSemester,date,challan;
        public ImageView img;
        public RecyclerView gpaView,courseView;
        public Button btnEdit,btnSavePdf;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.nameView);
            this.dept = itemView.findViewById(R.id.departmentView);
            this.classID = itemView.findViewById(R.id.classIdView);
            this.lastSemester = itemView.findViewById(R.id.lastSemesterView);
            this.date = itemView.findViewById(R.id.dateView);
            this.gpaView = itemView.findViewById(R.id.gpaRecycler);
            this.courseView = itemView.findViewById(R.id.registerCourseRecycler);
            this.img = itemView.findViewById(R.id.imgApproveOrNot);
            this.challan = itemView.findViewById(R.id.challanView);
            this.btnEdit = itemView.findViewById(R.id.btnEdit);
            this.btnSavePdf=itemView.findViewById(R.id.btnPdf);
        }
    }


    //3-Implementing the method
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listItem =inflater.inflate(R.layout.form_item,parent,false);
        return new ViewHolder(listItem);
      }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
     SemesterRegistrationForm mydata = Data.get(position);
     List courseRegister = mydata.getRegisterCourse();

    LinearLayoutManager layoutManager1 = new LinearLayoutManager(activity);
    LinearLayoutManager layoutManager2 = new LinearLayoutManager(activity);

        GpaAdopter myAdopter = new GpaAdopter(mydata.getPreviousSemesterGPA());
        holder.gpaView.setLayoutManager(layoutManager1);
        holder.gpaView.setAdapter(myAdopter);

        CourseAdopter courseAdopter =new CourseAdopter(mydata.getRegisterCourse());
        holder.courseView.setLayoutManager(layoutManager2);
        holder.courseView.setAdapter(courseAdopter);

        holder.name.setText(mydata.getStudentName());
        holder.classID.setText(mydata.getClassId()+"");
        holder.date.setText("12/12/2022");
        holder.lastSemester.setText(mydata.getLastSemesterAttended()+"");
        holder.dept.setText(mydata.getDepartment());
        holder.challan.setText(mydata.getChallanNO());
        holder.img.setImageResource(activity.getResources().getIdentifier("a"+mydata.getImgIndex(), "drawable", activity.getPackageName()));
        holder.btnEdit.setOnClickListener(v->{
            Toast.makeText(activity, holder.name.getText()+"", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(activity,MainActivity2.class);
            intent.putExtra("Edit", mydata);
            intent.putExtra("EditCourse", (Serializable) courseRegister);
            intent.putExtra("Postion",position);
            activity.startActivity(intent);
        });
        holder.btnSavePdf.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {
                Bitmap logo,scaledLogo,approveOrNOt,approveOrNOtScaled;
                approveOrNOt = BitmapFactory.decodeResource(activity.getResources(), activity.getResources().getIdentifier("a" + mydata.getImgIndex(), "drawable", activity.getPackageName()));
                approveOrNOtScaled=Bitmap.createScaledBitmap(approveOrNOt,200,200,false);

                logo = BitmapFactory.decodeResource(activity.getResources(), R.drawable.logo_e);
                scaledLogo=Bitmap.createScaledBitmap(logo,500,100,false);
                    PdfDocument pdfDocument = new PdfDocument();
                    Paint paint= new Paint();
                    paint.setTextSize(32);
                    PdfDocument.PageInfo myPageInfo = new PdfDocument.PageInfo.Builder(595,842,1).create();
                    PdfDocument.Page myPage1= pdfDocument.startPage(myPageInfo);

                    Canvas canvas = myPage1.getCanvas();
                    canvas.drawBitmap(scaledLogo,80,50,paint);
                    canvas.drawBitmap(approveOrNOtScaled,390,+630,paint);
                    canvas.drawText("Name:  "+mydata.getStudentName() ,40,190,paint);
                    canvas.drawText("Date:  "+holder.date.getText() ,330,195,paint);
                    canvas.drawText("Class ID:  "+mydata.getClassId() ,40,300,paint);
                    canvas.drawText("Department:    "+mydata.getDepartment() ,40,400,paint);
                    canvas.drawText("Challan NO:    "+mydata.getChallanNO() ,40,500,paint);

                    pdfDocument.finishPage(myPage1);


                    File file = new File(Environment.getExternalStorageDirectory(),"/"+mydata.getStudentName()+mydata.getDepartment()+mydata.getClassId()+".pdf");
                    if(file.exists()){
                        Toast.makeText(activity, "File Hai PLeay say", Toast.LENGTH_SHORT).show();
                        file.delete();
                    }
                    try {
                        Toast.makeText(activity, "Saving pdf file... ", Toast.LENGTH_LONG).show();
                        pdfDocument.writeTo(new FileOutputStream(file));
                        Toast.makeText(activity, "PDF IS Saved ", Toast.LENGTH_LONG).show();
                        } catch (IOException e) {
                        e.printStackTrace();
                        Toast.makeText(activity, "Error Saving File"+e, Toast.LENGTH_LONG).show();

                    }

                    pdfDocument.close();
                    if (file.exists()){
                        Intent intent= new Intent(activity,pdfView.class);
                        intent.putExtra("File",(Serializable) file);
                        activity.startActivity(intent);
                    }



                }
        });
    }

    @Override
    public int getItemCount() {
        return Data.size();
    }






}
