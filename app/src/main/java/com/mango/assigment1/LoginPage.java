package com.mango.assigment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class LoginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        findViewById(R.id.btnSign).setOnClickListener(v->{
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        });
        findViewById(R.id.regText).setOnClickListener(v->{
            Intent intent = new Intent(this,RegistrationPage.class);
            startActivity(intent);
        });
    }
}