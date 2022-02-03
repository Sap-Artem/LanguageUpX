package com.example.languageupx002;

import static com.example.languageupx002.Table.k;
import static com.example.languageupx002.Table.lang;
import static com.example.languageupx002.Table.reserve_id;
import android.app.ActionBar;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.atomic.AtomicInteger;

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
        final ImageButton quitButton = (ImageButton) findViewById(R.id.button19);
        final ImageButton addButton = (ImageButton) findViewById(R.id.button28);
        final ImageButton clearButton = (ImageButton) findViewById(R.id.button32);
        final TextView testButton  = (TextView) findViewById(R.id.textView21);
        LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(wrapContent, wrapContent);
        int btnGravity = Gravity.CENTER_HORIZONTAL;
        lParams.gravity = btnGravity;
        int idIndex = cursor.getColumnIndex(DBhelper.KEY_ID);
        int nameIndex = cursor.getColumnIndex(DBhelper.KEY_WORD);
        int emailIndex = cursor.getColumnIndex(DBhelper.KEY_TRANSLATE);
        reserve_id = 0;
        switch (lang){
            case (1):
                testButton.setText("Your Words");
                break;
            case (2):
                testButton.setText("Vos mots");
                break;
            case (3):
                testButton.setText("Tus palabras");
                break;
            case (4):
                testButton.setText("Suas palavras");
                break;
            case (5):
                testButton.setText("Parole tue");
                break;
            case (6):
                testButton.setText("Deine Worte");
                break;
            case (7):
                testButton.setText("Ваши слова");
                break;
            case (8):
                testButton.setText("你的話");
                break;
            case (9):
                testButton.setText("당신의 말");
                break;
            case (10):
                testButton.setText("あなたの言葉");
                break;
            case (11):
                testButton.setText("तुम्हारे शब्द");
                break;
            case (12):
                testButton.setText("كلماتك");
                break;
        }
        for (int i = 0; i < k; i++) {
            if (cursor.moveToFirst()) {
                do {
                    if(i + 1 == cursor.getInt(idIndex)) {
                        Log.d("mLog", "ID = " + cursor.getInt(idIndex) +
                                ", name = " + cursor.getString(nameIndex) +
                                ", email = " + cursor.getString(emailIndex));
                        String a = cursor.getString(nameIndex);
                        String b = cursor.getString(emailIndex);
                        LinearLayout linearLayout = new LinearLayout(this);
                        llMain.addView(linearLayout, lParams);
                        Button deleteButton = new Button(this);
                        deleteButton.setId(cursor.getInt(idIndex));
                        deleteButton.setText(a + " - " + b);
                        //deleteButton.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 1);
                        //deleteButton.setLayoutParams(new LinearLayout.LayoutParams(1, LinearLayout.LayoutParams.MATCH_PARENT));
                        //deleteButton.setHeight(40);
                        deleteButton.setWidth(1000);
                        linearLayout.addView(deleteButton, lParams);
                        deleteButton.setOnClickListener((v) -> {
                            deleteButton.setBackgroundColor(Color.parseColor("#999999"));
                            reserve_id = deleteButton.getId();
                            Log.d("mLog", "- - -" + reserve_id + "- - -");
                            try {
                                Intent intent = new Intent(List.this, Cards.class);
                                startActivity(intent);
                                finish();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        });
                    }

                } while (cursor.moveToNext());
            } else
                Log.d("mLog", "0 rows");
        }
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