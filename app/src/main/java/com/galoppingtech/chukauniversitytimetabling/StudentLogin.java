package com.galoppingtech.chukauniversitytimetabling;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.galoppingtech.chukauniversitytimetabling.databinding.ActivityStudentLoginBinding;

import java.util.Locale;

public class StudentLogin extends AppCompatActivity {
    ActivityStudentLoginBinding binding;
    studentDbhelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding = DataBindingUtil.setContentView(this, R.layout.activity_student_login);
        getSupportActionBar().setTitle("Student Login-Chuka University");
        dbhelper = new studentDbhelper(this);

    }

    public void logInStudentFunction(View view) {
        String studentfaculty = binding.loginFaculty.getText().toString().toLowerCase(Locale.ROOT);
        String studentnumber =  binding.loginStudentRegno.getText().toString();
        String studentpassword = binding.loginStudentPassword.getText().toString();
        if (TextUtils.isEmpty(studentnumber) || TextUtils.isEmpty(studentpassword) || TextUtils.isEmpty(studentfaculty)){
            Toast.makeText(this, "Both fields should be filled", Toast.LENGTH_SHORT).show();
        }
        else {
            boolean checkUP = dbhelper.loginStudent(studentnumber,studentpassword);
            if (checkUP == true){
                Intent intent = new Intent(StudentLogin.this, StudentHome.class);
                intent.putExtra("faculty",studentfaculty);
                startActivity(intent);
                finish();
            }else
                Toast.makeText(StudentLogin.this, "Invalid log in", Toast.LENGTH_SHORT).show();
        }
    }

    public void forgotStudentPwd(View view) {
        Toast.makeText(this, "Show password recovery  Dialog", Toast.LENGTH_SHORT).show();
    }

    public void goToStudentReg(View view) {
        Intent intent = new Intent(StudentLogin.this, StudentRegister.class);
        startActivity(intent);
    }
}