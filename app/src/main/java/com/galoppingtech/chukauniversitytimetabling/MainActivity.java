package com.galoppingtech.chukauniversitytimetabling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
    }

    public void goToStudentLog(View view) {
        Intent intent = new Intent(MainActivity.this,StudentLogin.class);
        startActivity(intent);
    }

    public void goToAdminLog(View view) {
        Intent intent = new Intent(MainActivity.this,AdminLogin.class);
        startActivity(intent);
    }
}