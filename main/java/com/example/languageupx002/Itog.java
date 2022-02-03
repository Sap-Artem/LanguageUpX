package com.example.languageupx002;

import static com.example.languageupx002.Table.fail;
import static com.example.languageupx002.Table.k;
import static com.example.languageupx002.Table.right;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Itog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itog);
        TextView rightanswer = findViewById(R.id.textView12);
        TextView failanswer = findViewById(R.id.textView14);
        TextView averageanswer1 = findViewById(R.id.textView17);
        TextView averageanswer2 = findViewById(R.id.textView19);
        TextView mark = findViewById(R.id.textView18);
        rightanswer.setText(Integer.toString(right));
        failanswer.setText(Integer.toString(fail));
        averageanswer1.setText(Integer.toString(right*5/(fail + right)));
        averageanswer2.setText(Integer.toString((right*500/(fail + right))%100));
        if ((right*500/(fail + right))%100 >= 50){
            mark.setText(Integer.toString(right*5/(fail + right) + 1));
        }else{
            mark.setText(Integer.toString(right*5/(fail + right)));
        }
        Button button = findViewById(R.id.button17);
        button.setOnClickListener((v) -> {
            try {
                Intent intent = new Intent(Itog.this, MainActivity.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });



    }
}