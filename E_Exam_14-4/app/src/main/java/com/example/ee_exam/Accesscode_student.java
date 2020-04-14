package com.example.ee_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ee_exam.Database.SqliteHelper;

public class Accesscode_student extends AppCompatActivity {

    String name,name2;
    public static final String Extra_NAME = "NAME";
    public static final String Extra_NAME2 = "NAME";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accesscode_student);

        name=getIntent().getStringExtra(LoginActivity.EXTRA_NAME);
        name2=getIntent().getStringExtra(LoginActivity.EXTRA_NAME);

 DBHelper dbHelper = new DBHelper(this);
        SqliteHelper helper =new SqliteHelper(this);
        dbHelper.addLevel(new Level("first level"));
        dbHelper.addLevel(new Level("second level"));
        dbHelper.addLevel(new Level("therd level"));
        dbHelper.addLevel(new Level("forth level"));

        dbHelper.addDepartment(new Department("se3",3));
        dbHelper.addDepartment(new Department("se4",4));
        dbHelper.addDepartment(new Department("it3",3));
        dbHelper.addDepartment(new Department("it4",4));
        dbHelper.addDepartment(new Department("general1",1));
        dbHelper.addDepartment(new Department("general2",7));

      dbHelper.addSubject(new Subject("computer since","sub","1",7200));
        dbHelper.addSubject(new Subject("computer since","sub2","1",7200));
       // dbHelper.addResult(new Result(1, "5678gvhhch",99));

        Log.i("main",dbHelper.getAllLevels().toString());
        Log.i("main",dbHelper.getAllDepartments().toString());
        Log.i("main" ,dbHelper.getAllSubjects().toString());
        Log.i("main" ,dbHelper.getAllResult().toString());
        Log.i("main" ,helper.getAllStudents().toString());

        dbHelper.addQuestion(new Question("sub","Which method can be defined only once in a program?" ,
                "finalize method" , "main method" ,"static method" , "private method" ,"main method"));

        dbHelper.addQuestion(new Question("sub","Which of these is not a bitwise operator?" ,
                "&" , "&=" ,"|=" , "<=" ,"<="));

        dbHelper.addQuestion(new Question("sub","Which keyword is used by method to refer to the object that invoked it?" ,
                "import" , "this" ,"catch" , "abstract" ,"this"));

        dbHelper.addQuestion(new Question("sub","Which of these keywords is used to define interfaces in Java?",
                "Interface","interface","intf","Intf","interface"));

        dbHelper.addQuestion(new Question("sub","Which of these access specifiers can be used for an interface?" ,
                "public", "protected", "private", "All of the mentioned" ,"public"));

        dbHelper.addQuestion(new Question("sub","Which of the following is correct way of importing an entire package ‘pkg’?",
                "Import pkg.", "import pkg.*", "Import pkg.*", "import pkg.","import pkg.*"));

        dbHelper.addQuestion(new Question("sub","What is the return type of Constructors?" ,
                "int", "float", "void", "None of the mentioned","None of the mentioned"));

        dbHelper.addQuestion(new Question("sub","Which of the following package stores all the standard java classes?" ,
                "lang", "java", "util", "java.packages" ,"java"));

        dbHelper.addQuestion(new Question("sub","Which of these method of class String is used to compare two String objects for their equality?" ,
                "equals()", "Equals()", "isequal()", "Isequal()" ,"equals()"));

        dbHelper.addQuestion(new Question("sub","An expression involving byte, int, & literal numbers is promoted to which of these?" ,
                "int", "long", "byte", "float" ,"int"));


        dbHelper.addTFQuestion(new TrueFalseQuestion("sub","how are you ?","True"));
        dbHelper.addTFQuestion(new TrueFalseQuestion("sub","we are 9afwet elkolia w elkoliat elmegawra","False"));
        dbHelper.addTFQuestion(new TrueFalseQuestion("sub","we love amer abo hani to the moooon ","True"));



        final EditText editTextAccessCode=findViewById(R.id.edit_text_access_code_student);
        Button buttonToExam = findViewById(R.id.to_exam);

        buttonToExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String aceess_code = editTextAccessCode.getText().toString();
                if(aceess_code.equals("sub")){
                    Intent intent =new Intent(Accesscode_student.this,SecActivity.class);
                    intent.putExtra(Extra_NAME,name);
                    startActivity(intent);

                }else if(aceess_code.equals("sub2")) {
                    Intent intent = new Intent(Accesscode_student.this, SecSubject2Activity.class);
                    intent.putExtra(Extra_NAME2,name2);
                    startActivity(intent);

                }else if(aceess_code.equals("prof")){
                    Intent intent =new Intent(Accesscode_student.this,ProfOptionsActivity.class);
                    startActivity(intent);

                }else if(aceess_code.equals("admin")){
                    Intent intent =new Intent(Accesscode_student.this,AdminOption.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(Accesscode_student.this, "false    ", Toast.LENGTH_SHORT).show();
            }
        });



    }
}
