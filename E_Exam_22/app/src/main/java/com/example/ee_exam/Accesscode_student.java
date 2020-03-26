package com.example.ee_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Accesscode_student extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accesscode_student);
 DBHelper dbHelper = new DBHelper(this);
        dbHelper.addLevel(new Level("first level"));
        dbHelper.addLevel(new Level("second level"));
        dbHelper.addLevel(new Level("therd level"));
        dbHelper.addLevel(new Level("forth level"));

        dbHelper.addDepartment(new Department("se3",3));
        dbHelper.addDepartment(new Department("se4",4));
        dbHelper.addDepartment(new Department("it3",3));
        dbHelper.addDepartment(new Department("it4",4));
        dbHelper.addDepartment(new Department("general1",1));
        dbHelper.addDepartment(new Department("general2",7));

        dbHelper.addSubject(new Subject("computer since","ghn_hjkuf",1));
        dbHelper.addResult(new Result(1, "5678gvhhch",99));

        Log.i("main",dbHelper.getAllLevels().toString());
        Log.i("main",dbHelper.getAllDepartments().toString());
        Log.i("main" ,dbHelper.getAllSubjects().toString());
        Log.i("main" ,dbHelper.getAllResult().toString());

        final EditText editTextAccessCode=findViewById(R.id.edit_text_access_code_student);
        Button buttonToExam = findViewById(R.id.to_exam);

        buttonToExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String aceess_code = editTextAccessCode.getText().toString();
                if(aceess_code.equals("ghn_hjkuf")){
                    Intent intent =new Intent(Accesscode_student.this,SecActivity.class);
                    startActivity(intent);

                }
            }
        });



    }
}
