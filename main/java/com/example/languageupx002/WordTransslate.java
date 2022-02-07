package com.example.languageupx002;


import static com.example.languageupx002.Table.fail;
import static com.example.languageupx002.Table.k;
import static com.example.languageupx002.Table.lang;
import static com.example.languageupx002.Table.rand1;
import static com.example.languageupx002.Table.rand2;
import static com.example.languageupx002.Table.right;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.atomic.AtomicInteger;

public class WordTransslate extends AppCompatActivity {
    DBhelper dbHelper;
    DopDB DB;
    String m;
    int max;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wordtranslate);
        this.getSupportActionBar().hide();
        final ImageButton quitButton = (ImageButton) findViewById(R.id.button35);
        final ImageButton nextButton = (ImageButton) findViewById(R.id.button33);
        final ImageButton checkButton = (ImageButton) findViewById(R.id.button31);
        dbHelper = new DBhelper(this);
        DB = new DopDB(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        SQLiteDatabase database2 = DB.getWritableDatabase();
        EditText edittranslate = findViewById(R.id.editWord);
        TextView tv = findViewById(R.id.textView5);
        TextView righttv = findViewById(R.id.textView3);
        TextView failtv = findViewById(R.id.textView9);
        TextView textView = findViewById(R.id.textView6);
        TextView textView2 = findViewById(R.id.textView7);
        TextView textright = findViewById(R.id.textView4);
        TextView textfail = findViewById(R.id.textView10);
        Cursor cursor = database.query(DBhelper.TABLE_CONTACTS, null, null, null, null, null, null);
        ContentValues contentValues = new ContentValues();
        rand2 = rand2 + rand1;
        if (rand2>k){
            rand2 = rand2 - k;
        }
        AtomicInteger flag = new AtomicInteger();
        int idIndex = cursor.getColumnIndex(DBhelper.KEY_ID);
        int nameIndex = cursor.getColumnIndex(DBhelper.KEY_WORD);
        int emailIndex = cursor.getColumnIndex(DBhelper.KEY_TRANSLATE);
        textright.setText(Integer.toString(right));
        textfail.setText(Integer.toString(fail));
        switch (lang){
            case (1):
                righttv.setText("Right");
                failtv.setText("Fail");
                tv.setText("Write translate");
                edittranslate.setHint("Write translate");
                break;
            case (2):
                tv.setText("Ecrire traduire");
                righttv.setText("À droite");
                failtv.setText("Tort");
                edittranslate.setHint("Ecrire traduire");
                break;
            case (3):
                tv.setText("Escribe traducir");
                righttv.setText("Correcto");
                failtv.setText("Incorrecto");
                edittranslate.setHint("Escribe traducir");
                break;
            case (4):
                tv.setText("Escrever traduzir");
                righttv.setText("Direito");
                failtv.setText("Errada");
                edittranslate.setHint("Escrever traduzir");
                break;
            case (5):
                tv.setText("Scrivi tradurre");
                righttv.setText("Destra");
                failtv.setText("Sbagliata");
                edittranslate.setHint("Scrivi tradurre");
                break;
            case (6):
                tv.setText("Schreiben Sie übersetzen");
                righttv.setText("Richtig");
                failtv.setText("Falsch");
                edittranslate.setHint("Schreiben Sie übersetzen");
                break;
            case (7):
                tv.setText("Напишите перевод");
                righttv.setText("Правильно");
                failtv.setText("Неправильно");
                edittranslate.setHint("Напишите перевод");
                break;
            case (8):
                tv.setText("寫翻譯");
                righttv.setText("對");
                failtv.setText("錯誤的");
                edittranslate.setHint("寫翻譯");
                break;
            case (9):
                tv.setText("번역 쓰기");
                righttv.setText("오른쪽");
                failtv.setText("잘못된");
                edittranslate.setHint("번역 쓰기");
                break;
            case (10):
                tv.setText("書き込み翻訳");
                righttv.setText("右");
                failtv.setText("間違い");
                edittranslate.setHint("書き込み翻訳");
                break;
            case (11):
                tv.setText("अनुवाद लिखें");
                righttv.setText("सही");
                failtv.setText("गलत");
                edittranslate.setHint("अनुवाद लिखें");
                break;
            case (12):
                tv.setText("اكتب ترجم");
                righttv.setText("حق");
                failtv.setText("خاطئ");
                edittranslate.setHint("اكتب ترجم");
                break;
        }
        if (cursor.moveToFirst()) {
            do {
                if (rand2 == cursor.getInt(idIndex)) {
                    String a = cursor.getString(nameIndex);
                    textView.setText(a);
                    String b = cursor.getString(emailIndex);
                    checkButton.setOnClickListener((v) -> {
                        if(flag.get() == 0){
                            String c = null;
                            String translate = edittranslate.getText().toString();
                            contentValues.put(DopDB.ANSWER, translate);
                            if(b.equals(translate)){
                                switch(lang){
                                    case(1):
                                        c = "Yes";
                                        break;
                                    case(2):
                                        c = "Oui";
                                        break;
                                    case(3):
                                        c = "Sí";
                                        break;
                                    case(4):
                                        c = "Sim";
                                        break;
                                    case(5):
                                        c = "Sì";
                                        break;
                                    case(6):
                                        c = "Ja";
                                        break;
                                    case(7):
                                        c = "Да";
                                        break;
                                    case(8):
                                        c = "是的";
                                        break;
                                    case(9):
                                        c = "네";
                                        break;
                                    case(10):
                                        c = "はい";
                                        break;
                                    case(11):
                                        c = "हां";
                                        break;
                                    case(12):
                                        c = "نعم";
                                        break;
                                }
                                contentValues.put(DopDB.SCORE, "1");
                                right = right + 1;
                            }else{
                                switch(lang){
                                    case(1):
                                        c = "No it is " + b;
                                        break;
                                    case(2):
                                        c = "Non c'est " + b;
                                        break;
                                    case(3):
                                        c = "No lo es " + b;
                                        break;
                                    case(4):
                                        c = "Não é " + b;
                                        break;
                                    case(5):
                                        c = "No lo è " + b;
                                        break;
                                    case(6):
                                        c = "Nein es ist " + b;
                                        break;
                                    case(7):
                                        c = "Нет это" + b;
                                        break;
                                    case(8):
                                        c = "不，它是 " + b;
                                        break;
                                    case(9):
                                        c = "아니요 " + b;
                                        break;
                                    case(10):
                                        c = "いいえ、ありません " + b;
                                        break;
                                    case(11):
                                        c = "नही यही है " + b;
                                        break;
                                    case(12):
                                        c = "لا هو كذلك " + b;
                                        break;
                                }
                                contentValues.put(DopDB.SCORE, "0");
                                fail = fail + 1;
                            }
                            textView2.setText(c);
                            flag.set(1);
                        }
                    });
                }
                if (right + fail >= k){
                    try {
                        Intent intent = new Intent(WordTransslate.this, Itog.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } while (cursor.moveToNext());
        } else
            Log.d("mLog","0 rows");
        database2.insert(DopDB.TABLE_CONTACTS2, null, contentValues);
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