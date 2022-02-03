package com.example.languageupx002;


import static com.example.languageupx002.Table.reserve_id;

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

public class Cards extends AppCompatActivity {
    DBhelper dbHelper;
    final String LOG_TAG = "myLogs";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cards);
        final ImageButton quitButton = (ImageButton) findViewById(R.id.button36);
        final ImageButton saveButton = (ImageButton) findViewById(R.id.button27);
        final ImageButton deleteButton = (ImageButton) findViewById(R.id.button34);
        final ImageButton backButton = (ImageButton) findViewById(R.id.button37);
        final TextView textView = (TextView) findViewById(R.id.textView23);
        EditText editword = findViewById(R.id.editWord);
        EditText edittranslate = findViewById(R.id.editTranslate);
        dbHelper = new DBhelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor cursor = database.query(DBhelper.TABLE_CONTACTS, null, null, null, null, null, null);
        ContentValues contentValues = new ContentValues();
        int idIndex = cursor.getColumnIndex(DBhelper.KEY_ID);
        int nameIndex = cursor.getColumnIndex(DBhelper.KEY_WORD);
        int emailIndex = cursor.getColumnIndex(DBhelper.KEY_TRANSLATE);
        Log.d("mLog","-" +  reserve_id + "-");
        if (cursor.moveToFirst()) {
            do {
                if (reserve_id == cursor.getInt(idIndex)) {
                    editword.setText(cursor.getString(nameIndex));
                    edittranslate.setText(cursor.getString(emailIndex));
                    textView.setText(String.valueOf(reserve_id));
                    saveButton.setOnClickListener((v) -> {
                        contentValues.put(DBhelper.KEY_WORD, editword.getText().toString());
                        contentValues.put(DBhelper.KEY_TRANSLATE, edittranslate.getText().toString());
                        database.update(DBhelper.TABLE_CONTACTS, contentValues, DBhelper.KEY_ID + "= ?", new String[] {String.valueOf(reserve_id)});
                        try {
                            Intent intent = new Intent(Cards.this, List.class);
                            startActivity(intent);
                            finish();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
                    deleteButton.setOnClickListener((v) -> {
                        database.delete(DBhelper.TABLE_CONTACTS, DBhelper.KEY_ID + "=" + reserve_id, null);
                        try {
                            Intent intent = new Intent(Cards.this, Amendment.class);
                            startActivity(intent);
                            finish();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
                }
            } while (cursor.moveToNext());
        } else
            Log.d("mLog","0 rows");
        quitButton.setOnClickListener((v) -> {
            try {
                Intent intent = new Intent(Cards.this, MainMenu.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        backButton.setOnClickListener((v) -> {
            try {
                Intent intent = new Intent(Cards.this, List.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
    }
}