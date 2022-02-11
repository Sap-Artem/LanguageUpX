package com.example.languageupx002;

import static com.example.languageupx002.Table.fail;
import static com.example.languageupx002.Table.k;
import static com.example.languageupx002.Table.lang;
import static com.example.languageupx002.Table.right;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Itog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itog);
        this.getSupportActionBar().hide();
        TextView rightanswer = findViewById(R.id.textView12);
        TextView failanswer = findViewById(R.id.textView14);
        TextView averageanswer1 = findViewById(R.id.textView17);
        TextView averageanswer2 = findViewById(R.id.textView19);
        TextView tv1 = findViewById(R.id.textView8);
        TextView tv2 = findViewById(R.id.textView11);
        TextView tv3 = findViewById(R.id.textView13);
        TextView tv4 = findViewById(R.id.textView16);
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
        ImageButton button = findViewById(R.id.button17);
        switch (lang){
            case (1):
                tv1.setText("Your mark");
                tv2.setText("Right answer");
                tv3.setText("Fail answer");
                tv4.setText("Average score");
                break;
            case (2):
                tv1.setText("Votre marque");
                tv2.setText("Bonne réponse");
                tv3.setText("Échec de la réponse");
                tv4.setText("Score moyen");
                break;
            case (3):
                tv1.setText("Tu marca");
                tv2.setText("Respuesta correcta");
                tv3.setText("Respuesta fallida");
                tv4.setText("Puntuación media");
                break;
            case (4):
                tv1.setText("Sua marca");
                tv2.setText("Resposta correta");
                tv3.setText("Falha na resposta");
                tv4.setText("Pontuação média");
                break;
            case (5):
                tv1.setText("Il tuo segno");
                tv2.setText("Risposta esatta");
                tv3.setText("Risposta fallita");
                tv4.setText("Punteggio medio");
                break;
            case (6):
                tv1.setText("Dein Zeichen");
                tv2.setText("Richtige Antwort");
                tv3.setText("Antwort fehlschlagen");
                tv4.setText("Durchschnittliche Punktzahl");
                break;
            case (7):
                tv1.setText("Твоя оценка");
                tv2.setText("Правильных ответов");
                tv3.setText("Неправильных ответов");
                tv4.setText("Средний бал");
                break;
            case (8):
                tv1.setText("你的標記");
                tv2.setText("正確答案");
                tv3.setText("失敗回答");
                tv4.setText("平均分");
                break;
            case (9):
                tv1.setText("너의 흔적");
                tv2.setText("정답");
                tv3.setText("실패 답변");
                tv4.setText("평균 점수");
                break;
            case (10):
                tv1.setText("あなたのマーク");
                tv2.setText("正しい答え");
                tv3.setText("答えに失敗する");
                tv4.setText("平均スコア");
                break;
            case (11):
                tv1.setText("आपका निशान");
                tv2.setText("सही जवाब");
                tv3.setText("असफल उत्तर");
                tv4.setText("औसत अंक");
                break;
            case (12):
                tv1.setText("متوسط درجة");
                tv2.setText("الإجابة الصحيحة");
                tv3.setText("إجابة فاشلة");
                tv4.setText("متوسط درجة");
                break;
        }
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