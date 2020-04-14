package com.example.ee_exam;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DeletTruefalseQuestion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delet_truefalse_question);



        final DBHelper dbHelper = new DBHelper(this);
        Button buttonDelete =findViewById(R.id.delete);
        Button buttonDeleteAllMCQ =findViewById(R.id.button_delete_all);
        final EditText editTextDelete =findViewById(R.id.edit_text_delete);
        final EditText editTextAccess =findViewById(R.id.edit_text_delete_access);
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = editTextDelete.getText().toString();
                String access = editTextAccess.getText().toString();
                dbHelper.deleteTureFalseQuestion(access,id);
                Toast.makeText(DeletTruefalseQuestion.this, "deleted", Toast.LENGTH_SHORT).show();
            }
        });

        buttonDeleteAllMCQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = editTextDelete.getText().toString();
                dbHelper.deleteAllMCQ();
                Toast.makeText(DeletTruefalseQuestion.this, "deleted", Toast.LENGTH_SHORT).show();
            }
        });



    }
}
