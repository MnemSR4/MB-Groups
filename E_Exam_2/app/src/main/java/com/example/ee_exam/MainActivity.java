package com.example.ee_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "EXTRA_NAME";
    DBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText editTextName = findViewById(R.id.edit_text_name);
        Button buttonStart = findViewById(R.id.button_start);
        helper = new DBHelper(MainActivity.this);
        final Animation shake = AnimationUtils.loadAnimation(this, R.anim.animation);
        buttonStart.startAnimation(shake);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = editTextName.getText().toString();
                if (name.equals("")) {

                    Toast.makeText(MainActivity.this, "please,enter your name ", Toast.LENGTH_SHORT).show();

                } else {

                    helper.addStudent(new Student(name));
                    Intent intent = new Intent(MainActivity.this, SecActivity.class);
                    intent.putExtra(EXTRA_NAME, name);
                    startActivity(intent);
                    finish();
                }
            }
        });
/*
        helper.addQuestion(new Question("Which method can be defined only once in a program?" ,
                "finalize method" , "main method" ,"static method" , "private method" ,"main method"));

        helper.addQuestion(new Question("Which of these is not a bitwise operator?" ,
                "&" , "&=" ,"|=" , "<=" ,"<="));

        helper.addQuestion(new Question("Which keyword is used by method to refer to the object that invoked it?" ,
                "import" , "this" ,"catch" , "abstract" ,"this"));

        helper.addQuestion(new Question("Which of these keywords is used to define interfaces in Java?",
                "Interface","interface","intf","Intf","interface"));

        helper.addQuestion(new Question("Which of these access specifiers can be used for an interface?" ,
                "public", "protected", "private", "All of the mentioned" ,"public"));

        helper.addQuestion(new Question("Which of the following is correct way of importing an entire package ‘pkg’?",
                "Import pkg.", "import pkg.*", "Import pkg.*", "import pkg.","import pkg.*"));

        helper.addQuestion(new Question("What is the return type of Constructors?" ,
                "int", "float", "void", "None of the mentioned","None of the mentioned"));

        helper.addQuestion(new Question("Which of the following package stores all the standard java classes?" ,
                "lang", "java", "util", "java.packages" ,"java"));

        helper.addQuestion(new Question("Which of these method of class String is used to compare two String objects for their equality?" ,
                "equals()", "Equals()", "isequal()", "Isequal()" ,"equals()"));

        helper.addQuestion(new Question("An expression involving byte, int, & literal numbers is promoted to which of these?" ,
                "int", "long", "byte", "float" ,"int"));


        helper.addTFQuestion(new TrueFalseQuestion("how are you ?","True"));
        helper.addTFQuestion(new TrueFalseQuestion("we are 9afwet elkolia w elkoliat elmegawra","False"));
        helper.addTFQuestion(new TrueFalseQuestion("we love amer abo hani to the moooon ","True"));

*/
        //  Log.i("sec" , helper.getAllNames().toString());

        // helper.deleteAll();
    }
}
