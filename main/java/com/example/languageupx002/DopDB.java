package com.example.languageupx002;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DopDB extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION2 = 1;
    public static final String DATABASE_NAME2 = "contactDb";
    public static final String TABLE_CONTACTS2 = "contacts";
    public static final String lol = "_id";
    public static final String ANSWER = "word";
    public static final String SCORE = "word";

    public DopDB(Context context) {
        super(context, DATABASE_NAME2, null, DATABASE_VERSION2);
    }

    @Override
    public void onCreate(SQLiteDatabase db2) {
        db2.execSQL("create table " + TABLE_CONTACTS2 + "(" + lol + " integer primary key,"
                + SCORE + " text," + ANSWER + " text" + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db2, int oldVersion, int newVersion) {
        db2.execSQL("drop table if exists " + TABLE_CONTACTS2);
        onCreate(db2);

    }
}
