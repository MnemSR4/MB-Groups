package com.example.ee_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditLevelDept extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_level_dept);


        final DBHelper helper = new DBHelper(this);

        final EditText editTextEditLevel = findViewById(R.id.edit_text_edit_level);
        final EditText editTextLevelId = findViewById(R.id.edit_text_level_id);
        Button buttonEditLevel = findViewById(R.id.button_edit_level);
        buttonEditLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editLevel = editTextEditLevel.getText().toString();
                String levelId = editTextLevelId.getText().toString();
                helper.updateLevel(levelId ,editLevel);
                Toast.makeText(EditLevelDept.this, "level updated ...", Toast.LENGTH_LONG).show();
            }
        });

        final EditText editTextEditDept = findViewById(R.id.edit_text_edit_department);
        final EditText editTextDeptId = findViewById(R.id.edit_text_dept_id);
        Button buttonEditDept = findViewById(R.id.button_edit_dept);
        buttonEditDept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editDept = editTextEditDept.getText().toString();
                String deptId = editTextDeptId.getText().toString();
                helper.updateDepartment(deptId , editDept);
                Toast.makeText(EditLevelDept.this, "Department updated ...", Toast.LENGTH_LONG).show();
            }
        });

    }
}
