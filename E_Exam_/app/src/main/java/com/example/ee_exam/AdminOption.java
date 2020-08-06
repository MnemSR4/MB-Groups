package com.example.ee_exam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AdminOption extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_option);

        Button buttonAddLevelsDepartments = findViewById(R.id.button_add_level_dept);
        buttonAddLevelsDepartments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminOption.this, AddLevelDept.class);
                startActivity(intent);
            }
        });

        Button buttonEditLevelsDepartments = findViewById(R.id.button_edit_level_dept);
        buttonEditLevelsDepartments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminOption.this,EditLevelDept.class);
                startActivity(intent);
            }
        });
        Button buttonSelectProf = findViewById(R.id.button_show_prof);
        buttonSelectProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminOption.this,SelectProfessor.class);
                startActivity(intent);
            }
        });

        Button buttonDeleteProf = findViewById(R.id.button_delete_prof);
        buttonDeleteProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminOption.this,DeletProfessor.class);
                startActivity(intent);
            }
        });

        Button buttonAddSub = findViewById(R.id.button_add_sub);
        buttonAddSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminOption.this,AddSubject.class);
                startActivity(intent);
            }
        });

        Button buttonEditSub = findViewById(R.id.button_edit_sub);
        buttonEditSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminOption.this,UpdateSubject.class);
                startActivity(intent);
            }
        });
        Button buttonControlProf = findViewById(R.id.button_edit_sub);
        buttonControlProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminOption.this,ProfOptionsActivity.class);
                startActivity(intent);
            }
        });
    }
}
