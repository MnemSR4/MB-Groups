package com.example.ee_exam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ProfOptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prof_options);
            // delet for question ya basant    ياريت نوضح الشغل
        Button buttondelete = findViewById(R.id.button_deleteq);
        ////
        Button buttonShow = findViewById(R.id.button_showq);
        Button buttonEdit = findViewById(R.id.button_editq);
        Button buttonInsertMCQ =findViewById(R.id.button_insertq);
         // detet for true and flase question
        Button DelettrueandFlase = findViewById(R.id.button_deletetfq);
        Button buttonInsertTFQ =findViewById(R.id.button_inserttfq);
        Button buttonShowTF = findViewById(R.id.button_showtf);
            //  edit or update True false Question
        Button UpdateTrueFlaseQuestion = findViewById(R.id.button_edittfq);
        Button buttonShowStudentResult =findViewById(R.id.button_show_student_result);
        Button buttonExamTime =findViewById(R.id.button_edit_exsm_time);


        buttonInsertMCQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ProfOptionsActivity.this, EnterQesByProf.class);
                startActivity(intent);
            }
        });

        buttonInsertTFQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ProfOptionsActivity.this, EnterTFQByProf.class);
                startActivity(intent);
            }
        });


        buttondelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ProfOptionsActivity.this, DeletemcqActivity.class);
                startActivity(intent);
            }
        });

        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ProfOptionsActivity.this, SelectMCQActivity.class);
                startActivity(intent);
            }
        });

        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ProfOptionsActivity.this, UpdateQesMMCQActivity.class);
                startActivity(intent);
            }
        });

        buttonShowTF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ProfOptionsActivity.this,SelectTrueFalse.class);
                startActivity(intent);
            }
        });


        DelettrueandFlase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ProfOptionsActivity.this, DeletTruefalseQuestion.class);
                startActivity(intent);

            }
        });

        UpdateTrueFlaseQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfOptionsActivity.this,UpdateTrueFalseQuestion.class);
                startActivity(intent);

            }
        });


        buttonShowStudentResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ProfOptionsActivity.this,SelectResultActivity.class);
                startActivity(intent);

            }
        });
        buttonExamTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ProfOptionsActivity.this,ExamTimeActivity.class);
                startActivity(intent);

            }
        });
    }
}
