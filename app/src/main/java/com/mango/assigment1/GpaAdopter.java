package com.mango.assigment1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GpaAdopter extends RecyclerView.Adapter<GpaAdopter.ViewHolder> {
   //1-Data Source
    List<PreviousSemesterGPA> Data;

    public GpaAdopter(List<PreviousSemesterGPA> data) {
        Data = data;
    }


    //2-View Holder Class
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView semester,gpa;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.semester = itemView.findViewById(R.id.semesterView);
            this.gpa = itemView.findViewById(R.id.gpaView);
        }
    }

    //3- Implementaion

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View listItem=inflater.inflate(R.layout.pre_semester_gpa_item,parent,false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PreviousSemesterGPA myData= Data.get(position);
    holder.semester.setText(myData.getSemesterNumber()+"");
    holder.gpa.setText(myData.getObtainedGpa()+"");

    }

    @Override
    public int getItemCount() {
        return Data.size();
    }

}
