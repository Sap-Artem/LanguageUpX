package com.example.languageupx002;


import static com.example.languageupx002.Table.k;
import static com.example.languageupx002.Table.rand1;
import static com.example.languageupx002.Table.rand2;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Couple extends AppCompatActivity {
    DBhelper dbHelper;
    LinearLayout llMainleft;
    LinearLayout llMainright;
    int wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.couple);
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
        for (int i = 0; i < k; i++) {
            rand2 = rand2 + rand1;
            if (rand2 > k) {
                rand2 = rand2 - k;
            }
            if (cursor.moveToFirst()) {
                textView.setText(Integer.toString(rand2));
                do {
                    if (rand2 == cursor.getInt(idIndex)) {
                        String a = cursor.getString(nameIndex);
                        Button wordButton = new Button(this);
                        wordButton.setText(a);
                        llMainleft.addView(wordButton, lParams);
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
                textView.setText(Integer.toString(rand2));
                do {
                    if (rand2 == cursor.getInt(idIndex)) {
                        String b = cursor.getString(emailIndex);
                        Button translateButton = new Button(this);
                        translateButton.setText(b);
                        llMainright.addView(translateButton, lParams);
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