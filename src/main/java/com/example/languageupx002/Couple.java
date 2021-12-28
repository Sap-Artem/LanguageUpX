package com.example.languageupx002;


import static com.example.languageupx002.Table.k;
import static com.example.languageupx002.Table.rand1;
import static com.example.languageupx002.Table.rand2;
import static com.example.languageupx002.Table.conserve;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.Button;
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
        AtomicInteger ch = new AtomicInteger();
        final Button quitButton = (Button) findViewById(R.id.button21);
        final TextView textView = (TextView) findViewById(R.id.textView21);
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
        conserve = -1;
        textView.setText(Integer.toString(conserve));
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
                        wordButton.setOnClickListener((v) -> {
                            ch.set(ch.get() + 1);
                            if (ch.intValue()%2==1){
                                wordButton.setBackgroundColor(Color.parseColor("#ffff00"));
                                conserve = wordButton.getId();
                                textView.setText(Integer.toString(conserve));
                            }
                            if (ch.intValue()%2==0){
                                wordButton.setBackgroundColor(Color.parseColor("#D3D3D3"));
                                @SuppressLint("ResourceType") final Button conserveButton;
                                conserveButton = (Button) findViewById(conserve);
                                conserveButton.setBackgroundColor(Color.parseColor("#D3D3D3"));
                            }
                        });
                    }
                } while (cursor.moveToNext());
            } else
                Log.d("mLog", "0 rows");
        }
        while (true){
            rand1 = (int)(Math.random()*(k)+1);
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
                        translateButton.setOnClickListener((v) -> {
                            ch.set(ch.get() + 1);
                            if (ch.intValue()%2 == 1) {
                                translateButton.setBackgroundColor(Color.parseColor("#ffff00"));
                                conserve = translateButton.getId();
                                textView.setText(Integer.toString(conserve));
                            }
                            if (ch.intValue()%2 == 0){
                                translateButton.setBackgroundColor(Color.parseColor("#D3D3D3"));
                                @SuppressLint("ResourceType") final Button conserveButton;
                                conserveButton = (Button) findViewById(conserve);
                                conserveButton.setBackgroundColor(Color.parseColor("#D3D3D3"));
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