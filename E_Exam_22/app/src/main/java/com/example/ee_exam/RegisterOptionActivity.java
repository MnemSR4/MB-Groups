package com.example.ee_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegisterOptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_option);

        Button buttonStudent =findViewById(R.id.button_student);
        Button buttonProf =findViewById(R.id.button_professor);
        Button buttonAdmin =findViewById(R.id.button_admin);

        buttonStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(RegisterOptionActivity.this,StudentRegisterActivity.class);
                startActivity(intent);
            }
        });

        buttonProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(RegisterOptionActivity.this,ProfessorRegisterActivity.class);
                startActivity(intent);
            }
        });


        buttonAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(RegisterOptionActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
