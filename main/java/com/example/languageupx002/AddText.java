package com.example.languageupx002;


import static com.example.languageupx002.Table.lang;

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

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;


public class AddText extends AppCompatActivity {
    DBhelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plus);
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        final ImageButton quitButton = (ImageButton) findViewById(R.id.button9);
        final ImageButton addwordButton = (ImageButton) findViewById(R.id.button8);
        final TextView tv = (TextView)findViewById(R.id.textView2);
        EditText editword = findViewById(R.id.editWord);
        EditText edittranslate = findViewById(R.id.editTranslate);
        switch (lang){
            case (1):
                tv.setText("Add new word");
                editword.setHint("Write word");
                edittranslate.setHint("Write translate");
                break;
            case (2):
                tv.setText("Ajouter un nouveau mot");
                editword.setHint("Écrire un mot");
                edittranslate.setHint("Ecrire traduire");
                break;
            case (3):
                tv.setText("Añadir nueva palabra");
                editword.setHint("Escribir palabra");
                edittranslate.setHint("Escribir traducir");
                break;
            case (4):
                tv.setText("Adicionar nova palavra");
                editword.setHint("Escrever palavra");
                edittranslate.setHint("Escrever traduzir");
                break;
            case (5):
                tv.setText("Aggiungi una nuova parola");
                editword.setHint("Scrivi parola");
                edittranslate.setHint("Scrivi tradurre");
                break;
            case (6):
                tv.setText("Neues Wort hinzufügen");
                editword.setHint("Wort schreiben");
                edittranslate.setHint("Schreiben Sie übersetzen");
                break;
            case (7):
                tv.setText("Добавить новое слово");
                editword.setHint("Напишите слово");
                edittranslate.setHint("Напишите его перевод");
                break;
            case (8):
                tv.setText("添加新詞");
                editword.setHint("寫字");
                edittranslate.setHint("寫翻譯");
                break;
            case (10):
                tv.setText("新しい単語を追加");
                editword.setHint("単語を書く");
                edittranslate.setHint("書き込み翻訳");
                break;
            case (9):
                tv.setText("새 단어 추가");
                editword.setHint("단어 쓰기");
                edittranslate.setHint("번역 쓰기");
                break;
            case (11):
                tv.setText("नया शब्द जोड़ें");
                editword.setHint("शब्द लिखें");
                edittranslate.setHint("अनुवाद लिखें");
                break;
            case (12):
                tv.setText("أضف كلمة جديدة");
                editword.setHint("اكتب كلمة");
                edittranslate.setHint("اكتب ترجم");
                break;
        }
        dbHelper = new DBhelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        quitButton.setOnClickListener((v) -> {
            try {
                Intent intent = new Intent(AddText.this, MainMenu.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        addwordButton.setOnClickListener(v -> {
            String word = editword.getText().toString();
            String translate = edittranslate.getText().toString();
            //textword.setText(word);
            //texttranslate.setText(translate);
            contentValues.put(DBhelper.KEY_WORD, word);
            contentValues.put(DBhelper.KEY_TRANSLATE, translate);

            database.insert(DBhelper.TABLE_CONTACTS, null, contentValues);
            Cursor cursor = database.query(DBhelper.TABLE_CONTACTS, null, null, null, null, null, null);
            try {
                Intent intent = new Intent(AddText.this, AddText.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (cursor.moveToFirst()) {
                int idIndex = cursor.getColumnIndex(DBhelper.KEY_ID);
                int nameIndex = cursor.getColumnIndex(DBhelper.KEY_WORD);
                int emailIndex = cursor.getColumnIndex(DBhelper.KEY_TRANSLATE);
                do {
                    Log.d("mLog", "ID = " + cursor.getInt(idIndex) +
                            ", name = " + cursor.getString(nameIndex) +
                            ", email = " + cursor.getString(emailIndex));
                } while (cursor.moveToNext());
            } else
                Log.d("mLog","0 rows");
            cursor.close();
            //Log.d("mLog", "ID = " + m);
        });
    }
}