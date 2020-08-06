package com.example.ee_exam;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EnterTFQByProf extends AppCompatActivity {
    private String Qes,Answer,access;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_t_f_q_by_prof);

        final DBHelper helper = new DBHelper(this);

        Button buttonSubmit = findViewById(R.id.button_submit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextAccess_code = findViewById(R.id.edit_text_Question);
                access = editTextAccess_code.getText().toString();

                EditText editTextQes = findViewById(R.id.edit_text_Question);
                Qes = editTextQes.getText().toString();

                EditText editTextAnswer = findViewById(R.id.edit_text_answer);
                Answer = editTextAnswer.getText().toString();

                helper.addTFQuestion(new TrueFalseQuestion(access,Qes,Answer));
                Toast.makeText(EnterTFQByProf.this, "TF Qes Added ", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
