package com.example.ee_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AdminPrivileges extends AppCompatActivity {

    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_privileges);

        name =getIntent().getStringExtra(LoginActivity.EXTRA_NAME);
        TextView textViewName = findViewById(R.id.text_view_name);
        textViewName.setText(name.substring(0,name.indexOf('@')));

        Button buttonProf = findViewById(R.id.button_professor_privileges);
        buttonProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminPrivileges.this , ProfOptionsActivity.class);
                startActivity(intent);
            }
        });

        Button buttonAdmin = findViewById(R.id.button_admin_option);
        buttonAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminPrivileges.this , AdminOption.class);
                startActivity(intent);
            }
        });
    }
}
