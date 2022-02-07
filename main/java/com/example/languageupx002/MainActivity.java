package com.example.languageupx002;

import static com.example.languageupx002.Table.chet;
import static com.example.languageupx002.Table.fail;
import static com.example.languageupx002.Table.k;
import static com.example.languageupx002.Table.lang;
import static com.example.languageupx002.Table.rand1;
import static com.example.languageupx002.Table.rand2;
import static com.example.languageupx002.Table.right;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {
    DBhelper  db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        k = 0;
        right = 0;
        fail = 0;
        chet = 0;
        final ImageButton addButton = (ImageButton) findViewById(R.id.button12);
        final ImageButton list = (ImageButton) findViewById(R.id.button2);
        final Button couple = (Button) findViewById(R.id.button4);
        final Button test1 = (Button) findViewById(R.id.button);
        final Button test2 = (Button) findViewById(R.id.button3);
        final ImageButton test = (ImageButton) findViewById(R.id.button10);
        final Button schooltest1 = (Button) findViewById(R.id.button5);
        final Button schooltest2 = (Button) findViewById(R.id.button7);
        final Button auditest1 = (Button) findViewById(R.id.button6);
        final Button auditest2 = (Button) findViewById(R.id.button24);
        final TextView tv = (TextView) findViewById(R.id.textView);
        db = new DBhelper(this);
        SQLiteDatabase database = db.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        database.insert(DBhelper.TABLE_CONTACTS, null, contentValues);
        Cursor cursor = database.query(DBhelper.TABLE_CONTACTS, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex(DBhelper.KEY_ID);
            int nameIndex = cursor.getColumnIndex(DBhelper.KEY_WORD);
            int emailIndex = cursor.getColumnIndex(DBhelper.KEY_TRANSLATE);
            do {
                Log.d("mLog", "ID = " + cursor.getInt(idIndex) +
                        ", name = " + cursor.getString(nameIndex) +
                        ", email = " + cursor.getString(emailIndex));
                k = k + 1;
            } while (cursor.moveToNext());
        } else
            Log.d("mLog","0 rows");
        cursor.close();

        switch (lang){
            case (1):
                test1.setText("Write translate");
                test2.setText("Write word");
                couple.setText("Find a couple");
                schooltest1.setText("School Test: Translate");
                schooltest2.setText("School Test: Word");
                auditest1.setText("Listening Skills: Translate");
                auditest2.setText("Listening Skills: Word");
                tv.setText("All Tests");
                break;
            case (2):
                test1.setText("Écrire traduire");
                test2.setText("Écrire un mot");
                couple.setText("Trouver un couple");
                schooltest1.setText("Test scolaire: Traduire");
                schooltest2.setText("Test scolaire: mot");
                auditest1.setText("Compétences d'écoute: Traduire");
                auditest2.setText("Compétences d'écoute: mot");
                tv.setText("Tous Les Tests");
                break;
            case (3):
                test1.setText("Escribir traducir");
                test2.setText("Escribir palabra");
                couple.setText("Encontrar una pareja");
                schooltest1.setText("Prueba Escolar: Traducir");
                schooltest2.setText("Prueba Escolar: Palabra");
                auditest1.setText("Habilidades de escucha: Traducir");
                auditest2.setText("Habilidades de escucha: Palabra");
                tv.setText("Todas las pruebas");
                break;
            case (4):
                test1.setText("Escrever traduzir");
                test2.setText("Escrever palavra");
                couple.setText("Encontre um casal");
                schooltest1.setText("Teste escolar: Traduzir");
                schooltest2.setText("Teste Escolar: Palavra");
                auditest1.setText("Habilidades de escuta: Traduzir");
                auditest2.setText("Habilidades de escuta: Palavra");
                tv.setText("Todos os testes");
                break;
            case (5):
                test1.setText("Scrivi tradurre");
                test2.setText("Scrivi parola");
                couple.setText("Trova una coppia");
                schooltest1.setText("Test scolastico: Traduci");
                schooltest2.setText("Prova scolastica: Parola");
                auditest1.setText("Capacità di ascolto: tradurre");
                auditest2.setText("Capacità di ascolto: Parola");
                tv.setText("Tutti i test");
                break;
            case (6):
                test1.setText("Schreiben Sie übersetzen");
                test2.setText("Wort schreiben");
                couple.setText("Finden Sie ein Paar");
                schooltest1.setText("Schultest: Übersetzen");
                schooltest2.setText("Schultest: Wort");
                auditest1.setText("Hörverständnis: Übersetzen");
                auditest2.setText("Hörverständnis: Wort");
                tv.setText("Alle Prüfungen");
                break;
            case (7):
                test1.setText("Написать перевод");
                test2.setText("Написать слово");
                couple.setText("Найди пару");
                schooltest1.setText("Школьный тест: перевод");
                schooltest2.setText("Школьный тест: слово");
                auditest1.setText("Аудирование: перевод");
                auditest2.setText("Аудирование: слово");
                tv.setText("Все тесты");
                break;
            case (8):
                test1.setText("寫翻譯");
                test2.setText("寫字");
                couple.setText("找一對");
                schooltest1.setText("學校考試：翻譯");
                schooltest2.setText("學校測試：單詞");
                auditest1.setText("聽力技巧：翻譯");
                auditest2.setText("聽力技巧：單詞");
                tv.setText("所有測試");
                break;
            case (9):
                test1.setText("번역 쓰기");
                test2.setText("단어 쓰기");
                couple.setText("커플 찾기");
                schooltest1.setText("학교 시험: 번역");
                schooltest2.setText("학교 시험: 단어");
                auditest1.setText("듣기 능력: 번역");
                auditest2.setText("듣기 능력: 단어");
                tv.setText("모든 테스트");
                break;
            case (10):
                test1.setText("書き込み翻訳");
                test2.setText("単語を書く");
                couple.setText("カップルを探す");
                schooltest1.setText("学校のテスト：翻訳");
                schooltest2.setText("学校のテスト：単語");
                auditest1.setText("リスニングスキル：翻訳");
                auditest2.setText("リスニングスキル：単語");
                tv.setText("すべてのテスト");
                break;
            case (11):
                test1.setText("अनुवाद लिखें");
                test2.setText("शब्द लिखें");
                couple.setText("एक युगल खोजें");
                schooltest1.setText("स्कूल टेस्ट: अनुवाद");
                schooltest2.setText("स्कूल टेस्ट: शब्द");
                auditest1.setText("सुनने के कौशल: अनुवाद");
                auditest2.setText("सुनने के कौशल: शब्द");
                tv.setText("सभी परीक्षण");
                break;
            case (12):
                test1.setText("اكتب ترجم");
                test2.setText("اكتب كلمة");
                couple.setText("ابحث عن زوجين");
                schooltest1.setText("اختبار المدرسة: ترجمة");
                schooltest2.setText("اختبار المدرسة: كلمة");
                auditest1.setText("مهارات الاستماع: ترجمة");
                auditest2.setText("مهارات الاستماع: كلمة");
                tv.setText("كل الاختبارات");
                break;
        }
        while (true){
            do{
                rand1 = (int)(Math.random()*(k)+1);
            }while (rand1 == 1);
            int t;
            int b = rand1;
            int a = k;
            while(b != 0){
                t = a;
                a = b;
                b = t%b;
            }
            if (a==1){
                break;
            }
        }
        rand2 = (int)(Math.random()*(k)+1);
        Toast toast = Toast.makeText(getApplicationContext(),
                "Add at least 6 words to the database", Toast.LENGTH_SHORT);
        addButton.setOnClickListener((v) -> {
            try {
                Intent intent = new Intent(MainActivity.this, AddText.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        list.setOnClickListener((v) -> {
            try {
                Intent intent = new Intent(MainActivity.this, List.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        test1.setOnClickListener((v) -> {
            try {
                Intent intent = new Intent(MainActivity.this, WordTransslate.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        schooltest1.setOnClickListener((v) -> {
            if(k>=6) {
                try {
                    Intent intent = new Intent(MainActivity.this, SchoolTransslate.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else{
                toast.show();
            }

        });
        schooltest2.setOnClickListener((v) -> {
            if(k>=6) {
                try {
                    Intent intent = new Intent(MainActivity.this, SchoolWord.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else{
                toast.show();
            }

        });
        test2.setOnClickListener((v) -> {
            try {
                Intent intent = new Intent(MainActivity.this, TransslateWord.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        test.setOnClickListener((v) -> {
            try {
                Intent intent = new Intent(MainActivity.this, Test.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        couple.setOnClickListener((v) -> {
            try {
                Intent intent = new Intent(MainActivity.this, Couple.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        auditest1.setOnClickListener((v) -> {
            try {
                Intent intent = new Intent(MainActivity.this, AudiTransslate.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        auditest2.setOnClickListener((v) -> {
            try {
                Intent intent = new Intent(MainActivity.this, AudiWord.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
    }
}