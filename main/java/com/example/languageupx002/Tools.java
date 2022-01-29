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
import static com.example.languageupx002.Table.pr;
import androidx.appcompat.app.AppCompatActivity;

public class Tools extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tools);
        final ImageButton back = (ImageButton)findViewById(R.id.imageButton2);
        final ImageButton home = (ImageButton)findViewById(R.id.imageButton);
        final ImageButton an1 = (ImageButton)findViewById(R.id.imageButton5);
        final ImageButton fr1 = (ImageButton)findViewById(R.id.imageButton6);
        final ImageButton sp1 = (ImageButton)findViewById(R.id.imageButton7);
        final ImageButton po1 = (ImageButton)findViewById(R.id.imageButton10);
        final ImageButton ge1 = (ImageButton)findViewById(R.id.imageButton9);
        final ImageButton it1 = (ImageButton)findViewById(R.id.imageButton8);
        final ImageButton ru1 = (ImageButton)findViewById(R.id.imageButton11);
        final ImageButton ch1 = (ImageButton)findViewById(R.id.imageButton12);
        final ImageButton ja1 = (ImageButton)findViewById(R.id.imageButton23);
        final ImageButton ko1 = (ImageButton)findViewById(R.id.imageButton16);
        final ImageButton ar1 = (ImageButton)findViewById(R.id.imageButton14);
        final ImageButton in1 = (ImageButton)findViewById(R.id.imageButton15);
        final ImageButton an2 = (ImageButton)findViewById(R.id.imageButton20);
        final ImageButton fr2 = (ImageButton)findViewById(R.id.imageButton24);
        final ImageButton sp2 = (ImageButton)findViewById(R.id.imageButton27);
        final ImageButton po2 = (ImageButton)findViewById(R.id.imageButton30);
        final ImageButton ge2 = (ImageButton)findViewById(R.id.imageButton29);
        final ImageButton it2 = (ImageButton)findViewById(R.id.imageButton28);
        final ImageButton ru2 = (ImageButton)findViewById(R.id.imageButton21);
        final ImageButton ch2 = (ImageButton)findViewById(R.id.imageButton22);
        final ImageButton ja2 = (ImageButton)findViewById(R.id.imageButton13);
        final ImageButton ko2 = (ImageButton)findViewById(R.id.imageButton36);
        final ImageButton ar2 = (ImageButton)findViewById(R.id.imageButton34);
        final ImageButton in2 = (ImageButton)findViewById(R.id.imageButton35);
        EditText editTime = findViewById(R.id.editWord2);
        editTime.setText(Integer.toString(pr));
        an1.setOnClickListener((v) -> {
            an1.setImageResource(R.drawable.add);
        });
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