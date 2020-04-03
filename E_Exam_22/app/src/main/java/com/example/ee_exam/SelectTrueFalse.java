package com.example.ee_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SelectTrueFalse extends AppCompatActivity {
    private List<TrueFalseQuestion> trueFalseQuestions= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_true_false);
        final TrueFalseAdapter adapter = new TrueFalseAdapter(this,0,trueFalseQuestions);
        ListView listViewTF = findViewById(R.id.list_view_t_F_q);
        listViewTF.setAdapter(adapter);

        final DBHelper helper = new DBHelper(this);
        Button buttonShow = findViewById(R.id.button_show_t_f_q);
        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trueFalseQuestions = helper.getAllTFQes();
                adapter.addAll(trueFalseQuestions);
                Toast.makeText(SelectTrueFalse.this, "select", Toast.LENGTH_SHORT).show();

            }
        });



    }
}
