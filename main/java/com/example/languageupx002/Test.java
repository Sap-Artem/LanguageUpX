package com.example.languageupx002;

import static com.example.languageupx002.Table.lang;
import static com.example.languageupx002.Table.langtr;
import static com.example.languageupx002.Table.langw;
import static com.example.languageupx002.Table.pr;
import static com.example.languageupx002.Table.reserve_id;


import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Test extends AppCompatActivity {

    DopDB db;
    Db2 db2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        this.getSupportActionBar().hide();
        final ImageButton back = (ImageButton) findViewById(R.id.imageButton);
        final TextView textView1 = (TextView) findViewById(R.id.textView29);
        final TextView textView2 = (TextView) findViewById(R.id.textView38);
        final TextView textView3 = (TextView) findViewById(R.id.textView39);
        final TextView tv1 = (TextView) findViewById(R.id.textView31);
        final TextView tv2 = (TextView) findViewById(R.id.textView24);
        final TextView tv3 = (TextView) findViewById(R.id.textView34);
        final TextView tv4 = (TextView) findViewById(R.id.textView36);
        final TextView tv5 = (TextView) findViewById(R.id.textView37);
        EditText editTime = findViewById(R.id.editWord3);
        editTime.setText(Integer.toString(pr));
        ImageButton langb = (ImageButton)findViewById(R.id.imageView16);
        ImageButton langW = (ImageButton)findViewById(R.id.imageView17);
        ImageButton langwb = (ImageButton)findViewById(R.id.imageView19);
        ImageButton langww = (ImageButton)findViewById(R.id.imageView21);
        ImageButton langtrb = (ImageButton)findViewById(R.id.imageView20);
        ImageButton langtrw = (ImageButton)findViewById(R.id.imageView22);
        db = new DopDB(this);
        db2 = new Db2(this);
        ContentValues contentValues = new ContentValues();
        ContentValues cv = new ContentValues();
        SQLiteDatabase database = db.getWritableDatabase();
        SQLiteDatabase db = db2.getWritableDatabase();
        database.insert(DopDB.TABLE_CONTACTS2, null, contentValues);
        Cursor cursor = database.query(DopDB.TABLE_CONTACTS2, null, null, null, null, null, null);
        db.delete("mytable", null, null);
        cv.put("lang", lang);
        cv.put("langw", langw);
        cv.put("langtr", langtr);
        db.insert("mytable", null, cv);
        Cursor c = db.query("mytable", null, null, null, null, null, null);
        if (c.moveToFirst()) {

            // определяем номера столбцов по имени в выборке
            int idColIndex0 = c.getColumnIndex("id");
            int idColIndex = c.getColumnIndex("lang");
            int nameColIndex = c.getColumnIndex("langw");
            int emailColIndex = c.getColumnIndex("langtr");

            do {
                // получаем значения по номерам столбцов и пишем все в лог
                Log.d("mLog",
                               "lang = " + c.getInt(idColIndex) +
                                ", langw = " + c.getString(nameColIndex) +
                                ", langtr = " + c.getString(emailColIndex));
                // переход на следующую строку
                // а если следующей нет (текущая - последняя), то false - выходим из цикла
            } while (c.moveToNext());
        }
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
        Toast toast = Toast.makeText(getApplicationContext(),
                "", Toast.LENGTH_SHORT);
        switch (lang){
            case (1):
                textView1.setText("English\uD83C\uDDEC\uD83C\uDDE7");
                tv1.setText("language app:");
                tv2.setText("Settings");
                tv3.setText("Audi time:");
                tv4.setText("Learning language");
                tv5.setText("Native language:");
                editTime.setHint("Write time(s)");
                toast =Toast.makeText(getApplicationContext(),
                    "Write numbers", Toast.LENGTH_SHORT);
                break;
            case (2):
                textView1.setText("Français\uD83C\uDDEB\uD83C\uDDF7");
                tv1.setText("application de langue:");
                tv2.setText("Réglages");
                tv3.setText("Heure Audi:");
                tv4.setText("Apprendre une langue:");
                tv5.setText("Langue maternelle:");
                editTime.setHint("Heure(s) d'écriture");
                toast =Toast.makeText(getApplicationContext(),
                        "Écrire des nombres", Toast.LENGTH_SHORT);
                break;
            case (3):
                textView1.setText("Español\uD83C\uDDEA\uD83C\uDDF8");
                tv1.setText("aplicación de idioma:");
                tv2.setText("Ajustes");
                tv3.setText("Hora de Audi:");
                tv4.setText("Aprendiendo idioma:");
                tv5.setText("Lengua materna:");
                editTime.setHint("Escribir tiempo(s)");
                toast =Toast.makeText(getApplicationContext(),
                        "Escribir números", Toast.LENGTH_SHORT);
                break;
            case (4):
                textView1.setText("Português\uD83C\uDDF5\uD83C\uDDF9");
                tv1.setText("aplicativo de idiomas:");
                tv2.setText("Sintonização");
                tv3.setText("Tempo de audiência:");
                tv4.setText("Aprendendo idioma:");
                tv5.setText("Língua materna:");
                editTime.setHint("Hora(s) de gravação");
                toast =Toast.makeText(getApplicationContext(),
                        "Escrever números", Toast.LENGTH_SHORT);
                break;
            case (5):
                textView1.setText("Italiano\uD83C\uDDEE\uD83C\uDDF9");
                tv1.setText("app per la lingua:");
                tv2.setText("Regolazioni");
                tv3.setText("Ora dell'Audi:");
                tv4.setText("Imparare la lingua:");
                tv5.setText("Lingua nativa:");
                editTime.setHint("Scrivi tempo/i");
                toast =Toast.makeText(getApplicationContext(),
                        "Scrivi numeri", Toast.LENGTH_SHORT);
                break;
            case (6):
                textView1.setText("Deutsch\uD83C\uDDE9\uD83C\uDDEA");
                tv1.setText("Sprach-App:");
                tv2.setText("Die Einstellungen");
                tv3.setText("Audi-Zeit:");
                tv4.setText("Sprache lernen:");
                tv5.setText("Muttersprache:");
                editTime.setHint("Uhrzeit(en) schreiben");
                toast =Toast.makeText(getApplicationContext(),
                        "Zahlen schreiben", Toast.LENGTH_SHORT);
                break;
            case (7):
                textView1.setText("Русский\uD83C\uDDF7\uD83C\uDDFA");
                tv1.setText("Язык приложения:");
                tv2.setText("Настройки");
                tv3.setText("Время аудирования:");
                tv4.setText("Изучаемый язык:");
                tv5.setText("Родной язык:");
                editTime.setHint("Введи время (с)");
                toast =Toast.makeText(getApplicationContext(),
                        "Введите число", Toast.LENGTH_SHORT);
                break;
            case (8):
                textView1.setText("中文\uD83C\uDDE8\uD83C\uDDF3");
                tv1.setText("語言應用:");
                tv2.setText("设置");
                tv3.setText("奧迪時間:");
                tv4.setText("學習語言:");
                tv5.setText("母語:");
                editTime.setHint("寫入時間");
                toast =Toast.makeText(getApplicationContext(),
                        "寫數字", Toast.LENGTH_SHORT);
                break;
            case (9):
                textView1.setText("한국어\uD83C\uDDF0\uD83C\uDDF7");
                tv1.setText("언어 앱:");
                tv2.setText("설정");
                tv3.setText("아우디 시간:");
                tv4.setText("언어 학습:");
                tv5.setText("모국어:");
                editTime.setHint("쓰기 시간");
                toast =Toast.makeText(getApplicationContext(),
                        "숫자 쓰기", Toast.LENGTH_SHORT);
                break;
            case (10):
                textView1.setText("日本語\uD83C\uDDEF\uD83C\uDDF5");
                tv1.setText("言語アプリ:");
                tv2.setText("設定");
                tv3.setText("アウディ時間:");
                tv4.setText("言語の学習:");
                tv5.setText("母国語:");
                editTime.setHint("書き込み時間");
                toast =Toast.makeText(getApplicationContext(),
                        "数字を書く", Toast.LENGTH_SHORT);
                break;
            case (11):
                textView1.setText("हिन्दी\uD83C\uDDEE\uD83C\uDDF3");
                tv1.setText("भाषा ऐप:");
                tv2.setText("सेटिंग्स");
                tv3.setText("ऑडी समय:");
                tv4.setText("भाषा सीखना:");
                tv5.setText("देशी भाषा:");
                editTime.setHint("समय लिखें");
                toast =Toast.makeText(getApplicationContext(),
                        "नंबर लिखें", Toast.LENGTH_SHORT);
                break;
            case (12):
                textView1.setText("\uD83C\uDDE6\uD83C\uDDEAالعربية");
                tv1.setText("تطبيق اللغة:");
                tv2.setText("الإعدادات");
                tv3.setText("وقت أودي");
                tv4.setText("تعلم اللغة");
                tv5.setText("لغة محلية");
                editTime.setHint("كتابة الوقت (الأوقات)");
                toast =Toast.makeText(getApplicationContext(),
                        "اكتب الأرقام", Toast.LENGTH_SHORT);
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
        langW.setOnClickListener((v) -> {
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
        langwb.setOnClickListener((v) -> {
            langw -= 1;
            if(langw==0)
                langw = 12;
            try {
                Intent intent = new Intent(Test.this, Test.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        langww.setOnClickListener((v) -> {
            langw += 1;
            if(langw==13)
                langw = 1;
            try {
                Intent intent = new Intent(Test.this, Test.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        langtrb.setOnClickListener((v) -> {
            langtr -= 1;
            if(langtr==0)
                langtr = 12;
            try {
                Intent intent = new Intent(Test.this, Test.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        langtrw.setOnClickListener((v) -> {
            langtr += 1;
            if(langtr==13)
                langtr = 1;
            try {
                Intent intent = new Intent(Test.this, Test.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        switch (langw){
            case (1):
                textView2.setText("English\uD83C\uDDEC\uD83C\uDDE7");
                break;
            case (2):
                textView2.setText("Français\uD83C\uDDEB\uD83C\uDDF7");
                break;
            case (3):
                textView2.setText("Español\uD83C\uDDEA\uD83C\uDDF8");
                break;
            case (4):
                textView2.setText("Português\uD83C\uDDF5\uD83C\uDDF9");
                break;
            case (5):
                textView2.setText("Italiano\uD83C\uDDEE\uD83C\uDDF9");
                break;
            case (6):
                textView2.setText("Deutsch\uD83C\uDDE9\uD83C\uDDEA");
                break;
            case (7):
                textView2.setText("Русский\uD83C\uDDF7\uD83C\uDDFA");
                break;
            case (8):
                textView2.setText("中文\uD83C\uDDE8\uD83C\uDDF3");
                break;
            case (9):
                textView2.setText("한국어\uD83C\uDDF0\uD83C\uDDF7");
                break;
            case (10):
                textView2.setText("日本語\uD83C\uDDEF\uD83C\uDDF5");
                break;
            case (11):
                textView2.setText("हिन्दी\uD83C\uDDEE\uD83C\uDDF3");
                break;
            case (12):
                textView2.setText("\uD83C\uDDE6\uD83C\uDDEAالعربية");
                break;
        }
        switch (langtr) {
            case (1):
                textView3.setText("English\uD83C\uDDEC\uD83C\uDDE7");
                break;
            case (2):
                textView3.setText("Français\uD83C\uDDEB\uD83C\uDDF7");
                break;
            case (3):
                textView3.setText("Español\uD83C\uDDEA\uD83C\uDDF8");
                break;
            case (4):
                textView3.setText("Português\uD83C\uDDF5\uD83C\uDDF9");
                break;
            case (5):
                textView3.setText("Italiano\uD83C\uDDEE\uD83C\uDDF9");
                break;
            case (6):
                textView3.setText("Deutsch\uD83C\uDDE9\uD83C\uDDEA");
                break;
            case (7):
                textView3.setText("Русский\uD83C\uDDF7\uD83C\uDDFA");
                break;
            case (8):
                textView3.setText("中文\uD83C\uDDE8\uD83C\uDDF3");
                break;
            case (9):
                textView3.setText("한국어\uD83C\uDDF0\uD83C\uDDF7");
                break;
            case (10):
                textView3.setText("日本語\uD83C\uDDEF\uD83C\uDDF5");
                break;
            case (11):
                textView3.setText("हिन्दी\uD83C\uDDEE\uD83C\uDDF3");
                break;
            case (12):
                textView3.setText("\uD83C\uDDE6\uD83C\uDDEAالعربية");
                break;
        }
        Toast finalToast = toast;
        back.setOnClickListener((v) -> {
            try{
                pr = (Integer.parseInt(String.valueOf(editTime.getText())));
                try {
                    Intent intent = new Intent(Test.this, MainMenu.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }catch (Exception e){
                finalToast.show();
            }

        });


    }
}