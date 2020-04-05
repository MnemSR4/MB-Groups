package com.example.ee_exam;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ee_exam.Database.SqliteHelper;
import com.example.ee_exam.Database.SqliteHelper;
import com.example.ee_exam.Model.Student;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

public class StudentRegisterActivity extends AppCompatActivity {
//Declaration Edit
    // Texts

    EditText editTextUserName;
    EditText editTextEmail;
    EditText editTextPassword;

    private String value;
    private String value2;

    //Declaration TextInputLayout

    TextInputLayout textInputLayoutUserName;
    TextInputLayout textInputLayoutEmail;
    TextInputLayout textInputLayoutPassword;

    //Declaration Button
    Button buttonRegister;


    RadioGroup radioGroupLvel ;

    RadioButton rblev1 ;
    RadioButton rblv2 ;
    RadioButton  rblv3 ;
    RadioButton  rblv4 ;



    RadioGroup radioGroupdepart ;

    RadioButton rbgeneral ;
    RadioButton rbSE ;
    RadioButton  rbIT ;
    RadioButton  rbCS ;
    RadioButton  rbIS ;



    //Declaration SqliteHelper
    SqliteHelper sqliteHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_register);
        sqliteHelper = new SqliteHelper(this);
        initViews();
        initTextViewLogin();

        rblev1 =findViewById(R.id.levelid);
        rblv2 =findViewById(R.id.levelid2);
        rblv3 =findViewById(R.id.levelid3);
        rblv4 =findViewById(R.id.levelid4);

        rbgeneral =findViewById(R.id.generlID);
        rbSE =findViewById(R.id.SEID);
        rbIS =findViewById(R.id.ISID);
        rbIT =findViewById(R.id.ITID);
        rbCS =findViewById(R.id.CSID);

        radioGroupLvel.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){

                    case R.id.levelid:
                        value = rblev1.getText().toString();
                        break;
                    case R.id.levelid2:
                        value = rblv2.getText().toString();
                        break;
                    case R.id.levelid3:
                        value = rblv3.getText().toString();
                        break;
                    case R.id.levelid4:
                        value = rblv4.getText().toString();
                        break;
                }
            }
        });

        radioGroupdepart.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){

                    case R.id.SEID:
                        value2 = rbSE.getText().toString();
                        break;
                    case R.id.ITID:
                        value2 = rbIT.getText().toString();
                        break;
                    case R.id.ISID:
                        value2 = rbIS.getText().toString();
                        break;
                    case R.id.CSID:
                        value2 = rbCS.getText().toString();
                        break;
                }
            }
        });


        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {
                    String UserName = editTextUserName.getText().toString();
                    String Email = editTextEmail.getText().toString();
                    String Password = editTextPassword.getText().toString();
                    boolean level_1 = rblev1.isChecked();
                    boolean level_2 = rblv2.isChecked();
                    boolean level_3 = rblv3.isChecked();
                    boolean level_4 = rblv4.isChecked();
                    boolean Genral = rbgeneral.isChecked();
                    boolean SE = rbSE.isChecked();
                    boolean IT = rbIT.isChecked();
                    boolean CS=rbCS.isChecked();
                    boolean IS =    rbIS.isChecked();


                    //Check in the database is there any user associated with  this email
                    if (!sqliteHelper.isStudEmailExists(Email)) {

                        //Email does not exist now add new user to database
                        sqliteHelper.addStudent(new Student(null, UserName, Email, Password,value,value));
                        Snackbar.make(buttonRegister, "User created successfully! Please Login ", Snackbar.LENGTH_LONG).show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                finish();
                            }
                        }, Snackbar.LENGTH_LONG);
                    }else {

                        //Email exists with email input provided so show error user already exist
                        Snackbar.make(buttonRegister, "User already exists with same email ", Snackbar.LENGTH_LONG).show();
                    }


                }
            }
        });

    }




    //this method used to set Login TextView click event
    private void initTextViewLogin() {
        TextView textViewLogin = (TextView) findViewById(R.id.textViewLogin);
        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    //this method is used to connect XML views to its Objects
    private void initViews() {
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextUserName = findViewById(R.id.editTextUserName);
        textInputLayoutEmail = findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword = findViewById(R.id.textInputLayoutPassword);
        textInputLayoutUserName = findViewById(R.id.textInputLayoutUserName);
        buttonRegister = findViewById(R.id.buttonRegister);

        radioGroupLvel = findViewById(R.id.RadioGroupid1);

        radioGroupdepart = findViewById(R.id.RadioGroupid);


    }

    //This method is used to validate input given by user
    public boolean validate() {
        boolean valid = false;

        //Get values from EditText fields
        String UserName = editTextUserName.getText().toString();
        String Email = editTextEmail.getText().toString();
        String Password = editTextPassword.getText().toString();

        //Handling validation for UserName field
        if (UserName.isEmpty()) {
            valid = false;
            textInputLayoutUserName.setError("Please enter valid username!");
        } else {
            if (UserName.length() > 5) {
                valid = true;
                textInputLayoutUserName.setError(null);
            } else {
                valid = false;
                textInputLayoutUserName.setError("Username is to short!");
            }
        }

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




