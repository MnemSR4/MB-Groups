package com.example.ee_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ee_exam.DatabaseRegestration.SqliteHelper;
import com.example.ee_exam.ModelRegistration.Professor;
import com.example.ee_exam.ModelRegistration.Student;
import com.example.ee_exam.ModelRegistration.User;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "EXTRA_NAME";
    //Declaration EditTexts
    EditText editTextEmail;
    EditText editTextPassword;

    //Declaration TextInputLayout
    TextInputLayout textInputLayoutEmail;
    TextInputLayout textInputLayoutPassword;

    //Declaration Button
    Button buttonLogin;

    //Declaration SqliteHelper
    SqliteHelper sqliteHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sqliteHelper = new SqliteHelper(this);
        initCreateAccountTextView();
        initViews();


        DBHelper helper = new DBHelper(this);


        //sub Question
        helper.addQuestion(new Question("sub","Which method can be defined only once in a program?" ,
                "finalize method" , "main method" ,"static method" , "private method" ,"main method"));

        helper.addQuestion(new Question("sub","Which of these is not a bitwise operator?" ,
                "&" , "&=" ,"|=" , "<=" ,"<="));

        helper.addQuestion(new Question("sub","Which keyword is used by method to refer to the object that invoked it?" ,
                "import" , "this" ,"catch" , "abstract" ,"this"));

        helper.addQuestion(new Question("sub","Which of these keywords is used to define interfaces in Java?",
                "Interface","interface","intf","Intf","interface"));

        helper.addQuestion(new Question("sub","Which of these access specifiers can be used for an interface?" ,
                "public", "protected", "private", "All of the mentioned" ,"public"));

        helper.addQuestion(new Question("sub","Which of the following is correct way of importing an entire package ‘pkg’?",
                "Import pkg.", "import pkg.*", "Import pkg.*", "import pkg.","import pkg.*"));

        helper.addQuestion(new Question("sub","What is the return type of Constructors?" ,
                "int", "float", "void", "None of the mentioned","None of the mentioned"));

        helper.addQuestion(new Question("sub","Which of the following package stores all the standard java classes?" ,
                "lang", "java", "util", "java.packages" ,"java"));

        helper.addQuestion(new Question("sub","Which of these method of class String is used to compare two String objects for their equality?" ,
                "equals()", "Equals()", "isequal()", "Isequal()" ,"equals()"));

        helper.addQuestion(new Question("sub","An expression involving byte, int, & literal numbers is promoted to which of these?" ,
                "int", "long", "byte", "float" ,"int"));


        helper.addTFQuestion(new TrueFalseQuestion("sub","the age is just number","True"));
        helper.addTFQuestion(new TrueFalseQuestion("sub","the sun rises from the east","False"));
        helper.addTFQuestion(new TrueFalseQuestion("sub","old is gold ","True"));


        //sub2 Question
        helper.addQuestion(new Question("sub2","Which method can be defined only once in a program?" ,
                "finalize method" , "main method" ,"static method" , "private method" ,"main method"));

        helper.addQuestion(new Question("sub2","Which of these is not a bitwise operator?" ,
                "&" , "&=" ,"|=" , "<=" ,"<="));

        helper.addQuestion(new Question("sub2","Which keyword is used by method to refer to the object that invoked it?" ,
                "import" , "this" ,"catch" , "abstract" ,"this"));

        helper.addQuestion(new Question("sub2","Which of these keywords is used to define interfaces in Java?",
                "Interface","interface","intf","Intf","interface"));

        helper.addQuestion(new Question("sub2","Which of these access specifiers can be used for an interface?" ,
                "public", "protected", "private", "All of the mentioned" ,"public"));

        helper.addQuestion(new Question("sub2","Which of the following is correct way of importing an entire package ‘pkg’?",
                "Import pkg.", "import pkg.*", "Import pkg.*", "import pkg.","import pkg.*"));

        helper.addQuestion(new Question("sub2","What is the return type of Constructors?" ,
                "int", "float", "void", "None of the mentioned","None of the mentioned"));

        helper.addQuestion(new Question("sub2","Which of the following package stores all the standard java classes?" ,
                "lang", "java", "util", "java.packages" ,"java"));

        helper.addQuestion(new Question("sub2","Which of these method of class String is used to compare two String objects for their equality?" ,
                "equals()", "Equals()", "isequal()", "Isequal()" ,"equals()"));

        helper.addQuestion(new Question("sub2","An expression involving byte, int, & literal numbers is promoted to which of these?" ,
                "int", "long", "byte", "float" ,"int"));

        helper.addQuestion(new Question("sub2","what is your name ?" ,
                "ahmed", "mohammed", "tamer", "all false" ,"all false"));

        helper.addQuestion(new Question("sub2","como esta ?" ,
                "bien", "no estoy bien", "no te concierne", "esta enfermo" ,"bien"));


        helper.addTFQuestion(new TrueFalseQuestion("sub2","the sun rises from the east ?","True"));
        helper.addTFQuestion(new TrueFalseQuestion("sub2","old is gold","true"));
        helper.addTFQuestion(new TrueFalseQuestion("sub2","the age is just number ","True"));



        //set click event of login button
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Check user input is correct or not
                if (validate()) {

                    //Get values from EditText fields
                    String email = editTextEmail.getText().toString();
                    String password = editTextPassword.getText().toString();

                    //Authenticate user
                    User currentAdmin = sqliteHelper.Authenticate(new User(null, null, email, password));
                    Student currentStudent = sqliteHelper.SELCTED(new Student(null, null, email ,password ,null,null));
                    Professor currentProf =sqliteHelper.profAuthenticate(new Professor(null,null,email,null,password));

                    //Check Authentication is successful or not
                    if (currentAdmin != null) {

                        Snackbar.make(buttonLogin, "Successfully Logged in!", Snackbar.LENGTH_LONG).show();
                        Intent intent = new Intent(LoginActivity.this,AdminPrivileges.class);
                        intent.putExtra(EXTRA_NAME, email);
                        startActivity(intent);


                        //User Logged in Successfully Launch You home screen activity
                       /* Intent intent=new Intent(LoginActivity.this,HomeScreenActivity.class);
                        startActivity(intent);
                        finish();*/
                    }else if(currentStudent != null){
                        Snackbar.make(buttonLogin, "Successfully Logged in!", Snackbar.LENGTH_LONG).show();
                        Intent intent = new Intent(LoginActivity.this,Accesscode_student.class);
                        intent.putExtra(EXTRA_NAME, email);
                        startActivity(intent);

                    }else if(currentProf != null){
                        Snackbar.make(buttonLogin, "Successfully Logged in!", Snackbar.LENGTH_LONG).show();
                        Intent intent = new Intent(LoginActivity.this,ProfOptionsActivity.class);
                        intent.putExtra(EXTRA_NAME, email);
                        startActivity(intent);
                    }
                    else {

                        //User Logged in Failed
                        Snackbar.make(buttonLogin, "Failed to log in , please try again", Snackbar.LENGTH_LONG).show();

                    }
                }
            }
        });


    }



    //this method used to set Create account TextView text and click event( maltipal colors
    // for TextView yet not supported in Xml so i have done it programmatically)
    private void initCreateAccountTextView() {
        TextView textViewCreateAccount = (TextView) findViewById(R.id.textViewCreateAccount);
        textViewCreateAccount.setText(fromHtml("<font color='#ffffff'>I don't have account yet. </font><font color='#0c0099'>Create New Account</font>"));
        textViewCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterOptionActivity.class);
                startActivity(intent);
            }
        });
    }
    //this method is used to connect XML views to its Objects
    private void initViews() {
        editTextEmail =  findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        textInputLayoutEmail =  findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword =  findViewById(R.id.textInputLayoutPassword);
        buttonLogin =  findViewById(R.id.buttonLogin);

    }



    //This method is for handling fromHtml method deprecation
    @SuppressWarnings("deprecation")
    public static Spanned fromHtml(String html) {
        Spanned result;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            result = Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY);
        } else {
            result = Html.fromHtml(html);
        }
        return result;
    }
    //This method is used to validate input given by user
    public boolean validate() {
        boolean valid = false;

        //Get values from EditText fields
        String Email = editTextEmail.getText().toString();
        String Password = editTextPassword.getText().toString();

        //Handling validation for Email field
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            valid = false;
            textInputLayoutEmail.setError("Please enter valid email!");
        } else {
            valid = true;
            textInputLayoutEmail.setError(null);
        }

        //Handling validation for Password field
        if (Password.isEmpty()) {
            valid = false;
            textInputLayoutPassword.setError("Please enter valid password!");
        } else {
            if (Password.length() > 5) {
                valid = true;
                textInputLayoutPassword.setError(null);
            } else {
                valid = false;
                textInputLayoutPassword.setError("Password is to short!");
            }
        }

        return valid;
    }


}
