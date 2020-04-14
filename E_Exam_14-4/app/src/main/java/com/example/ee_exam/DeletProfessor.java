package com.example.ee_exam;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ee_exam.Database.SqliteHelper;

public class DeletProfessor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delet_professor);


        final SqliteHelper dbHelper = new SqliteHelper(this);
        Button buttonDelete =findViewById(R.id.delete);
        Button buttonDeleteAll =findViewById(R.id.delete_all_prof);

        final EditText editTextDelete =findViewById(R.id.edit_text_delete);
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = editTextDelete.getText().toString();
                dbHelper.deletePOF(id);
                Toast.makeText(DeletProfessor.this, "deleted", Toast.LENGTH_SHORT).show();
            }
        });

        buttonDeleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.deleteAllProf();
                Toast.makeText(DeletProfessor.this, "deleted", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
