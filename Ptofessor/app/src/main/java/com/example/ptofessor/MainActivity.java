package com.example.ptofessor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String accessCodeMCQ = "123";
    public static final String accessCodeTF = "000";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText editTextAccessCode =findViewById(R.id.edit_text_access_code);

        Button buttonSubmit = findViewById(R.id.button_submit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String accessCode = editTextAccessCode.getText().toString();
                if (accessCode.equals(accessCodeMCQ) ){

                    Intent intent = new Intent(MainActivity.this , EnterQesByProf.class);
                    startActivity(intent);

                }else if (accessCode.equals(accessCodeTF)){

                    Intent intent = new Intent(MainActivity.this , EnterTFQByProf.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this, "please, Enter the code", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
