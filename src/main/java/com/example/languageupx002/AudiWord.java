package com.example.languageupx002;

import static com.example.languageupx002.Table.chet;
import static com.example.languageupx002.Table.flag;
import static com.example.languageupx002.Table.k;
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
            Locale localDef = Locale.getDefault();
            Locale locale = new Locale("ru");
            int result = tts.setLanguage(new Locale(Locale.getDefault().getLanguage()));

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