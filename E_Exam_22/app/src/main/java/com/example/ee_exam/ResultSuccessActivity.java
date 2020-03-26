package com.example.ee_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultSuccessActivity extends AppCompatActivity {

    public static String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_success);

      //  name = getIntent().getStringExtra(SecActivity.NAME);


        TextView textViewName = findViewById(R.id.text_view_namme);
        TextView textViewWrong = findViewById(R.id.text_view_wrong);
        TextView textViewcorrect = findViewById(R.id.text_view_correct);
        TextView textViewResult = findViewById(R.id.text_view_result);
        TextView textViewFinal = findViewById(R.id.text_view_final);

      //  textViewName.setText(name.substring(0,name.indexOf('@')));

        StringBuffer sb1 = new StringBuffer();
        sb1.append(Score.wrong + "\n");
        StringBuffer sb2 = new StringBuffer();
        sb2.append(Score.correct + "\n");

        textViewWrong.setText(sb1);
        textViewcorrect.setText(sb2);
        textViewResult.setText(sb2);
    }
}
