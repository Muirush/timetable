package com.galoppingtech.chukauniversitytimetabling;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.sql.Blob;

public class fsetBbHelper extends SQLiteOpenHelper {
    public  static final  String DB_NAME = "FSET.db";
    public fsetBbHelper(@Nullable Context context) {
        super(context, "FSET.db", null, 1);


    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table fset(faculty TEXT, image BLOB)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists fset");
    }
    public boolean insertTimetable(String fset, String image){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("faculty", fset);
        contentValues.put("image", String.valueOf(image));


        long result  = db.insert("fset", null, contentValues);

        if (result == -1){
            return false;

        }else
            return true;
    }
    public  boolean getImage(Blob image){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor1 = db.rawQuery("select * from fset where text ='fset'" , new String[]{String.valueOf(image)});
        if (cursor1.getCount()> 0){
            return  true;
        }else  return false;
    }
    public boolean getAll(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor1 = db.rawQuery("select * from fset where text ='fset'" , new String[]{name});
        if (cursor1.getCount()> 0){
            return  true;
        }else  return false;

    }

}
