package com.galoppingtech.chukauniversitytimetabling;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.style.EasyEditSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.galoppingtech.chukauniversitytimetabling.databinding.ActivityStudentLoginBinding;
import com.galoppingtech.chukauniversitytimetabling.databinding.ActivityStudentRegisterBinding;

public class StudentRegister extends AppCompatActivity {
    ActivityStudentRegisterBinding binding;
    EditText sName,sRegno,sYear, sFaculty, sDepartment, sPassword, sPassword1;
    Button registerBtn;
    studentDbhelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_student_register);
        getSupportActionBar().hide();
        sName = (EditText) findViewById(R.id.regFullname);
        sRegno = (EditText) findViewById(R.id.regRegno);
        sYear = (EditText) findViewById(R.id.regYearofStudy);
        sFaculty = (EditText) findViewById(R.id.regFaculty);
        sDepartment = (EditText) findViewById(R.id.regDepartment);
        sPassword = (EditText) findViewById(R.id.regPassword);
        sPassword1 = (EditText) findViewById(R.id.regPassword1);
        dbhelper = new studentDbhelper(this);

        registerBtn = (Button) findViewById(R.id.studentRegister);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerFunction();
            }
        });

    }

    private void registerFunction() {
        String name = sName.getText().toString();
        String regno = sRegno.getText().toString();
        String year = sYear.getText().toString();
        String faculty = sFaculty.getText().toString();
        String department = sDepartment.getText().toString();
        String password = sPassword.getText().toString();
        String password1 = sPassword1.getText().toString();
        if (!password.equals(password1)){
            Toast.makeText(this, "Password do not match", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(name)||TextUtils.isEmpty(regno)||TextUtils.isEmpty(year)||
        TextUtils.isEmpty(faculty)||TextUtils.isEmpty(department)|| TextUtils.isEmpty(password)|| TextUtils.isEmpty(password1)){
            Toast.makeText(this, "Kindly fill in all views", Toast.LENGTH_SHORT).show();
        }
        else{
            boolean insert = dbhelper.insertStudent(name,regno,year,faculty,department,password);
            if (insert == true){
                Toast.makeText(StudentRegister.this, "User created", Toast.LENGTH_SHORT).show();
            }else Toast.makeText(StudentRegister.this, "Error", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(StudentRegister.this, StudentLogin.class);
            startActivity(intent);
            finish();
        }
    }

    public void backToLogin(View view) {
        Intent intent = new Intent(StudentRegister.this, StudentLogin.class);
        startActivity(intent);
    }
}