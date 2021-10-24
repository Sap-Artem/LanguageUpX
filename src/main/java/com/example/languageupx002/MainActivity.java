package com.example.languageupx002;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button addButton = (Button) findViewById(R.id.button12);
        final Button list = (Button) findViewById(R.id.button2);
        final Button test1 = (Button) findViewById(R.id.button);
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

    }
}