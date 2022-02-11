package com.example.languageupx002;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.languageupx002.Table.fail;
import static com.example.languageupx002.Table.lang;
import static com.example.languageupx002.Table.langtr;
import static com.example.languageupx002.Table.langw;
import static com.example.languageupx002.Table.pr;
import static com.example.languageupx002.Table.right;

import androidx.appcompat.app.AppCompatActivity;

public class Tools extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tools);
        this.getSupportActionBar().hide();
        final ImageButton back = (ImageButton)findViewById(R.id.imageButton2);
        final ImageButton home = (ImageButton)findViewById(R.id.imageButton);
        EditText editTime = findViewById(R.id.editWord2);
        editTime.setText(Integer.toString(pr));
        TextView textView1 = (TextView)findViewById(R.id.textView28);
        TextView textView2 = (TextView)findViewById(R.id.textView30);
        TextView tv1 = (TextView)findViewById(R.id.textView24);
        TextView tv2 = (TextView)findViewById(R.id.textView25);
        TextView tv3 = (TextView)findViewById(R.id.textView26);
        TextView tv4 = (TextView)findViewById(R.id.textView27);
        ImageButton langw1 = (ImageButton)findViewById(R.id.imageView14);
        ImageButton langw2 = (ImageButton)findViewById(R.id.imageView15);
        ImageButton langtr1 = (ImageButton)findViewById(R.id.imageView12);
        ImageButton langtr2 = (ImageButton)findViewById(R.id.imageView13);
        langw1.setOnClickListener((v) -> {
            langw -= 1;
            if(langw==0)
                langw = 12;
            try {
                Intent intent = new Intent(Tools.this, Tools.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        langw2.setOnClickListener((v) -> {
            langw += 1;
            if(langw==13)
                langw = 1;
            try {
                Intent intent = new Intent(Tools.this, Tools.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        langtr1.setOnClickListener((v) -> {
            langtr -= 1;
            if(langtr==0)
                langtr = 12;
            try {
                Intent intent = new Intent(Tools.this, Tools.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        langtr2.setOnClickListener((v) -> {
            langtr += 1;
            if(langtr==13)
                langtr = 1;
            try {
                Intent intent = new Intent(Tools.this, Tools.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        switch (langw){
            case (1):
                textView1.setText("English\uD83C\uDDEC\uD83C\uDDE7");
                break;
            case (2):
                textView1.setText("Français\uD83C\uDDEB\uD83C\uDDF7");
                break;
            case (3):
                textView1.setText("Español\uD83C\uDDEA\uD83C\uDDF8");
                break;
            case (4):
                textView1.setText("Português\uD83C\uDDF5\uD83C\uDDF9");
                break;
            case (5):
                textView1.setText("Italiano\uD83C\uDDEE\uD83C\uDDF9");
                break;
            case (6):
                textView1.setText("Deutsch\uD83C\uDDE9\uD83C\uDDEA");
                break;
            case (7):
                textView1.setText("Русский\uD83C\uDDF7\uD83C\uDDFA");
                break;
            case (8):
                textView1.setText("中文\uD83C\uDDE8\uD83C\uDDF3");
                break;
            case (9):
                textView1.setText("한국어\uD83C\uDDF0\uD83C\uDDF7");
                break;
            case (10):
                textView1.setText("日本語\uD83C\uDDEF\uD83C\uDDF5");
                break;
            case (11):
                textView1.setText("हिन्दी\uD83C\uDDEE\uD83C\uDDF3");
                break;
            case (12):
                textView1.setText("\uD83C\uDDE6\uD83C\uDDEAالعربية");
                break;
        }
        switch (langtr) {
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
        switch (lang) {
            case (1):
                tv1.setText("Tools Audi");
                tv2.setText("Your Time");
                tv3.setText("Language Speakers (translate):");
                tv4.setText("Language Speakers (word):");
                editTime.setHint("Write time(s)");
                break;
            case (2):
                tv1.setText("Outils Audi");
                tv2.setText("Votre Temps");
                tv3.setText("Locuteurs de la langue (traduire):");
                tv4.setText("Locuteurs de la langue (word):");
                editTime.setHint("Heure(s) d'écriture");
                break;
            case (3):
                tv1.setText("Herramientas Audi");
                tv2.setText("Tu Tiempo");
                tv3.setText("Hablantes de idiomas (traducir):");
                tv4.setText("Hablantes de idiomas (word):");
                editTime.setHint("Escribir tiempo(s)");
                break;
            case (4):
                tv1.setText("Ferramentas Audi");
                tv2.setText("Seu tempo");
                tv3.setText("Falantes de idiomas (traduzir):");
                tv4.setText("Falantes de idioma (palavra):");
                editTime.setHint("Hora(s) de gravação");
                break;
            case (5):
                tv1.setText("Strumenti Audi");
                tv2.setText("Il tuo tempo");
                tv3.setText("Relatori di lingue (tradurre):");
                tv4.setText("Lingua parlanti (parola):");
                editTime.setHint("Scrivi tempo/i");
                break;
            case (6):
                tv1.setText("Werkzeuge Audi");
                tv2.setText("Deine Zeit");
                tv3.setText("Sprache Sprecher (übersetzen):");
                tv4.setText("Sprachsprecher (Wort):");
                editTime.setHint("Uhrzeit(en) schreiben");
                break;
            case (7):
                tv1.setText("Настройки аудирования");
                tv2.setText("Ваше время");
                tv3.setText("Язык озвучки (перевода)");
                tv4.setText("Язык озвучки (слова)");
                editTime.setHint("Введи время (с)");
                break;
            case (8):
                tv1.setText("工具 奧迪");
                tv2.setText("您的時間");
                tv3.setText("語言使用者（翻譯）：");
                tv4.setText("語言使用者（單詞）：");
                editTime.setHint("寫入時間");
                break;
            case (9):
                tv1.setText("도구 아우디");
                tv2.setText("당신의 시간");
                tv3.setText("언어 사용자(번역):");
                tv4.setText("언어 스피커(단어):");
                editTime.setHint("쓰기 시간");
                break;
            case (10):
                tv1.setText("ツールアウディ");
                tv2.setText("あなたの時間");
                tv3.setText("言語スピーカー（翻訳）：");
                tv4.setText("言語スピーカー（単語）：");
                editTime.setHint("書き込み時間");
                break;
            case (11):
                tv1.setText("उपकरण ऑडी");
                tv2.setText("तुम्हारा समय");
                tv3.setText("भाषा बोलने वाले (अनुवाद):");
                tv4.setText("भाषा बोलने वाले (शब्द):");
                editTime.setHint("समय लिखें");
                break;
            case (12):
                tv1.setText("أدوات أودي");
                tv2.setText("وقتك");
                tv3.setText("متحدثي اللغة (ترجمة):");
                tv4.setText("المتحدثون اللغويون (كلمة):");
                editTime.setHint("كتابة الوقت (الأوقات)");
                break;
        }
        home.setOnClickListener((v) -> {
            try{
                pr = (Integer.parseInt(String.valueOf(editTime.getText())));
                try {
                    Intent intent = new Intent(Tools.this, MainMenu.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }catch (Exception e){
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Write numbers", Toast.LENGTH_SHORT);
                toast.show();
            }

        });
        back.setOnClickListener((v) -> {
            try{
                pr = (Integer.parseInt(String.valueOf(editTime.getText())));
                try {
                    Intent intent = new Intent(Tools.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }catch (Exception e){
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Write numbers", Toast.LENGTH_SHORT);
                toast.show();
            }

        });


    }
}