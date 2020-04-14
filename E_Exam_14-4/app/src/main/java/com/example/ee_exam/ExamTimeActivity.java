package com.example.ee_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ExamTimeActivity extends AppCompatActivity {

    private int time =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_time);

        Button buttonIncrease =findViewById(R.id.button_increase);
        Button buttonDecrease =findViewById(R.id.button_decrease);
        final TextView textViewExamTime =findViewById(R.id.text_view_exam_time);
        final EditText editTextAccessCode =findViewById(R.id.edit_text_access_code_time);
        Button buttonOk =findViewById(R.id.button_ok);

        buttonIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time++;
                textViewExamTime.setText(String.valueOf(time));
            }
        });

        buttonDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time--;
                textViewExamTime.setText(String.valueOf(time));
            }
        });
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String accessCode =editTextAccessCode.getText().toString();
                DBHelper helper =new DBHelper(ExamTimeActivity.this);
                helper.updateExamTime(accessCode,time);
            }
        });

    }
}
