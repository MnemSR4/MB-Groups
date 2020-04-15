package com.example.ee_exam;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ee_exam.DatabaseRegestration.SqliteHelper;
import com.example.ee_exam.ModelRegistration.Professor;

import java.util.ArrayList;
import java.util.List;

public class SelectProfessor extends AppCompatActivity {
    private List <Professor> professors =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_professor);




        final ProfessorAdpter adabter =new ProfessorAdpter(this,0,professors);
        ListView listView =findViewById(R.id.list_view);
        listView.setAdapter(adabter);

        final SqliteHelper dbHelper =new SqliteHelper(this);
       // Button buttonShow = findViewById(R.id.button_show);

                professors =dbHelper.getAllProfesors();
                adabter.clear();
                adabter.addAll(professors);
                Toast.makeText(SelectProfessor.this, "select", Toast.LENGTH_SHORT).show();

    }
}
