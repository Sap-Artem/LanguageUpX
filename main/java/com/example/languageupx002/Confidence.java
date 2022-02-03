package com.example.languageupx002;


import static com.example.languageupx002.Table.lang;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Confidence extends AppCompatActivity {
    DBhelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confidence);
        final Button yesButton = (Button) findViewById(R.id.button18);
        final Button noButton = (Button) findViewById(R.id.button20);
        final TextView tv = (TextView) findViewById(R.id.textView20);
        dbHelper = new DBhelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        switch(lang){
            case(1):
                yesButton.setText("Yes");
                noButton.setText("No");
                tv.setText("Are you sure?");
                break;
            case(2):
                yesButton.setText("Oui");
                noButton.setText("Non");
                tv.setText("Es-tu sûr?");
                break;
            case(3):
                yesButton.setText("Sí");
                noButton.setText("No");
                tv.setText("Estas seguro(a)?");
                break;
            case(4):
                yesButton.setText("Sim");
                noButton.setText("Não");
                tv.setText("Tem certeza?");
                break;
            case(5):
                yesButton.setText("Sì");
                noButton.setText("No");
                tv.setText("Sei sicuro?");
                break;
            case(6):
                yesButton.setText("Ja");
                noButton.setText("Nein");
                tv.setText("Bist du sicher?");
                break;
            case(7):
                yesButton.setText("Да");
                noButton.setText("Нет");
                tv.setText("Вы уверены?");
                break;
            case(8):
                yesButton.setText("是的");
                noButton.setText("不");
                tv.setText("你確定嗎？");
                break;
            case(9):
                yesButton.setText("네");
                noButton.setText("아니");
                tv.setText("확실합니까?");
                break;
            case(10):
                yesButton.setText("はい");
                noButton.setText("番号");
                tv.setText("本気ですか？");
                break;
            case(11):
                yesButton.setText("हां");
                noButton.setText("नहीं");
                tv.setText("क्या आपको यकीन है?");
                break;
            case(12):
                yesButton.setText("نعم");
                noButton.setText("رقم");
                tv.setText("هل أنت متأكد؟");
                break;
        }
        noButton.setOnClickListener((v) -> {
            try {
                Intent intent = new Intent(Confidence.this, MainMenu.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        yesButton.setOnClickListener((v) -> {
            database.delete(DBhelper.TABLE_CONTACTS, null, null);
            try {
                Intent intent = new Intent(Confidence.this, MainMenu.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });

    }
}