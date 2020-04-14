package com.example.ee_exam;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddLevelDept extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_level_dept);

        final DBHelper helper = new DBHelper(this);


        final EditText editTextAddLevel = findViewById(R.id.edit_text_add_level);
        Button buttonAddLevel = findViewById(R.id.button_add_level);
        buttonAddLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String addLevel = editTextAddLevel.getText().toString();
                helper.addLevel(new Level(addLevel));
                Toast.makeText(AddLevelDept.this, "level added ...", Toast.LENGTH_LONG).show();

            }
        });

        final EditText editTextAddDept = findViewById(R.id.edit_text_add_department);
        Button buttonAddDepartment = findViewById(R.id.button_add_dept);
        buttonAddDepartment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String addDept = editTextAddDept.getText().toString();
                helper.addDepartment(new Department(addDept,3));
                helper.addDepartment(new Department(addDept,4));
                Toast.makeText(AddLevelDept.this, "department added ...", Toast.LENGTH_LONG).show();
            }
        });
    }
}
