package com.example.languageupx002;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class List extends AppCompatActivity {
    DBhelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        TextView textword = findViewById(R.id.textView5);
        TextView texttranslate = findViewById(R.id.textView6);
        dbHelper = new DBhelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor cursor = database.query(DBhelper.TABLE_CONTACTS, null, null, null, null, null, null);
        final Button quitButton = (Button) findViewById(R.id.button11);
        final Button addButton = (Button) findViewById(R.id.button13);
        if (cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex(DBhelper.KEY_ID);
            int nameIndex = cursor.getColumnIndex(DBhelper.KEY_WORD);
            int emailIndex = cursor.getColumnIndex(DBhelper.KEY_TRANSLATE);
            do {
                Log.d("mLog", "ID = " + cursor.getInt(idIndex) +
                        ", name = " + cursor.getString(nameIndex) +
                        ", email = " + cursor.getString(emailIndex));
                String a = cursor.getString(nameIndex);
                String b = cursor.getString(emailIndex);
                textword.setText(a);
                texttranslate.setText(b);
            } while (cursor.moveToNext());
        } else
            Log.d("mLog","0 rows");
        quitButton.setOnClickListener((v) -> {
            try {
                Intent intent = new Intent(List.this, MainActivity.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        addButton.setOnClickListener((v) -> {
            try {
                Intent intent = new Intent(List.this, AddText.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });

    }
}