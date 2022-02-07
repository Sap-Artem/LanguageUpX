package com.example.languageupx002;

import static com.example.languageupx002.Table.lang;
import static com.example.languageupx002.Table.langw;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Test extends AppCompatActivity {

    DopDB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        this.getSupportActionBar().hide();
        final ImageButton back = (ImageButton) findViewById(R.id.imageButton);
        final TextView textView1 = (TextView) findViewById(R.id.textView29);
        final TextView tv1 = (TextView) findViewById(R.id.textView31);
        final TextView tv2 = (TextView) findViewById(R.id.textView24);
        ImageButton langb = (ImageButton)findViewById(R.id.imageView16);
        ImageButton langw = (ImageButton)findViewById(R.id.imageView17);
        db = new DopDB(this);
        ContentValues contentValues = new ContentValues();
        SQLiteDatabase database = db.getWritableDatabase();
        database.insert(DopDB.TABLE_CONTACTS2, null, contentValues);
        Cursor cursor = database.query(DopDB.TABLE_CONTACTS2, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            int idIndex2 = cursor.getColumnIndex(DopDB.lol);
            int nameIndex2 = cursor.getColumnIndex(DopDB.SCORE);
            int emailIndex2 = cursor.getColumnIndex(DopDB.ANSWER);
            do {
                Log.d("mLog", "ID = " + cursor.getInt(idIndex2) +
                        ", score = " + cursor.getString(nameIndex2) +
                        ", answer = " + cursor.getString(emailIndex2));
            } while (cursor.moveToNext());
        } else
            Log.d("mLog","0 rows");
        cursor.close();
        switch (lang){
            case (1):
                textView1.setText("English\uD83C\uDDEC\uD83C\uDDE7");
                tv1.setText("language app:");
                tv2.setText("Settings");
                break;
            case (2):
                textView1.setText("Français\uD83C\uDDEB\uD83C\uDDF7");
                tv1.setText("application de langue:");
                tv2.setText("Réglages");
                break;
            case (3):
                textView1.setText("Español\uD83C\uDDEA\uD83C\uDDF8");
                tv1.setText("aplicación de idioma:");
                tv2.setText("Ajustes");
                break;
            case (4):
                textView1.setText("Português\uD83C\uDDF5\uD83C\uDDF9");
                tv1.setText("aplicativo de idiomas:");
                tv2.setText("Sintonização");
                break;
            case (5):
                textView1.setText("Italiano\uD83C\uDDEE\uD83C\uDDF9");
                tv1.setText("app per la lingua:");
                tv2.setText("Regolazioni");
                break;
            case (6):
                textView1.setText("Deutsch\uD83C\uDDE9\uD83C\uDDEA");
                tv1.setText("Sprach-App:");
                tv2.setText("Die Einstellungen");
                break;
            case (7):
                textView1.setText("Русский\uD83C\uDDF7\uD83C\uDDFA");
                tv1.setText("Язык приложения:");
                tv2.setText("Настройки");
                break;
            case (8):
                textView1.setText("中文\uD83C\uDDE8\uD83C\uDDF3");
                tv1.setText("語言應用:");
                tv2.setText("设置");
                break;
            case (9):
                textView1.setText("한국어\uD83C\uDDF0\uD83C\uDDF7");
                tv1.setText("언어 앱:");
                tv2.setText("설정");
                break;
            case (10):
                textView1.setText("日本語\uD83C\uDDEF\uD83C\uDDF5");
                tv1.setText("言語アプリ:");
                tv2.setText("設定");
                break;
            case (11):
                textView1.setText("हिन्दी\uD83C\uDDEE\uD83C\uDDF3");
                tv1.setText("भाषा ऐप:");
                tv2.setText("सेटिंग्स");
                break;
            case (12):
                textView1.setText("\uD83C\uDDE6\uD83C\uDDEAالعربية");
                tv1.setText("تطبيق اللغة:");
                tv2.setText("الإعدادات");
                break;
        }
        langb.setOnClickListener((v) -> {
            lang -= 1;
            if(lang==0)
                lang = 12;
            try {
                Intent intent = new Intent(Test.this, Test.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        langw.setOnClickListener((v) -> {
            lang += 1;
            if(lang==13)
                lang = 1;
            try {
                Intent intent = new Intent(Test.this, Test.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        back.setOnClickListener((v) -> {
            try {
                Intent intent = new Intent(Test.this, MainMenu.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });


    }
}