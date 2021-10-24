package com.example.languageupx002;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class WordTransslate extends AppCompatActivity {
    //DBhelper dbHelper;
    //Random rnd = new Random(System.currentTimeMillis());
    String m;
    int max;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wordtranslate);
        final Button quitButton = (Button) findViewById(R.id.button15);
        final Button nextButton = (Button) findViewById(R.id.button13);
        quitButton.setOnClickListener((v) -> {
            try {
                Intent intent = new Intent(WordTransslate.this, MainActivity.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
    }
}