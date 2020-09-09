package com.example.hp.empowerilliterate;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.HashMap;

public class DBcon extends SQLiteOpenHelper {

    public DBcon(Context context) {
        super(context, "empower", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql1 = "create table if not exists hirer(id integer primary key autoincrement,name text,email text,pwd text,phn text,addr text)";
        db.execSQL(sql1);
        String sql2 = "create table if not exists hiree(id integer primary key autoincrement,name text,email text,pass text,phn text,addr text,doy text,yow text,work text)";
        db.execSQL(sql2);
        String sql3="create table if not exists search(id integer primary key autoincrement,hr text,he text,date text,phn text)";
        db.execSQL(sql3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table hirer if already exists");
        db.execSQL("drop table hiree if not exists");
        db.execSQL("drop table search if not exists");
        onCreate(db);


    }

    public void insert_hirer(HashMap<String, String> map) {
        SQLiteDatabase sb = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", map.get("name"));
        cv.put("email", map.get("email"));
        cv.put("pwd", map.get("pwd"));
        cv.put("phn", map.get("phn"));
        cv.put("addr", map.get("add"));
        sb.insert("hirer", null, cv);
    }

    public void insert_hiree(HashMap<String, String> map)
    {
        SQLiteDatabase sb=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name",map.get("name"));
        cv.put("email",map.get("email"));
        cv.put("pass",map.get("pass"));
        cv.put("phn",map.get("phn"));
        cv.put("addr",map.get("addr"));
        cv.put("doy",map.get("doy"));
        cv.put("yow",map.get("yow"));
        cv.put("work",map.get("work"));
        sb.insert("hiree",null,cv);
    }
    public void insert_search(HashMap<String,String> map)
    {
        SQLiteDatabase sb=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("hr",map.get("hr"));
        cv.put("he",map.get("he"));
        cv.put("date",map.get("date"));
        cv.put("phn",map.get("phn"));
        sb.insert("search",null,cv);

    }

}
