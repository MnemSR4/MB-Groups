package com.example.ee_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    public static String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        name =getIntent().getStringExtra(SecActivity.NAME);


        TextView textViewName =findViewById(R.id.text_view_namme);
        TextView textViewWrong =findViewById(R.id.text_view_wrong);
        TextView textViewcorrect =findViewById(R.id.text_view_correct);
        TextView textViewResult =findViewById(R.id.text_view_result);
        TextView textViewFinal =findViewById(R.id.text_view_final);

        textViewName.setText(name);

        StringBuffer sb1 =new StringBuffer();
        sb1.append(Score.wrong + "\n");
        StringBuffer sb2 =new StringBuffer();
        sb2.append(Score.correct +"\n");

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
