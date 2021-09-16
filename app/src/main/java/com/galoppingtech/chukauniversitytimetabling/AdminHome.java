package com.galoppingtech.chukauniversitytimetabling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdminHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
    }

    public void gotToFSET(View view) {
        Intent tent = new Intent(AdminHome.this, FSET.class);
        startActivity(tent);
    }
}