package com.example.languageupx002;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageButton;
import static com.example.languageupx002.Table.pr;
import androidx.appcompat.app.AppCompatActivity;

public class Tools extends AppCompatActivity {

    DopDB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tools);
        final ImageButton back = (ImageButton)findViewById(R.id.imageButton2);
        final ImageButton home = (ImageButton)findViewById(R.id.imageButton);
        EditText editTime = findViewById(R.id.editWord2);
        editTime.setText(Integer.toString(pr));
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