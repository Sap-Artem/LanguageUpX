package com.example.languageupx002;

import static com.example.languageupx002.Table.chet;
import static com.example.languageupx002.Table.flag;
import static com.example.languageupx002.Table.k;
import static com.example.languageupx002.Table.rand1;
import static com.example.languageupx002.Table.rand2;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainMenu extends AppCompatActivity {
    DBhelper  db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        k = 0;
        db = new DBhelper(this);
        SQLiteDatabase database = db.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        database.insert(DBhelper.TABLE_CONTACTS, null, contentValues);
        Cursor cursor = database.query(DBhelper.TABLE_CONTACTS, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                k = k + 1;
            } while (cursor.moveToNext());
        } else
            Log.d("mLog","0 rows");
        cursor.close();
        final Button testButton = (Button) findViewById(R.id.button13);
        final ImageButton addButton = (ImageButton) findViewById(R.id.button15);
        final ImageButton listButton = (ImageButton) findViewById(R.id.button25);
        final ImageButton nastButton = (ImageButton) findViewById(R.id.imageButton3);
        Toast toast = Toast.makeText(getApplicationContext(),
                "Add at least 3 words to the database", Toast.LENGTH_SHORT);
        nastButton.setOnClickListener((v) -> {
            try {
                Intent intent = new Intent(MainMenu.this, Test.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        listButton.setOnClickListener((v) -> {
            try {
                Intent intent = new Intent(MainMenu.this, List.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        addButton.setOnClickListener((v) -> {
            try {
                Intent intent = new Intent(MainMenu.this, AddText.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        testButton.setOnClickListener((v) -> {
            if(k>=3) {
                try {
                    Intent intent = new Intent(MainMenu.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else{
                toast.show();
            }

        });
    }
}