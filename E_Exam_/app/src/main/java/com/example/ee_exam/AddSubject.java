package com.example.ee_exam;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddSubject extends AppCompatActivity {


    private int time =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_subject);

        final DBHelper helper = new DBHelper(this);


        final EditText editTextIdDepatrment =findViewById(R.id.edit_text_id);
        final EditText editTextSubjectName =findViewById(R.id.edit_text_name);
        final EditText editTextAcesscode =findViewById(R.id.edit_text_acces_code);
        final TextView textViewExamTime =findViewById(R.id.text_view_exam_time_add);
        Button buttonIncrease =findViewById(R.id.button_increase_add);
        Button buttonDecrease =findViewById(R.id.button_decrease_add);

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

        Button buttonAddSubject = findViewById(R.id.edit_text_add_subject);
        buttonAddSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id_depatrment = editTextIdDepatrment.getText().toString();
                String SubjectName =editTextSubjectName.getText().toString();
                String Acesscode =editTextAcesscode.getText().toString();


                helper.addSubject(new Subject(id_depatrment,SubjectName,Acesscode,time));
                Toast.makeText(AddSubject.this, "subject add ...", Toast.LENGTH_LONG).show();

            }
        });

    }
}
