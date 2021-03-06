package com.example.languageupx002;

import static com.example.languageupx002.Table.fail;
import static com.example.languageupx002.Table.k;
import static com.example.languageupx002.Table.right;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    DBhelper  db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        k = 0;
        right = 0;
        fail = 0;
        final Button addButton = (Button) findViewById(R.id.button12);
        final Button list = (Button) findViewById(R.id.button2);
        final Button test1 = (Button) findViewById(R.id.button);
        final Button test = (Button) findViewById(R.id.button10);
        db = new DBhelper(this);
        SQLiteDatabase database = db.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        database.insert(DBhelper.TABLE_CONTACTS, null, contentValues);
        Cursor cursor = database.query(DBhelper.TABLE_CONTACTS, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex(DBhelper.KEY_ID);
            int nameIndex = cursor.getColumnIndex(DBhelper.KEY_WORD);
            int emailIndex = cursor.getColumnIndex(DBhelper.KEY_TRANSLATE);
            do {
                Log.d("mLog", "ID = " + cursor.getInt(idIndex) +
                        ", name = " + cursor.getString(nameIndex) +
                        ", email = " + cursor.getString(emailIndex));
                k = k + 1;
            } while (cursor.moveToNext());
        } else
            Log.d("mLog","0 rows");

        cursor.close();
        addButton.setOnClickListener((v) -> {
            try {
                Intent intent = new Intent(MainActivity.this, AddText.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        list.setOnClickListener((v) -> {
            try {
                Intent intent = new Intent(MainActivity.this, List.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        test1.setOnClickListener((v) -> {
            try {
                Intent intent = new Intent(MainActivity.this, WordTransslate.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        test.setOnClickListener((v) -> {
            try {
                Intent intent = new Intent(MainActivity.this, Test.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });

    }
}