package com.example.ee_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SelectMCQActivity extends AppCompatActivity {

    private List<Question> questions =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_m_c_q);

        final MCQuestionAdabter adabter =new MCQuestionAdabter(this,0,questions);
        ListView listView =findViewById(R.id.list_view);
        listView.setAdapter(adabter);

        final DBHelper dbHelper =new DBHelper(this);
        Button buttonShow = findViewById(R.id.button_show);
        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questions =dbHelper.getAllQes();
                adabter.clear();
                adabter.addAll(questions);
                Toast.makeText(SelectMCQActivity.this, "select", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
