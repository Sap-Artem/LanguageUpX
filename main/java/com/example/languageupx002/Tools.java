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

import static com.example.languageupx002.Table.fail;
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
        final ImageButton back = (ImageButton)findViewById(R.id.imageButton2);
        final ImageButton home = (ImageButton)findViewById(R.id.imageButton);
        EditText editTime = findViewById(R.id.editWord2);
        editTime.setText(Integer.toString(pr));
        TextView textView1 = (TextView)findViewById(R.id.textView28);
        TextView textView2 = (TextView)findViewById(R.id.textView30);
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
        home.setOnClickListener((v) -> {
            pr = (Integer.parseInt(String.valueOf(editTime.getText())));
            try {
                Intent intent = new Intent(Tools.this, MainMenu.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        back.setOnClickListener((v) -> {
            pr = (Integer.parseInt(String.valueOf(editTime.getText())));
            try {
                Intent intent = new Intent(Tools.this, MainActivity.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });


    }
}