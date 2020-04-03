package com.example.ee_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ProfessorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor);

        final DBHelper dbHelper = new DBHelper(this);
        Button buttonDelete =findViewById(R.id.delete);
        final EditText editTextDelete =findViewById(R.id.edit_text_delete);
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String id = editTextDelete.getText().toString();
               dbHelper.deleteQues(id);
                Toast.makeText(ProfessorActivity.this, "deleted", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
