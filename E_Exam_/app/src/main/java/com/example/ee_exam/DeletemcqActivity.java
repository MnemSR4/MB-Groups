package com.example.ee_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeletemcqActivity extends AppCompatActivity {

    String access;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_mcq);

        final DBHelper dbHelper = new DBHelper(this);
        Button buttonDelete =findViewById(R.id.delete);
        Button buttonDeleteAllMCQ =findViewById(R.id.delete_all);
        final EditText editTextDelete =findViewById(R.id.edit_text_delete);
        final EditText editTextAccess =findViewById(R.id.edit_text_delete_access_code);
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 access =editTextAccess.getText().toString();
               String id = editTextDelete.getText().toString();
               dbHelper.deleteQues(access, id);
                Toast.makeText(DeletemcqActivity.this, "deleted", Toast.LENGTH_SHORT).show();
            }
        });

        buttonDeleteAllMCQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dbHelper.deleteAllMCQ(access);
                Toast.makeText(DeletemcqActivity.this, "deleted", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
