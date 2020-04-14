package com.example.ee_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateQesMMCQActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_qes_m_m_c_q);

        final DBHelper dbHelper=new DBHelper(this);


        final EditText editTextId =findViewById(R.id.edit_text_id_ques);
        final EditText editTextAccess =findViewById(R.id.edit_text_acces_code_sub);
        final EditText editTextQuestion =findViewById(R.id.edit_text_ques);
        final EditText editTextOption1 =findViewById(R.id.edit_text_op1);
        final EditText editTextOption2 =findViewById(R.id.edit_text_op2);
        final EditText editTextOption3 =findViewById(R.id.edit_text_op3);
        final EditText editTextOption4 =findViewById(R.id.edit_text_op4);
        final EditText editTextAnswer =findViewById(R.id.edit_text_answ);
        Button buttonEdit =findViewById(R.id.edit_text_edit);
        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = editTextId.getText().toString();
                String access = editTextAccess.getText().toString();
                String question =editTextQuestion.getText().toString();
                String option1 =editTextOption1.getText().toString();
                String option2 =editTextOption2.getText().toString();
                String option3 =editTextOption3.getText().toString();
                String option4 =editTextOption4.getText().toString();
                String answar =editTextAnswer.getText().toString();
                dbHelper.updateQuestion(access,id,question,option1,option2,option3,option4,answar);
                Toast.makeText(UpdateQesMMCQActivity.this, "updated", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
