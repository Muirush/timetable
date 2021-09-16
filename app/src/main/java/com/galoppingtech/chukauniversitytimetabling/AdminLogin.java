package com.galoppingtech.chukauniversitytimetabling;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.galoppingtech.chukauniversitytimetabling.databinding.ActivityAdminLoginBinding;

public class AdminLogin extends AppCompatActivity {
    private ActivityAdminLoginBinding bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = DataBindingUtil.setContentView(this, R.layout.activity_admin_login);
        getSupportActionBar().setTitle("Admin Login-Chuka University");

    }

    public void forgotAdminPwd(View view) {
        Toast.makeText(this, "Dialog to open", Toast.LENGTH_SHORT).show();
    }

    public void logInAdminFunction(View view) {
        String adminusername = bind.adminUsername.getText().toString();
        String adminpassword = bind.adminPassword.getText().toString();
        if(TextUtils.isEmpty(adminusername)){
            bind.adminUsername.setError("Username required");
        }
        if (TextUtils.isEmpty(adminpassword)) {
            bind.adminPassword.setError("Password required");
        }
        if (adminusername.equals("Admin")&&adminpassword.equals("Admin123")){
            Intent intent = new Intent(AdminLogin.this, AdminHome.class);
            startActivity(intent);}
        else {
            Toast.makeText(this, "Invalid log in credentials", Toast.LENGTH_SHORT).show();
        }
    }
}