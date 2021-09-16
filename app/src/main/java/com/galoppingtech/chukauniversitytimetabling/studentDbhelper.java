package com.galoppingtech.chukauniversitytimetabling;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class studentDbhelper extends SQLiteOpenHelper {
    public  static final  String DB_NAME = "Students.db";

    public studentDbhelper(@Nullable Context context) {
        super(context, "Students.db", null, 1);

    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table students(name TEXT,regno VARCHAR,year VARCHAR, faculty TEXT,department TEXT, password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists students");

    }
    public boolean insertStudent( String name, String regno, String year,
                                 String faculty, String department, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("name", name);
        contentValues.put("regno", regno);
        contentValues.put("year", year);
        contentValues.put("faculty", faculty);
        contentValues.put("department", department);
        contentValues.put("password", password);

        long result  = db.insert("students", null, contentValues);

        if (result == -1){
            return false;

        }else
            return true;
    }

    public  boolean loginStudent(String regno, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor1 = db.rawQuery("select * from students where regno = ? and password = ?", new String[]{regno,password});
        if (cursor1.getCount()> 0){
            return  true;
        }else  return false;
    }
}
