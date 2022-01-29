package com.example.languageupx002;


import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageButton;

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
        EditText editword = findViewById(R.id.editWord);
        EditText edittranslate = findViewById(R.id.editTranslate);
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