package com.example.ee_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SecActivity extends AppCompatActivity implements OnFragmentInteractionListener {

    public int counter = 50;
    public static List<Question> questions;
    public static int[] randomQuestions;
    String name;
    public static final String NAME = "NAME";
    Intent intent2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);

        DBHelper helper = new DBHelper(this);
        questions = helper.getAllQes();
        RandomNum randomNum = new RandomNum();
        randomQuestions = randomNum.createRD(0, 9);


        final TextView textViewTime = findViewById(R.id.edit_text_time);

        new CountDownTimer(50000, 1000) {
            public void onTick(long millisUntilFinished) {
                textViewTime.setText(String.valueOf(counter));
                counter--;
            }

            public void onFinish() {
                textViewTime.setText("FINISH!!");
                intent2 = new Intent(SecActivity.this, ResultActivity.class);
                intent2.putExtra(NAME, name);
                startActivity(intent2);
            }
        }.start();

        name = getIntent().getStringExtra(MainActivity.EXTRA_NAME);
        TextView textViewName = findViewById(R.id.text_view_name);
        textViewName.setText("Welcome, " + name);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, QesFragment.newInstance()).commit();
    }

    @Override
    public void onFragmentInteraction(String value) {

        if (value == null) {
            Toast.makeText(this, "Please select one choice", Toast.LENGTH_SHORT).show();

            return;
        } else if (value.equalsIgnoreCase(QesFragment.question.getAnswer())) {
            Score.correct++;
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
        } else {
            Score.wrong++;
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
        }

        Score.flag++;
        if (Score.flag < randomQuestions.length)
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, QesFragment.newInstance()).commit();
        else {
            intent2 = new Intent(this, ResultActivity.class);
            intent2.putExtra(NAME, name);
            startActivity(intent2);
            finish();
        }


    }

    @Override
    public void toNextFragment() {

        intent2 = new Intent(this, ResultActivity.class);
        intent2.putExtra(NAME, name);
        startActivity(intent2);
    }
}
