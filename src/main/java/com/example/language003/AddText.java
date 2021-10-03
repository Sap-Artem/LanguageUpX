package com.example.language003;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class AddText extends AppCompatActivity {

    DBhelper dBhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plus);
        final Button quitButton = (Button)findViewById(R.id.button9);
        final Button addwordButton = (Button)findViewById(R.id.button8);
        EditText editword = findViewById(R.id.editWord);
        EditText edittranslate = findViewById(R.id.editTranslate);
        TextView textword = findViewById(R.id.textView3);
        TextView texttranslate = findViewById(R.id.textView4);
        quitButton.setOnClickListener((v) -> {
            try{
                Intent intent = new Intent(AddText.this, MainActivity.class);startActivity(intent);finish();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        addwordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String word = editword.getText().toString();
                String translate = edittranslate.getText().toString();
                textword.setText(word);
                texttranslate.setText(translate);
            }
        });

    }
}