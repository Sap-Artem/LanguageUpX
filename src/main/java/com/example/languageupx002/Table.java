package com.example.languageupx002;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Table extends SQLiteOpenHelper {
    public static final int DATA_VERSION = 1;
    public static final String DATA_NAME = "name";
    public static final String TABLE_CON = "tablelol";
    public static int k = 0;
    public static int right = 0;
    public static int fail = 0;
    public static int rand1 = 0;
    public static int rand2 = 0;
    public static int conserve = 0;
    public static int win = 0;
    public static int chet = 0;
    public static int flag = 0;
    public static int reserve_id = 0;
    public Table(Context context) {
        super(context, DATA_NAME, null, DATA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_CON + k);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_CON);
        onCreate(db);

    }
}
