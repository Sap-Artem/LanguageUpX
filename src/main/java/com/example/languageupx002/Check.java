package com.example.languageupx002;

import static com.example.languageupx002.Table.chet;
import static com.example.languageupx002.Table.k;
import static com.example.languageupx002.Table.rand1;
import static com.example.languageupx002.Table.rand2;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class Check extends AppCompatActivity {
    DBhelper  dbHelper;
    int wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check);
        final Button quitButton = (Button) findViewById(R.id.button35);
        LinearLayout llMainNumber = (LinearLayout) findViewById(R.id.llMainNumber);
        LinearLayout llMainWord = (LinearLayout) findViewById(R.id.llMainWord);
        dbHelper = new DBhelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor cursor = database.query(DBhelper.TABLE_CONTACTS, null, null, null, null, null, null);
        LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(wrapContent, wrapContent);
        int btnGravity = Gravity.CENTER_HORIZONTAL;
        lParams.gravity = btnGravity;
        int idIndex = cursor.getColumnIndex(DBhelper.KEY_ID);
        int nameIndex = cursor.getColumnIndex(DBhelper.KEY_WORD);
        int emailIndex = cursor.getColumnIndex(DBhelper.KEY_TRANSLATE);
        rand2 = rand2 + rand1;
        if (rand2>k){
            rand2 = rand2 - k;
        }
        while(chet<k) {
            if (cursor.moveToFirst()) {
                do {
                    if (rand2 == cursor.getInt(idIndex)) {
                        chet = chet + 1;
                        String a = cursor.getString(emailIndex);
                        TextView wordText = new TextView(this);
                        wordText.setText(a);
                        llMainWord.addView(wordText, lParams);
                        String number = String.valueOf(chet);
                        TextView numberText = new TextView(this);
                        numberText.setText(number);
                        llMainNumber.addView(numberText, lParams);
                        rand2 = rand2 + rand1;
                        if (rand2>k){
                            rand2 = rand2 - k;
                        }
                    }
                } while (cursor.moveToNext());
            }
        }
        quitButton.setOnClickListener((v) -> {
            try {
                Intent intent = new Intent(Check.this, MainActivity.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
    }
}