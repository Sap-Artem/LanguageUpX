package com.example.languageupx002;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class List extends AppCompatActivity {
    DBhelper dbHelper;
    LinearLayout llMain;
    int wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;
    int wrap = 600;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        llMain = (LinearLayout) findViewById(R.id.llMain);
        dbHelper = new DBhelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor cursor = database.query(DBhelper.TABLE_CONTACTS, null, null, null, null, null, null);
        final Button quitButton = (Button) findViewById(R.id.button19);
        LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(wrapContent, wrapContent);
        int btnGravity = Gravity.CENTER_HORIZONTAL;
        lParams.gravity = btnGravity;
        if (cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex(DBhelper.KEY_ID);
            int nameIndex = cursor.getColumnIndex(DBhelper.KEY_WORD);
            int emailIndex = cursor.getColumnIndex(DBhelper.KEY_TRANSLATE);
            do {
                Log.d("mLog", "ID = " + cursor.getInt(idIndex) +
                        ", name = " + cursor.getString(nameIndex) +
                        ", email = " + cursor.getString(emailIndex));
                String a = cursor.getString(nameIndex);
                String b = cursor.getString(emailIndex);
                TextView textView1 = new TextView(this);
                textView1.setText(a);
                llMain.addView(textView1, lParams);
                TextView textView2 = new TextView(this);
                textView2.setText(b);
                llMain.addView(textView2, lParams);
            } while (cursor.moveToNext());
        } else
            Log.d("mLog","0 rows");
        quitButton.setOnClickListener((v) -> {
            try {
                Intent intent = new Intent(List.this, MainActivity.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });

    }
}