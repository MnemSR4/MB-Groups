package com.example.ee_exam;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SelectResultActivity extends AppCompatActivity {

    private List<Result> results =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_result);

        final ResultAdabter adabter =new ResultAdabter(this,0,results);
        ListView listView =findViewById(R.id.list_view_results);
        listView.setAdapter(adabter);

        DBHelper dbHelper =new DBHelper(this);

                results =dbHelper.getAllResult();
                adabter.clear();
                adabter.addAll(results);
                Toast.makeText(SelectResultActivity.this, "select", Toast.LENGTH_SHORT).show();
            }
}
