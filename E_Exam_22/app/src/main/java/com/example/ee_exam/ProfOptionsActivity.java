package com.example.ee_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProfOptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prof_options);

        Button buttondelete = findViewById(R.id.button_deleteq);
        Button buttonShow = findViewById(R.id.button_showq);
        Button buttonEdit = findViewById(R.id.button_editq);
        Button buttonInsertMCQ =findViewById(R.id.button_insertq);
        Button buttonInsertTFQ =findViewById(R.id.button_inserttfq);

        buttonInsertMCQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ProfOptionsActivity.this,EnterQesByProf.class);
                startActivity(intent);
            }
        });

        buttonInsertTFQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ProfOptionsActivity.this,EnterTFQByProf.class);
                startActivity(intent);
            }
        });


        buttondelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ProfOptionsActivity.this,ProfessorActivity.class);
                startActivity(intent);
            }
        });

        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ProfOptionsActivity.this,SelectMCQActivity.class);
                startActivity(intent);
            }
        });

        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ProfOptionsActivity.this,UpdateQesMMCQActivity.class);
                startActivity(intent);
            }
        });
    }
}
