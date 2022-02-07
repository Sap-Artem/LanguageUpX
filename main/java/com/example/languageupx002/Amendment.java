package com.example.languageupx002;


import static com.example.languageupx002.Table.reserve_id;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Amendment extends AppCompatActivity {
    DBhelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper = new DBhelper(this);
        this.getSupportActionBar().hide();
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor cursor = database.query(DBhelper.TABLE_CONTACTS, null, null, null, null, null, null);
        ContentValues contentValues = new ContentValues();
        int idIndex = cursor.getColumnIndex(DBhelper.KEY_ID);
        int i = 2;
        if (cursor.moveToFirst()) {
            do {
                if (reserve_id < cursor.getInt(idIndex)) {
                    Log.d("mLog","- - - - -" + cursor.getInt(idIndex) + "- - - - - ");
                    contentValues.put(DBhelper.KEY_ID, cursor.getInt(idIndex) - 1);
                    database.update(DBhelper.TABLE_CONTACTS, contentValues, DBhelper.KEY_ID + "= ?", new String[] {String.valueOf(i)});
                }
                i++;
            } while (cursor.moveToNext());
        } else
            Log.d("mLog","0 rows");
        try {
            Intent intent = new Intent(Amendment.this, List.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}