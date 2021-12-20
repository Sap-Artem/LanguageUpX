package com.example.languageupx002;


import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Confidence extends AppCompatActivity {
    DBhelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confidence);
        final Button yesButton = (Button) findViewById(R.id.button18);
        final Button noButton = (Button) findViewById(R.id.button20);
        dbHelper = new DBhelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        noButton.setOnClickListener((v) -> {
            try {
                Intent intent = new Intent(Confidence.this, AddText.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        yesButton.setOnClickListener((v) -> {
            database.delete(DBhelper.TABLE_CONTACTS, null, null);
            try {
                Intent intent = new Intent(Confidence.this, MainActivity.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });

    }
}