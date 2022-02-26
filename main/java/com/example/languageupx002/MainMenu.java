package com.example.languageupx002;

import static com.example.languageupx002.Table.flag2;
import static com.example.languageupx002.Table.k;
import static com.example.languageupx002.Table.k2;
import static com.example.languageupx002.Table.lang;
import static com.example.languageupx002.Table.langw;
import static com.example.languageupx002.Table.langtr;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainMenu extends AppCompatActivity {
    DBhelper  db;
    Db2 db2;
    MediaPlayer mPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        this.getSupportActionBar().hide();
        db2 = new Db2(this);
        SQLiteDatabase dbl = db2.getWritableDatabase();
        Cursor c = dbl.query("mytable", null, null, null, null, null, null);
        k = 0;
        db = new DBhelper(this);
        SQLiteDatabase database = db.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        database.insert(DBhelper.TABLE_CONTACTS, null, contentValues);
        Cursor cursor = database.query(DBhelper.TABLE_CONTACTS, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                k = k + 1;
            } while (cursor.moveToNext());
        } else
            Log.d("mLog","0 rows");
        cursor.close();
        if (c.moveToFirst()) {
            do {
                k2 = k2 + 1;
            } while (cursor.moveToNext());
        } else
            Log.d("mLog","0 rows");
        cursor.close();
        if(k == 0 & k2 == 0){
            try {
                Intent intent = new Intent(MainMenu.this, Welcome.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (c.moveToFirst()) {
            int idColIndex0 = c.getColumnIndex("id");
            int idColIndex = c.getColumnIndex("lang");
            int nameColIndex = c.getColumnIndex("langw");
            int emailColIndex = c.getColumnIndex("langtr");
            do {
                lang = c.getInt(idColIndex);
                langw = c.getInt(nameColIndex);
                langtr = c.getInt(emailColIndex);
            } while (c.moveToNext());
        }
        c.close();
        mPlayer = MediaPlayer.create(this, R.raw.music);
        if(flag2==0) {
            mPlayer.start();
            flag2 = 1;
        }
        final Button testButton = (Button) findViewById(R.id.button13);
        final ImageButton addButton = (ImageButton) findViewById(R.id.button15);
        final ImageButton listButton = (ImageButton) findViewById(R.id.button25);
        final ImageButton nastButton = (ImageButton) findViewById(R.id.imageButton3);
        Toast toast = Toast.makeText(getApplicationContext(),
                "", Toast.LENGTH_SHORT);
        switch (lang){
            case (1):
                testButton.setText("Start Tests");
                toast = Toast.makeText(getApplicationContext(),
                        "Add at least 3 words to the database", Toast.LENGTH_SHORT);
                break;
            case (2):
                testButton.setText("Commencer les tests");
                toast = Toast.makeText(getApplicationContext(),
                        "Ajouter au moins 3 mots à la base de données", Toast.LENGTH_SHORT);
                break;
            case (3):
                testButton.setText("Iniciar pruebas");
                toast = Toast.makeText(getApplicationContext(),
                        "Agregue al menos 3 palabras a la base de datos", Toast.LENGTH_SHORT);
                break;
            case (4):
                testButton.setText("Iniciar testes");
                toast = Toast.makeText(getApplicationContext(),
                        "Adicione pelo menos 3 palavras ao banco de dados", Toast.LENGTH_SHORT);
                break;
            case (5):
                testButton.setText("Avviare i test");
                toast = Toast.makeText(getApplicationContext(),
                        "Aggiungi almeno 3 parole al database", Toast.LENGTH_SHORT);
                break;
            case (6):
                testButton.setText("Tests starten");
                toast = Toast.makeText(getApplicationContext(),
                        "Fügen Sie der Datenbank mindestens 3 Wörter hinzu", Toast.LENGTH_SHORT);
                break;
            case (7):
                testButton.setText("Начать тесты");
                toast = Toast.makeText(getApplicationContext(),
                        "Добавьте хотя бы 3 слова, чтобы открыть тесты", Toast.LENGTH_SHORT);
                break;
            case (8):
                testButton.setText("开始测试");
                toast = Toast.makeText(getApplicationContext(),
                        "將至少 3 個單詞添加到數據庫中", Toast.LENGTH_SHORT);
                break;
            case (9):
                testButton.setText("테스트 시작");
                toast = Toast.makeText(getApplicationContext(),
                        "데이터베이스에 최소 3단어 추가", Toast.LENGTH_SHORT);
                break;
            case (10):
                testButton.setText("テスト開始");
                toast = Toast.makeText(getApplicationContext(),
                        "データベースに少なくとも3つの単語を追加します", Toast.LENGTH_SHORT);
                break;
            case (11):
                testButton.setText("परीक्षण शुरू करें");
                toast = Toast.makeText(getApplicationContext(),
                        "डेटाबेस में कम से कम 3 शब्द जोड़ें", Toast.LENGTH_SHORT);
                break;
            case (12):
                testButton.setText("بدء الاختبارات");
                toast = Toast.makeText(getApplicationContext(),
                        "أضف 3 كلمات على الأقل إلى قاعدة البيانات", Toast.LENGTH_SHORT);
                break;
        }
        nastButton.setOnClickListener((v) -> {
            try {
                Intent intent = new Intent(MainMenu.this, Test.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        listButton.setOnClickListener((v) -> {
            try {
                Intent intent = new Intent(MainMenu.this, List.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        addButton.setOnClickListener((v) -> {
            try {
                Intent intent = new Intent(MainMenu.this, AddText.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        Toast finalToast = toast;
        testButton.setOnClickListener((v) -> {
            if(k>=3) {
                try {
                    Intent intent = new Intent(MainMenu.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else{
                finalToast.show();
            }

        });
    }
}