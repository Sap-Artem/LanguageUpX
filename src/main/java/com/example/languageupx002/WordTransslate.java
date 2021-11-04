package com.example.languageupx002;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class WordTransslate extends AppCompatActivity {
    DBhelper dbHelper;
    String m;
    int max;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wordtranslate);
        final Button quitButton = (Button) findViewById(R.id.button15);
        final Button nextButton = (Button) findViewById(R.id.button13);
        final Button checkButton = (Button) findViewById(R.id.button11);
        dbHelper = new DBhelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        EditText edittranslate = findViewById(R.id.editWord2);
        TextView textView = findViewById(R.id.textView6);
        TextView textView2 = findViewById(R.id.textView7);
        Cursor cursor = database.query(DBhelper.TABLE_CONTACTS, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            int i = (int)(Math.random()*(9))+1;
            int idIndex = cursor.getColumnIndex(DBhelper.KEY_ID);
            int nameIndex = cursor.getColumnIndex(DBhelper.KEY_WORD);
            int emailIndex = cursor.getColumnIndex(DBhelper.KEY_TRANSLATE);
            do {
                if (i == cursor.getInt(idIndex)) {
                    String a = cursor.getString(nameIndex);
                    textView.setText(a);
                    String b = cursor.getString(emailIndex);
                    checkButton.setOnClickListener((v) -> {
                        String c;
                        String translate = edittranslate.getText().toString();
                        if(b.equals(translate)){
                            c = "Yes";
                        }else{
                            c = "No";
                        }
                        textView2.setText(c);
                    });
                }
            } while (cursor.moveToNext());
        } else
            Log.d("mLog","0 rows");
        quitButton.setOnClickListener((v) -> {
            try {
                Intent intent = new Intent(WordTransslate.this, MainActivity.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        nextButton.setOnClickListener((v) -> {
            try {
                Intent intent = new Intent(WordTransslate.this, WordTransslate.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
    }
}