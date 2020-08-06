package com.example.ee_exam;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SelectResultActivity extends AppCompatActivity {

    private List<Result> results =new ArrayList<>();
    private List<Result> resultList =new ArrayList<>();
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_result);


        Button buttonShowAllResults = findViewById(R.id.button_show_results);
        final EditText editTextSearch1 = findViewById(R.id.edit_text_student_id);

        final ResultAdabter adabter = new ResultAdabter(this, 0, results);
        ListView listView = findViewById(R.id.list_view_results);
        listView.setAdapter(adabter);

        dbHelper = new DBHelper(this);

        buttonShowAllResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String access = editTextSearch1.getText().toString();
                resultList= dbHelper.getAllResult(access);
                adabter.clear();
                adabter.addAll(resultList);
                Toast.makeText(SelectResultActivity.this, "select", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
