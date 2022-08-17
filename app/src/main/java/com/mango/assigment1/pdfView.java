package com.mango.assigment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.pdfview.PDFView;

import java.io.File;

public class pdfView extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_view);
        PDFView pdf=findViewById(R.id.PDFView);
        File file = (File) getIntent().getSerializableExtra("File");
        Toast.makeText(this, ""+file.exists(), Toast.LENGTH_SHORT).show();
        pdf.fromFile(file).show();
    }
}