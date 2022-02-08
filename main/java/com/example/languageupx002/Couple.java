package com.example.languageupx002;


import static com.example.languageupx002.Table.k;
import static com.example.languageupx002.Table.lang;
import static com.example.languageupx002.Table.rand1;
import static com.example.languageupx002.Table.rand2;
import static com.example.languageupx002.Table.conserve;
import static com.example.languageupx002.Table.win;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.atomic.AtomicInteger;

public class Couple extends AppCompatActivity {
    DBhelper dbHelper;
    LinearLayout llMainleft;
    LinearLayout llMainright;
    int wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.couple);
        this.getSupportActionBar().hide();
        AtomicInteger ch = new AtomicInteger();
        final ImageButton quitButton = (ImageButton) findViewById(R.id.button21);
        final TextView textView = (TextView) findViewById(R.id.textView22);
        final TextView tv = (TextView) findViewById(R.id.textView32);
        llMainleft = (LinearLayout) findViewById(R.id.llMainleft);
        llMainright = (LinearLayout) findViewById(R.id.llMainright);
        dbHelper = new DBhelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor cursor = database.query(DBhelper.TABLE_CONTACTS, null, null, null, null, null, null);
        LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(wrapContent, wrapContent);
        int btnGravity = Gravity.CENTER_HORIZONTAL;
        lParams.gravity = btnGravity;
        int idIndex = cursor.getColumnIndex(DBhelper.KEY_ID);
        int nameIndex = cursor.getColumnIndex(DBhelper.KEY_WORD);
        int emailIndex = cursor.getColumnIndex(DBhelper.KEY_TRANSLATE);
        String s = null;
        switch (lang){
            case (1):
                tv.setText("Find a couple");
                s = "Well done!";
                break;
            case (2):
                tv.setText("Trouver un couple");
                s = "Bien joué!";
                break;
            case (3):
                tv.setText("Encontrar una pareja");
                s = "¡Bien hecho!";
                break;
            case (4):
                tv.setText("Encontre um casal");
                s = "Bem feito!";
                break;
            case (5):
                tv.setText("Trova una coppia");
                s = "Molto bene!";
                break;
            case (6):
                tv.setText("Finden Sie ein Paar");
                s = "Gut erledigt!";
                break;
            case (7):
                tv.setText("Найди пару");
                s = "Молодец!";
                break;
            case (8):
                tv.setText("找一對");
                s = "做得好！";
                break;
            case (9):
                tv.setText("커플 찾기");
                s = "잘 했어!";
                break;
            case (10):
                tv.setText("カップルを探す");
                s = "素晴らしい！";
                break;
            case (11):
                tv.setText("एक युगल खोजें");
                s = "बहुत बढ़िया!";
                break;
            case (12):
                tv.setText("ابحث عن زوجين");
                s = "أتقنه!";
                break;
        }
        conserve = 0;
        win = 0;
        for (int i = 0; i < k; i++) {
            rand2 = rand2 + rand1;
            if (rand2 > k) {
                rand2 = rand2 - k;
            }
            if (cursor.moveToFirst()) {
                do {
                    if (rand2 == cursor.getInt(idIndex)) {
                        String a = cursor.getString(nameIndex);
                        Button wordButton = new Button(this);
                        wordButton.setId(rand2);
                        wordButton.setText(a);
                        llMainleft.addView(wordButton, lParams);
                        String finalS1 = s;
                        wordButton.setOnClickListener((v) -> {
                            ch.set(ch.get() + 1);
                            int rightword = wordButton.getId();
                            if(rightword!=0) {
                                if (ch.intValue() % 2 == 1) {
                                    wordButton.setBackgroundColor(Color.parseColor("#ffff00"));
                                    conserve = wordButton.getId();
                                }
                                if (ch.intValue() % 2 == 0) {
                                    if (conserve - rightword == k) {
                                        wordButton.setBackgroundColor(Color.parseColor("#00FF00"));
                                        wordButton.setVisibility(View.GONE);
                                        @SuppressLint("ResourceType") final Button conserveButton;
                                        conserveButton = (Button) findViewById(conserve);
                                        conserveButton.setBackgroundColor(Color.parseColor("#00FF00"));
                                        conserveButton.setVisibility(View.GONE);
                                        win = win + 1;
                                        wordButton.setId(0);
                                        conserveButton.setId(0);
                                        if (win == k) {
                                            textView.setText(finalS1);
                                        }
                                    } else {
                                        wordButton.setBackgroundColor(Color.parseColor("#ff0000"));
                                        @SuppressLint("ResourceType") final Button conserveButton;
                                        conserveButton = (Button) findViewById(conserve);
                                        conserveButton.setBackgroundColor(Color.parseColor("#ff0000"));
                                    }
                                }
                            }
                        });
                    }
                } while (cursor.moveToNext());
            } else
                Log.d("mLog", "0 rows");
        }
        while (true){
            do{
                rand1 = (int)(Math.random()*(k)+1);
            }while (rand1 == 1);
            int t;
            int b = rand1;
            int a = k;
            while(b != 0){
                t = a;
                a = b;
                b = t%b;
            }
            if (a==1){
                break;
            }
        }
        rand2 = (int)(Math.random()*(k)+1);
        for (int i = 0; i < k; i++) {
            rand2 = rand2 + rand1;
            if (rand2 > k) {
                rand2 = rand2 - k;
            }
            if (cursor.moveToFirst()) {
                do {
                    if (rand2 == cursor.getInt(idIndex)) {
                        String b = cursor.getString(emailIndex);
                        Button translateButton = new Button(this);
                        translateButton.setId(rand2+k);
                        translateButton.setText(b);
                        llMainright.addView(translateButton, lParams);
                        String finalS = s;
                        translateButton.setOnClickListener((v) -> {
                            ch.set(ch.get() + 1);
                            int righttranslate = translateButton.getId();
                            if(righttranslate!=0) {
                                if (ch.intValue() % 2 == 1) {
                                    translateButton.setBackgroundColor(Color.parseColor("#ffff00"));
                                    conserve = translateButton.getId();
                                }
                                if (ch.intValue() % 2 == 0) {
                                    if (righttranslate - conserve == k) {
                                        translateButton.setBackgroundColor(Color.parseColor("#00ff00"));
                                        translateButton.setVisibility(View.GONE);
                                        @SuppressLint("ResourceType") final Button conserveButton;
                                        conserveButton = (Button) findViewById(conserve);
                                        conserveButton.setBackgroundColor(Color.parseColor("#00ff00"));
                                        conserveButton.setVisibility(View.GONE);
                                        win = win + 1;
                                        translateButton.setId(0);
                                        conserveButton.setId(0);
                                        if (win == k) {
                                            textView.setText(finalS);
                                        }
                                    } else {
                                        translateButton.setBackgroundColor(Color.parseColor("#ff0000"));
                                        @SuppressLint("ResourceType") final Button conserveButton;
                                        conserveButton = (Button) findViewById(conserve);
                                        conserveButton.setBackgroundColor(Color.parseColor("#ff0000"));
                                    }
                                }
                            }
                        });
                    }
                } while (cursor.moveToNext());
            } else
                Log.d("mLog", "0 rows");
        }
        quitButton.setOnClickListener((v) -> {
            try {
                Intent intent = new Intent(Couple.this, MainActivity.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
    }
}