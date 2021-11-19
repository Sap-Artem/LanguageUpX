package com.example.languageupx002;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Test extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String BASE_NAME = "contactTest";
    public static final String TABLE_CONST = "contacts";

    public static String world = "_id";
    public static int yes = 0;
    public static int no = 0;

    public Test(@Nullable Context context) {
        super(context, BASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_CONST + "(" + world + " integer primary key,"
                + "yes" + " text," + " text" + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_CONST);
        onCreate(db);

    }
}
