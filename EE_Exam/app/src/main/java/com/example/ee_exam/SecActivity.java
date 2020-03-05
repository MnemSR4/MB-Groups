package com.example.ee_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SecActivity extends AppCompatActivity implements OnFragmentInteractionListener{

    public int counter = 30;
    public static List<String> questionlist;
    public static ArrayList<String> options_1;
    public static ArrayList<String> options_2;
    public static ArrayList<String> options_3;
    public static ArrayList<String> options_4;
    public static List<String> answers;
    String name;
    public static final String NAME="NAME";
    Intent intent2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);

        DBHelper helper =new DBHelper(this);
       // questionlist = helper.getAllQes();
        questionlist = helper.getAllQestions();
        options_1 = helper.getOption_1();
        options_2 = helper.getOption_2();
        options_3 = helper.getOption_3();
        options_4 = helper.getOption_4();
        answers = helper.getAllAnswers();


        final TextView textViewTime = findViewById(R.id.edit_text_time);

        new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                textViewTime.setText(String.valueOf(counter));
                counter--;
            }

            public void onFinish() {
                textViewTime.setText("FINISH!!");
                 intent2 =new Intent(SecActivity.this,ResultActivity.class);
                intent2.putExtra(NAME,name);
                startActivity(intent2);
            }
        }.start();

        name =getIntent().getStringExtra(MainActivity.EXTRA_NAME);
        TextView textViewName =findViewById(R.id.text_view_name);
        textViewName.setText("Welcome, "+ name);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,QesFragment.newInstance()).commit();
    }

    @Override
    public void onFragmentInteraction(String value) {

        if(value == null)
        {
            Toast.makeText(this, "Please select one choice", Toast.LENGTH_SHORT).show();

            return;
        }

        else if(value.equalsIgnoreCase(answers.get(Score.flag))){
            Score.correct++;
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
        }else {
            Score.wrong++;
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
        }

        Score.flag++;
        if(Score.flag < questionlist.size())
           getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,QesFragment.newInstance()).commit();
        else{
            intent2 =new Intent(this , ResultActivity.class);
            intent2.putExtra(NAME,name);
            startActivity(intent2);
        }



    }

    @Override
    public void toNextFragment() {

         intent2 =new Intent(this,ResultActivity.class);
        intent2.putExtra(NAME,name);
        startActivity(intent2);
    }
}
