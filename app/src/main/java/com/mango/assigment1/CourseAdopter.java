package com.mango.assigment1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CourseAdopter extends RecyclerView.Adapter<CourseAdopter.ViewHolder>{
   List<RegisterCourse> Data;

    public CourseAdopter(List<RegisterCourse> data) {
        Data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View itemView=inflater.inflate(R.layout.course_item,parent,false);
        return new ViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RegisterCourse myData = Data.get(position);
        holder.titleview.setText(myData.getCourseTitle());
        holder.codeview.setText(myData.getCourseCode());
        holder.chview.setText(myData.getCreditHours()+"");
        holder.gpaview.setText(myData.getGpaInLastAttempt()+"");
        holder.gradeview.setText(myData.getGradeInLastAttempt()+"");

    }

    @Override
    public int getItemCount() {
        return Data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView titleview,codeview,chview,gpaview,gradeview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleview=itemView.findViewById(R.id.titleView);
            codeview=itemView.findViewById(R.id.codeView);
            chview=itemView.findViewById(R.id.chView);
            gpaview=itemView.findViewById(R.id.preGpaView);
            gradeview=itemView.findViewById(R.id.preGradeView);
        }


    }
}
