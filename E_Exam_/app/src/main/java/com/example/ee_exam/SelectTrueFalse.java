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

public class SelectTrueFalse extends AppCompatActivity {
    private List<TrueFalseQuestion> trueFalseQuestions= new ArrayList<>();
    private List<TrueFalseQuestion> trueFalseQuestionList= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_true_false);
        final TrueFalseAdapter adapter = new TrueFalseAdapter(this,0,trueFalseQuestions);
        ListView listViewTF = findViewById(R.id.list_view_t_F_q);
        listViewTF.setAdapter(adapter);

        final DBHelper helper = new DBHelper(this);
      //  Button buttonShowTFQ = findViewById(R.id.button_show_t_f_q);
        Button buttonSearchTFQ = findViewById(R.id.button_search_tfq);
        final EditText editTextSearch =findViewById(R.id.edit_text_tfq_id);
/*
        buttonShowTFQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trueFalseQuestions = helper.getAllTFQes();
                adapter.clear();
                adapter.addAll(trueFalseQuestions);
                Toast.makeText(SelectTrueFalse.this, "select", Toast.LENGTH_SHORT).show();

            }
        });

 */

        buttonSearchTFQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String access =editTextSearch.getText().toString();
                trueFalseQuestionList = helper.getAllTFQes(access);
                adapter.clear();
                adapter.addAll(trueFalseQuestionList);
                Toast.makeText(SelectTrueFalse.this, "select", Toast.LENGTH_SHORT).show();

            }
        });






    }
}
