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
        final Button checkButton = (Button) findViewById(R.id.button31);
        final Button variant1 = (Button) findViewById(R.id.button23);
        final Button variant2 = (Button) findViewById(R.id.button26);
        final Button variant3 = (Button) findViewById(R.id.button30);
        final Button variant4 = (Button) findViewById(R.id.button29);
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
        AtomicInteger flag = new AtomicInteger();
        int idIndex = cursor.getColumnIndex(DBhelper.KEY_ID);
        int nameIndex = cursor.getColumnIndex(DBhelper.KEY_WORD);
        int emailIndex = cursor.getColumnIndex(DBhelper.KEY_TRANSLATE);
        textright.setText(Integer.toString(right));
        textfail.setText(Integer.toString(fail));
        if (cursor.moveToFirst()) {
            do {
                if (rand2 == cursor.getInt(idIndex)) {
                    String a = cursor.getString(nameIndex);
                    textView.setText(a);
                    int rand3 = (int) (Math.random() * (4) + 1);
                    int rand4 = (int)(Math.random()*(k/2 - 1)+1);
                    String b = cursor.getString(emailIndex);
                    switch (rand3) {
                        case (1):
                            variant1.setText(b);
                            break;
                        case (2):
                            variant2.setText(b);
                            break;
                        case (3):
                            variant3.setText(b);
                            break;
                        case (4):
                            variant4.setText(b);
                            break;
                    }
                }
            } while (cursor.moveToNext());
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