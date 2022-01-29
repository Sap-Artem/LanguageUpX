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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TransslateWord extends AppCompatActivity {
    DBhelper dbHelper;
    DopDB DB;
    String m;
    int max;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.translateword);
        final ImageButton quitButton = (ImageButton) findViewById(R.id.button35);
        final ImageButton nextButton = (ImageButton) findViewById(R.id.button33);
        final ImageButton checkButton = (ImageButton) findViewById(R.id.button31);
        dbHelper = new DBhelper(this);
        DB = new DopDB(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        SQLiteDatabase database2 = DB.getWritableDatabase();
        EditText edittranslate = findViewById(R.id.editWord);
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
        if (cursor.moveToFirst()) {
            do {
                if (rand2 == cursor.getInt(idIndex)) {
                    String a = cursor.getString(emailIndex);
                    textView.setText(a);
                    String b = cursor.getString(nameIndex);
                    checkButton.setOnClickListener((v) -> {
                        String c;
                        String translate = edittranslate.getText().toString();
                        contentValues.put(DopDB.ANSWER, translate);
                        if(b.equals(translate)){
                            c = "Yes";
                            contentValues.put(DopDB.SCORE, "1");
                            right = right + 1;
                        }else{
                            c = "No, it is " + b;
                            contentValues.put(DopDB.SCORE, "0");
                            fail = fail + 1;
                        }
                        textView2.setText(c);
                    });
                }
                if (right + fail >= k){
                    try {
                        Intent intent = new Intent(TransslateWord.this, Itog.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } while (cursor.moveToNext());
        } else
            Log.d("mLog","0 rows");
        database2.insert(DopDB.TABLE_CONTACTS2, null, contentValues);
        quitButton.setOnClickListener((v) -> {
            try {
                Intent intent = new Intent(TransslateWord.this, MainActivity.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        nextButton.setOnClickListener((v) -> {
            try {
                Intent intent = new Intent(TransslateWord.this, TransslateWord.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
    }
}