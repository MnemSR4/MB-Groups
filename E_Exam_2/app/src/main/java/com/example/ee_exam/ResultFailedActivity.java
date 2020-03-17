package com.example.ee_exam;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultFailedActivity extends AppCompatActivity {

    public static String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_failed);

        name = getIntent().getStringExtra(SecActivity.NAME);


        TextView textViewName = findViewById(R.id.text_view_namme2);
        TextView textViewWrong = findViewById(R.id.text_view_wrong2);
        TextView textViewcorrect = findViewById(R.id.text_view_correct2);
        TextView textViewResult = findViewById(R.id.text_view_result2);


        textViewName.setText(name.substring(0,name.indexOf('@')));

        StringBuffer sb1 = new StringBuffer();
        sb1.append(Score.wrong + "\n");
        StringBuffer sb2 = new StringBuffer();
        sb2.append(Score.correct + "\n");

        textViewWrong.setText(sb1);
        textViewcorrect.setText(sb2);
        textViewResult.setText(sb2);
/*
        if(Score.correct >= 5)
            textViewFinal.setText("Successful");
        else
            textViewFinal.setText("Failed");

 */


    }
}
