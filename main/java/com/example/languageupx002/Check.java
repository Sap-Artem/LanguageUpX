package com.example.languageupx002;

import static com.example.languageupx002.Table.chet;
import static com.example.languageupx002.Table.flag;
import static com.example.languageupx002.Table.k;
import static com.example.languageupx002.Table.lang;
import static com.example.languageupx002.Table.rand1;
import static com.example.languageupx002.Table.rand2;
import static com.example.languageupx002.Table.s;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.ImageButton;
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
        this.getSupportActionBar().hide();
        final ImageButton quitButton = (ImageButton) findViewById(R.id.button35);
        LinearLayout llMainWord = (LinearLayout) findViewById(R.id.llMainWord2);
        LinearLayout llMainWord2 = (LinearLayout) findViewById(R.id.llMainWord);
        TextView tv = (TextView)findViewById(R.id.textView6);
        chet = 0;
        dbHelper = new DBhelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor cursor = database.query(DBhelper.TABLE_CONTACTS, null, null, null, null, null, null);
        LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(wrapContent, wrapContent);
        int btnGravity = Gravity.CENTER_HORIZONTAL;
        lParams.gravity = btnGravity;
        int idIndex = cursor.getColumnIndex(DBhelper.KEY_ID);
        int nameIndex = cursor.getColumnIndex(DBhelper.KEY_WORD);
        int emailIndex = cursor.getColumnIndex(DBhelper.KEY_TRANSLATE);
        String a = null;
        String s1;
        switch (lang){
            case(1):
                tv.setText("Check your answer");
                break;
            case(2):
                tv.setText("Vérifie ta réponse");
                break;
            case(3):
                tv.setText("Comprueba tu respuesta");
                break;
            case(4):
                tv.setText("Verifique sua resposta");
                break;
            case(5):
                tv.setText("Controlla la tua risposta");
                break;
            case(6):
                tv.setText("Überprüfe deine Antwort");
                break;
            case(7):
                tv.setText("Проверьте свои ответы");
                break;
            case(8):
                tv.setText("檢查你的答案");
                break;
            case(9):
                tv.setText("답을 확인하세요");
                break;
            case(10):
                tv.setText("あなたの答えを確認してください");
                break;
            case(11):
                tv.setText("अपने उत्तर की जांच करें");
                break;
            case(12):
                tv.setText("تحقق من إجابتك");
                break;
        }
        while(chet<k) {
            if (cursor.moveToFirst()) {
                do {
                    if (rand2 == cursor.getInt(idIndex)) {
                        if(s.contains("!"))
                            s1 = s.substring(0,s.indexOf("!"));
                        else
                            break;
                        chet = chet + 1;
                        if (flag == 1) {
                            a = cursor.getString(emailIndex);
                        }
                        if (flag == 2) {
                            a = cursor.getString(nameIndex);
                        }
                        TextView wordText = new TextView(this);
                        wordText.setText(a);
                        llMainWord.addView(wordText, lParams);
                        TextView wordText2 = new TextView(this);
                        wordText2.setText(s1);
                        if(s1.equals(a)) {
                            wordText.setTextColor(Color.GREEN);
                            wordText2.setTextColor(Color.GREEN);
                        }
                        else {
                            wordText.setTextColor(Color.RED);
                            wordText2.setTextColor(Color.RED);
                        }
                        s = s.substring(s.indexOf("!") + 1,s.length());
                        llMainWord2.addView(wordText2, lParams);
                        String number = String.valueOf(chet);
                        TextView numberText = new TextView(this);
                        numberText.setText(number);
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