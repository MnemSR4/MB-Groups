package com.example.ee_exam;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateSubject extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_subject);

        final DBHelper dbHelper=new DBHelper(this);


        final EditText editTextIdDeptrment =findViewById(R.id.edit_text_id);
        final EditText editTextSubjectName =findViewById(R.id.edit_text_name);
        final EditText editTextAcesscode =findViewById(R.id.edit_text_acces_code);
        final EditText editTextExamTime =findViewById(R.id.edit_text_exame_time);

        Button buttonEdit =findViewById(R.id.edit_text_edit);
        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id_Department = editTextIdDeptrment.getText().toString();
                String SubjectName =editTextSubjectName.getText().toString();
                String Acesscode =editTextAcesscode.getText().toString();
                String time =editTextExamTime.getText().toString();

                dbHelper.updateSubject(id_Department,SubjectName,Acesscode,time);
                Toast.makeText(UpdateSubject.this, "updated", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
