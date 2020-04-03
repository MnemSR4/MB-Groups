package com.example.ptofessor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ThemedSpinnerAdapter;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EnterQesByProf extends AppCompatActivity {

    private String Qes,option1,option2,option3,option4,Answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_qes_by_prof);

        final DBHelper helper = new DBHelper(this);




        Button buttonSubmit = findViewById(R.id.button_submit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextQes = findViewById(R.id.edit_text_Question);
                Qes = editTextQes.getText().toString();

                EditText editTextOption1 = findViewById(R.id.edit_text_first_option);
                option1 = editTextOption1.getText().toString();

                EditText editTextOption2 = findViewById(R.id.edit_text_second_option);
                option2 = editTextOption2.getText().toString();

                EditText editTextOption3 = findViewById(R.id.edit_text_third_option);
                option3 = editTextOption3.getText().toString();

                EditText editTextOption4 = findViewById(R.id.edit_text_fourth_option);
                option4 = editTextOption4.getText().toString();

                EditText editTextAnswer = findViewById(R.id.edit_text_answer);
                Answer = editTextAnswer.getText().toString();

                helper.addQuestion(new Question(Qes,option1,option2,option3,option4,Answer));
                Toast.makeText(EnterQesByProf.this, "added", Toast.LENGTH_SHORT).show();

            }
        });

        Log.i("DBHelper",helper.getAllQes().toString() );

    }
}
