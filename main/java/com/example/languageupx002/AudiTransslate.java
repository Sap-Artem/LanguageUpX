package com.example.languageupx002;

import static com.example.languageupx002.Table.chet;
import static com.example.languageupx002.Table.flag;
import static com.example.languageupx002.Table.k;
import static com.example.languageupx002.Table.langtr;
import static com.example.languageupx002.Table.pr;
import static com.example.languageupx002.Table.rand1;
import static com.example.languageupx002.Table.rand2;
import static com.example.languageupx002.Table.right;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class AudiTransslate extends AppCompatActivity implements
        TextToSpeech.OnInitListener{
    DBhelper  dbHelper;
    private TextToSpeech tts;
    private String a;
    private TextView mTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auditransslate);
        final ImageButton quitButton = (ImageButton) findViewById(R.id.button35);
        final ImageButton toolsButton = (ImageButton) findViewById(R.id.imageButton4);
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
        tts = new TextToSpeech(this, this);
        mTimer = (TextView)findViewById(R.id.tv);
        final CountDownTimer timer = new CountDownTimer(pr*1000, 1) {
            public void onTick(long millisUntilFinished) {
                mTimer.setText(millisUntilFinished + "ms");
            }
            public void onFinish() {
                try {
                    Intent intent = new Intent(AudiTransslate.this, AudiTransslate.class);
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
                    a = cursor.getString(nameIndex);
                    speakOut();
                    if (chet > k){
                        chet = 0;
                        flag = 1;
                        timer.cancel();
                        try {
                            Intent intent = new Intent(AudiTransslate.this, Check.class);
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
                Intent intent = new Intent(AudiTransslate.this, MainActivity.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        toolsButton.setOnClickListener((v) -> {
            timer.cancel();
            try {
                Intent intent = new Intent(AudiTransslate.this, Tools.class);
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
            switch (langtr){
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