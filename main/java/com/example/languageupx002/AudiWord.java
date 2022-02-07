package com.example.languageupx002;

import static com.example.languageupx002.Table.chet;
import static com.example.languageupx002.Table.flag;
import static com.example.languageupx002.Table.k;
import static com.example.languageupx002.Table.lang;
import static com.example.languageupx002.Table.langtr;
import static com.example.languageupx002.Table.langw;
import static com.example.languageupx002.Table.pr;
import static com.example.languageupx002.Table.rand1;
import static com.example.languageupx002.Table.rand2;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class AudiWord extends AppCompatActivity implements
            TextToSpeech.OnInitListener{
    DBhelper  dbHelper;
    private TextToSpeech tts;
    private String a;
    private TextView mTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auditransslate);
        this.getSupportActionBar().hide();
        final ImageButton toolsButton = (ImageButton) findViewById(R.id.imageButton4);
        final ImageButton quitButton = (ImageButton) findViewById(R.id.button35);
        dbHelper = new DBhelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor cursor = database.query(DBhelper.TABLE_CONTACTS, null, null, null, null, null, null);
        ContentValues contentValues = new ContentValues();
        chet = chet + 1;
        rand2 = rand2 + rand1;
        if (rand2>k){
            rand2 = rand2 - k;
        }
        int idIndex = cursor.getColumnIndex(DBhelper.KEY_ID);
        int nameIndex = cursor.getColumnIndex(DBhelper.KEY_WORD);
        int emailIndex = cursor.getColumnIndex(DBhelper.KEY_TRANSLATE);
        TextView tv = (TextView)findViewById(R.id.textView6);
        TextView tvd = (TextView)findViewById(R.id.textView33);
        switch (lang){
            case (1):
                tv.setText("*Write translate*");
                tvd.setText("(On a separate piece of paper)");
                break;
            case (2):
                tv.setText("*Ecrire traduire*");
                tvd.setText("(Sur une feuille de papier séparée)");
                break;
            case (3):
                tv.setText("*Escribe traducir*");
                tvd.setText("(En una hoja aparte)");
                break;
            case (4):
                tv.setText("*Escrever traduzir*");
                tvd.setText("(Em um pedaço de papel separado)");
                break;
            case (5):
                tv.setText("*Scrivi tradurre*");
                tvd.setText("(Su un foglio di carta separato)");
                break;
            case (6):
                tv.setText("*Schreiben Sie übersetzen*");
                tvd.setText("(Auf einem separaten Blatt Papier)");
                break;
            case (7):
                tv.setText("*Напишите перевод*");
                tvd.setText("(На отдельном листочке)");
                break;
            case (8):
                tv.setText("*寫翻譯*");
                tvd.setText("（在另一張紙上）");
                break;
            case (9):
                tv.setText("*번역 쓰기*");
                tvd.setText("(별도의 종이에)");
                break;
            case (10):
                tv.setText("*書き込み翻訳*");
                tvd.setText("（別の紙に）");
                break;
            case (11):
                tv.setText("*अनुवाद लिखें*");
                tvd.setText("(एक अलग कागज पर)");
                break;
            case (12):
                tv.setText("*اكتب ترجم*");
                tvd.setText("(على قطعة ورق منفصلة)");
                break;
        }
        tts = new TextToSpeech(this, this);
        mTimer = (TextView)findViewById(R.id.tv);
        final CountDownTimer timer = new CountDownTimer(pr*1000, 1) {
            public void onTick(long millisUntilFinished) {
                mTimer.setText(millisUntilFinished + "ms");
            }
            public void onFinish() {
                try {
                    Intent intent = new Intent(AudiWord.this, AudiWord.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        if (cursor.moveToFirst()) {
            do {
                if (rand2 == cursor.getInt(idIndex)) {
                    a = cursor.getString(emailIndex);
                    speakOut();
                    if (chet > k){
                        chet = 0;
                        flag = 2;
                        timer.cancel();
                        try {
                            Intent intent = new Intent(AudiWord.this, Check.class);
                            startActivity(intent);
                            finish();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }while (cursor.moveToNext());
        }
        quitButton.setOnClickListener((v) -> {
            timer.cancel();
            try {
                Intent intent = new Intent(AudiWord.this, MainActivity.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        toolsButton.setOnClickListener((v) -> {
            timer.cancel();
            try {
                Intent intent = new Intent(AudiWord.this, Tools.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
    }

    private void speakOut() {
        String text = a.toString();
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }
    @Override
    public void onDestroy() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }
    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int result = 0;
            switch (langw){
                case(1):
                    result = tts.setLanguage(Locale.US);
                    break;
                case(2):
                    result = tts.setLanguage(Locale.FRANCE);
                    break;
                case(3):
                    Locale locale = new Locale("es");
                    result = tts.setLanguage(locale);
                    break;
                case(4):
                    Locale locale2 = new Locale("pt");
                    result = tts.setLanguage(locale2);
                    break;
                case(5):
                    Locale locale3 = new Locale("it");
                    result = tts.setLanguage(locale3);
                    break;
                case(6):
                    Locale locale4 = new Locale("de");
                    result = tts.setLanguage(locale4);
                    break;
                case(7):
                    Locale locale5 = new Locale("ru");
                    result = tts.setLanguage(locale5);
                    break;
                case(8):
                    result = tts.setLanguage(Locale.CHINA);
                    break;
                case(9):
                    result = tts.setLanguage(Locale.KOREA);
                    break;
                case(10):
                    result = tts.setLanguage(Locale.JAPANESE);
                    break;
                case(11):
                    Locale locale6 = new Locale("in");
                    result = tts.setLanguage(locale6);
                    break;
                case(12):
                    Locale locale7 = new Locale("ar");
                    result = tts.setLanguage(locale7);
                    break;
            }

            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
                speakOut();
            }

        } else {
            Log.e("TTS", "Initilization Failed!");
        }
    }
}