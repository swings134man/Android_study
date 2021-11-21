package com.aaa.mobile11;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyDBHelper extends SQLiteOpenHelper {
    // 생성자
    public MyDBHelper(@Nullable Context context) {
        super(context, "groupDB", null, 1);
        Log.d("sqlite3DDL" , "Database 생성 호출함 !!!!");
        // 클래스 실행시 groupDB 라는 DB 생성
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE groupTBL (gName char(20), gNumber INTEGER);"); // db TABLE 생성 SQL 문
        Log.d("sqlite3DDL" , "create table 호출함 !!!!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS groupTBL"); //db 가 존재할시 삭제하라는 SQL
        Log.d("sqlite3DDL" , "DDL 호출함 !!!!");
        onCreate(db);  // 있으면 지우고 DB를 다시 만들어라. 자시자신 메서드 호출.
    }


}// class
