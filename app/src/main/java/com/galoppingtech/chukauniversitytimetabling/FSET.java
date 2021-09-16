package com.galoppingtech.chukauniversitytimetabling;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;

import com.galoppingtech.chukauniversitytimetabling.databinding.ActivityFsetBinding;

import java.io.ByteArrayOutputStream;

public class FSET extends AppCompatActivity {
    private ActivityFsetBinding binding;
    private fsetBbHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_fset);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
        helper = new fsetBbHelper(this);
        getSupportActionBar().setTitle("FSET Timetable");



    }



    public void FSET_SELECT(View view) {


    }

    public void uploadFSET(View view) {
        String image_name = Environment.getExternalStorageDirectory().getPath()+"fset"+".jpeg";
        Bitmap bitmap = BitmapFactory.decodeFile(image_name);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes = byteArrayOutputStream.toByteArray();
        boolean insert = helper.insertTimetable("fset",image_name);
        if (insert == true){
            Toast.makeText(FSET.this, "Timetable added", Toast.LENGTH_SHORT).show();
        }else Toast.makeText(FSET.this, "Error", Toast.LENGTH_SHORT).show();
    }
}