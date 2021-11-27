package com.example.languageupx002;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Test extends AppCompatActivity {

    DopDB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        final Button back = (Button) findViewById(R.id.button16);
        db = new DopDB(this);
        ContentValues contentValues = new ContentValues();
        SQLiteDatabase database = db.getWritableDatabase();
        database.insert(DopDB.TABLE_CONTACTS2, null, contentValues);
        Cursor cursor = database.query(DopDB.TABLE_CONTACTS2, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            int idIndex2 = cursor.getColumnIndex(DopDB.lol);
            int nameIndex2 = cursor.getColumnIndex(DopDB.SCORE);
            int emailIndex2 = cursor.getColumnIndex(DopDB.ANSWER);
            do {
                Log.d("mLog", "ID = " + cursor.getInt(idIndex2) +
                        ", score = " + cursor.getString(nameIndex2) +
                        ", answer = " + cursor.getString(emailIndex2));
            } while (cursor.moveToNext());
        } else
            Log.d("mLog","0 rows");
        cursor.close();
        back.setOnClickListener((v) -> {
            try {
                Intent intent = new Intent(Test.this, MainActivity.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });


    }
}