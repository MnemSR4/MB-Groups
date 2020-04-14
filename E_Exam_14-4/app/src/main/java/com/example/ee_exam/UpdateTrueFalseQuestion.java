package com.example.ee_exam;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateTrueFalseQuestion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_true_false_question);

        final DBHelper dbHelper=new DBHelper(this);


        final EditText editTextId =findViewById(R.id.edit_text_id);
        final EditText editTextaccess =findViewById(R.id.edit_text_access);
        final EditText editTextQuestion =findViewById(R.id.edit_text_ques);
        final EditText editTextAnswer =findViewById(R.id.edit_text_answ);
        Button buttonEdit =findViewById(R.id.edit_text_edit);
        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = editTextId.getText().toString();
                String question =editTextQuestion.getText().toString();
                String access =editTextaccess.getText().toString();
                String answar =editTextAnswer.getText().toString();
                dbHelper.updateTrueandfalseQuestion(access,id,question,answar);
                Toast.makeText(UpdateTrueFalseQuestion.this, "updated", Toast.LENGTH_SHORT).show();
            }
        });




    }
}
