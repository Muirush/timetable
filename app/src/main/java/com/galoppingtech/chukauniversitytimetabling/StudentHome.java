package com.galoppingtech.chukauniversitytimetabling;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.galoppingtech.chukauniversitytimetabling.databinding.ActivityStudentHomeBinding;
import com.galoppingtech.chukauniversitytimetabling.databinding.ActivityStudentLoginBinding;

public class StudentHome extends AppCompatActivity {
    ActivityStudentHomeBinding binding;
    fsetBbHelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_student_home);

        getSupportActionBar().setTitle("HOME");
        Intent intent = getIntent();
        String faculty = intent.getExtras().getString("faculty");


        getSupportActionBar().setTitle(faculty);

//        boolean checkUP = dbhelper.getAll(faculty);
//        if (checkUP == true){
//            Toast.makeText(this, "Almost", Toast.LENGTH_SHORT).show();
//           }
    }
}