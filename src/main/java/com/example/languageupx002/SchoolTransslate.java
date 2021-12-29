package com.example.languageupx002;


import static com.example.languageupx002.Table.fail;
import static com.example.languageupx002.Table.k;
import static com.example.languageupx002.Table.rand1;
import static com.example.languageupx002.Table.rand2;
import static com.example.languageupx002.Table.right;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.atomic.AtomicInteger;

public class SchoolTransslate extends AppCompatActivity {
    DBhelper dbHelper;
    DopDB DB;
    String m;
    int max;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schooltranslate);
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
                    String a = cursor.getString(nameIndex);
                    textView.setText(a);
                    String b = cursor.getString(emailIndex);
                    if(rand3 == 1) variant1.setText(b);
                    if(rand3 == 2) variant2.setText(b);
                    if(rand3 == 3) variant3.setText(b);
                    if(rand3 == 4) variant4.setText(b);
                    if(rand3 == 5) variant5.setText(b);
                }
                if (v2 == cursor.getInt(idIndex)) {
                    String b = cursor.getString(emailIndex);
                    if(rand3 == 1) variant2.setText(b);
                    if(rand3 == 2) variant3.setText(b);
                    if(rand3 == 3) variant4.setText(b);
                    if(rand3 == 4) variant5.setText(b);
                    if(rand3 == 5) variant1.setText(b);
                }
                if (v3 == cursor.getInt(idIndex)) {
                    String b = cursor.getString(emailIndex);
                    if(rand3 == 1) variant3.setText(b);
                    if(rand3 == 2) variant4.setText(b);
                    if(rand3 == 3) variant5.setText(b);
                    if(rand3 == 4) variant1.setText(b);
                    if(rand3 == 5) variant2.setText(b);
                }
                if (v4 == cursor.getInt(idIndex)) {
                    String b = cursor.getString(emailIndex);
                    if(rand3 == 1) variant4.setText(b);
                    if(rand3 == 2) variant5.setText(b);
                    if(rand3 == 3) variant1.setText(b);
                    if(rand3 == 4) variant2.setText(b);
                    if(rand3 == 5) variant3.setText(b);
                }
                if (v5 == cursor.getInt(idIndex)) {
                    String b = cursor.getString(emailIndex);
                    if(rand3 == 1) variant5.setText(b);
                    if(rand3 == 2) variant1.setText(b);
                    if(rand3 == 3) variant2.setText(b);
                    if(rand3 == 4) variant3.setText(b);
                    if(rand3 == 5) variant4.setText(b);
                }
            } while (cursor.moveToNext()) ;
        } else
            Log.d("mLog","0 rows");

        if (right + fail >= k){
            try {
                Intent intent = new Intent(SchoolTransslate.this, Itog.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        database2.insert(DopDB.TABLE_CONTACTS2, null, contentValues);
        quitButton.setOnClickListener((v) -> {
            try {
                Intent intent = new Intent(SchoolTransslate.this, MainActivity.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        nextButton.setOnClickListener((v) -> {
            try {
                Intent intent = new Intent(SchoolTransslate.this, SchoolTransslate.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
    }
}