package com.example.languageupx002;

import android.app.ActionBar;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
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
        final Button addButton = (Button) findViewById(R.id.button28);
        final Button clearButton = (Button) findViewById(R.id.button32);
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
                LinearLayout linearLayout = new LinearLayout(this);
                llMain.addView(linearLayout, lParams);
                Button deleteButton = new Button(this);
                deleteButton.setText(a + " - " + b);
                //deleteButton.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 1);
                //deleteButton.setLayoutParams(new LinearLayout.LayoutParams(1, LinearLayout.LayoutParams.MATCH_PARENT));
                //deleteButton.setHeight(40);
                deleteButton.setWidth(1000);
                linearLayout.addView(deleteButton, lParams);

            } while (cursor.moveToNext());
        } else
            Log.d("mLog","0 rows");
        clearButton.setOnClickListener((v) -> {
            try {
                Intent intent = new Intent(List.this, Confidence.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        quitButton.setOnClickListener((v) -> {
            try {
                Intent intent = new Intent(List.this, MainMenu.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        addButton.setOnClickListener((v) -> {
            try {
                Intent intent = new Intent(List.this, AddText.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });

    }
}