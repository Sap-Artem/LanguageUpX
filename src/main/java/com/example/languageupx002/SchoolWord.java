package com.example.languageupx002;


import static com.example.languageupx002.Table.chet;
import static com.example.languageupx002.Table.fail;
import static com.example.languageupx002.Table.k;
import static com.example.languageupx002.Table.rand1;
import static com.example.languageupx002.Table.rand2;
import static com.example.languageupx002.Table.right;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.atomic.AtomicInteger;

public class SchoolWord extends AppCompatActivity {
    DBhelper dbHelper;
    DopDB DB;
    String m;
    int max;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schoolword);
        final Button quitButton = (Button) findViewById(R.id.button35);
        final Button nextButton = (Button) findViewById(R.id.button33);
        final Button variant1 = (Button) findViewById(R.id.button23);
        final Button variant2 = (Button) findViewById(R.id.button26);
        final Button variant3 = (Button) findViewById(R.id.button30);
        final Button variant4 = (Button) findViewById(R.id.button29);
        final Button variant5 = (Button) findViewById(R.id.button11);
        dbHelper = new DBhelper(this);
        DB = new DopDB(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        SQLiteDatabase database2 = DB.getWritableDatabase();
        TextView textView = findViewById(R.id.textView6);
        TextView textView2 = findViewById(R.id.textView7);
        TextView textright = findViewById(R.id.textView4);
        TextView textfail = findViewById(R.id.textView10);
        Cursor cursor = database.query(DBhelper.TABLE_CONTACTS, null, null, null, null, null, null);
        ContentValues contentValues = new ContentValues();
        rand2 = rand2 + rand1;
        if (rand2>k){
            rand2 = rand2 - k;
        }
        int idIndex = cursor.getColumnIndex(DBhelper.KEY_ID);
        int nameIndex = cursor.getColumnIndex(DBhelper.KEY_WORD);
        int emailIndex = cursor.getColumnIndex(DBhelper.KEY_TRANSLATE);
        textright.setText(Integer.toString(right));
        textfail.setText(Integer.toString(fail));
        int rand3 = (int) (Math.random() * (5) + 1);
        int rand4;
        int rand5;
        do {
            rand4 = (int) (Math.random() * (k / 2 - 1) + 1);
            rand5 = (int) (Math.random() * (k / 2 - 1) + 1);
        }while(rand4 == rand5);
        int v2 = rand2 + rand4;
        if (v2>k) v2 = v2 - k;
        int v3 = rand2 - rand4;
        if (v3<1) v3 = v3 + k;
        int v4 = rand2 + rand5;
        if (v4>k) v4 = v4 - k;
        int v5 = rand2 - rand5;
        if (v5<1) v5 = v5 + k;
        Log.d("mLog",rand3 + " " + rand4 + " " + rand5);
        if (cursor.moveToFirst()) {
            do {
                if (rand2 == cursor.getInt(idIndex)) {
                    String a = cursor.getString(emailIndex);
                    textView.setText(a);
                    String b = cursor.getString(nameIndex);
                    if(rand3 == 1) variant1.setText(b);
                    if(rand3 == 2) variant2.setText(b);
                    if(rand3 == 3) variant3.setText(b);
                    if(rand3 == 4) variant4.setText(b);
                    if(rand3 == 5) variant5.setText(b);
                }
                if (v2 == cursor.getInt(idIndex)) {
                    String b = cursor.getString(nameIndex);
                    if(rand3 == 1) variant2.setText(b);
                    if(rand3 == 2) variant3.setText(b);
                    if(rand3 == 3) variant4.setText(b);
                    if(rand3 == 4) variant5.setText(b);
                    if(rand3 == 5) variant1.setText(b);
                }
                if (v3 == cursor.getInt(idIndex)) {
                    String b = cursor.getString(nameIndex);
                    if(rand3 == 1) variant3.setText(b);
                    if(rand3 == 2) variant4.setText(b);
                    if(rand3 == 3) variant5.setText(b);
                    if(rand3 == 4) variant1.setText(b);
                    if(rand3 == 5) variant2.setText(b);
                }
                if (v4 == cursor.getInt(idIndex)) {
                    String b = cursor.getString(nameIndex);
                    if(rand3 == 1) variant4.setText(b);
                    if(rand3 == 2) variant5.setText(b);
                    if(rand3 == 3) variant1.setText(b);
                    if(rand3 == 4) variant2.setText(b);
                    if(rand3 == 5) variant3.setText(b);
                }
                if (v5 == cursor.getInt(idIndex)) {
                    String b = cursor.getString(nameIndex);
                    if(rand3 == 1) variant5.setText(b);
                    if(rand3 == 2) variant1.setText(b);
                    if(rand3 == 3) variant2.setText(b);
                    if(rand3 == 4) variant3.setText(b);
                    if(rand3 == 5) variant4.setText(b);
                }
            } while (cursor.moveToNext()) ;
        } else
            Log.d("mLog","0 rows");
        int id = 0;
        chet = chet + 1;
        if(rand3 == 1) id = variant1.getId();
        if(rand3 == 2) id = variant2.getId();
        if(rand3 == 3) id = variant3.getId();
        if(rand3 == 4) id = variant4.getId();
        if(rand3 == 5) id = variant5.getId();
        int finalId = id;
        AtomicInteger v1v = new AtomicInteger();
        AtomicInteger v2v = new AtomicInteger();
        AtomicInteger v3v = new AtomicInteger();
        AtomicInteger v4v = new AtomicInteger();
        AtomicInteger v5v = new AtomicInteger();
        variant1.setOnClickListener((v) -> {
            if(v1v.get() == 0) {
                if (variant1.getId() == finalId) {
                    right = right + 1;
                    variant1.setBackgroundColor(Color.parseColor("#00ff00"));
                    v1v.set(1);
                } else {
                    fail = fail + 1;
                    variant1.setBackgroundColor(Color.parseColor("#ff0000"));
                    v1v.set(1);
                }
            }
        });
        variant2.setOnClickListener((v) -> {
            if(v2v.get() == 0) {
                if (variant2.getId() == finalId) {
                    right = right + 1;
                    variant2.setBackgroundColor(Color.parseColor("#00ff00"));
                    v2v.set(1);
                } else {
                    fail = fail + 1;
                    variant2.setBackgroundColor(Color.parseColor("#ff0000"));
                    v2v.set(1);
                }
            }
        });
        variant3.setOnClickListener((v) -> {
            if(v3v.get() == 0) {
                if (variant3.getId() == finalId) {
                    right = right + 1;
                    variant3.setBackgroundColor(Color.parseColor("#00ff00"));
                    v3v.set(1);
                } else {
                    fail = fail + 1;
                    variant3.setBackgroundColor(Color.parseColor("#ff0000"));
                    v3v.set(1);
                }
            }
        });
        variant4.setOnClickListener((v) -> {
            if(v4v.get() == 0) {
                if (variant4.getId() == finalId) {
                    right = right + 1;
                    variant4.setBackgroundColor(Color.parseColor("#00ff00"));
                    v4v.set(1);
                } else {
                    fail = fail + 1;
                    variant4.setBackgroundColor(Color.parseColor("#ff0000"));
                    v4v.set(1);
                }
            }
        });
        variant5.setOnClickListener((v) -> {
            if(v5v.get() == 0) {
                if (variant5.getId() == finalId) {
                    right = right + 1;
                    variant5.setBackgroundColor(Color.parseColor("#00ff00"));
                    v5v.set(1);
                } else {
                    fail = fail + 1;
                    variant5.setBackgroundColor(Color.parseColor("#ff0000"));
                    v5v.set(1);
                }
            }
        });
        if (chet > k){
            try {
                Intent intent = new Intent(SchoolWord.this, Itog.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        database2.insert(DopDB.TABLE_CONTACTS2, null, contentValues);
        quitButton.setOnClickListener((v) -> {
            try {
                Intent intent = new Intent(SchoolWord.this, MainActivity.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        nextButton.setOnClickListener((v) -> {
            try {
                Intent intent = new Intent(SchoolWord.this, SchoolWord.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
    }
}