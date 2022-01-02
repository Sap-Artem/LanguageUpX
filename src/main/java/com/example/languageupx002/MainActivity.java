package com.example.languageupx002;

import static com.example.languageupx002.Table.chet;
import static com.example.languageupx002.Table.fail;
import static com.example.languageupx002.Table.k;
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
import android.widget.TextView;

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
        final Button addButton = (Button) findViewById(R.id.button12);
        final Button list = (Button) findViewById(R.id.button2);
        final Button couple = (Button) findViewById(R.id.button4);
        final Button test1 = (Button) findViewById(R.id.button);
        final Button test2 = (Button) findViewById(R.id.button3);
        final Button test = (Button) findViewById(R.id.button10);
        final Button schooltest1 = (Button) findViewById(R.id.button5);
        final Button schooltest2 = (Button) findViewById(R.id.button7);
        final Button auditest1 = (Button) findViewById(R.id.button6);
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
            try {
                Intent intent = new Intent(MainActivity.this, SchoolTransslate.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        schooltest2.setOnClickListener((v) -> {
            try {
                Intent intent = new Intent(MainActivity.this, SchoolWord.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
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
    }
}