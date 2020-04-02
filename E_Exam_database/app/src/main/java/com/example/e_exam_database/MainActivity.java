package com.example.e_exam_database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        Log.i("main",dbHelper.getAllLevels().toString());
        Log.i("main",dbHelper.getAllDepartments().toString());
    }
}
