package com.example.ee_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminOption extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_option);

        Button buttonAddLevelsDepartments = findViewById(R.id.button_add_level_dept);
        buttonAddLevelsDepartments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminOption.this,AddLevelDept.class);
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
    }
}
