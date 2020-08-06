package com.example.ee_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SecActivity extends AppCompatActivity implements OnFragmentInteractionListener {

    public static int counter = 7200;
    private static final String FORMAT = "%02d:%02d:%02d";
    public static List<Question> questions;
    public static List<TrueFalseQuestion> trueFalseQuestionss;
    public static int[] randomQuestions;
    public static int[] randomTFQuestions;
    String name;
    public static final String NAME = "NAME";
    Intent intent2;
    Intent intent1;
    DBHelper helper = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);


        final DBHelper helper = new DBHelper(this);
        questions = helper.getAllQes("sub");
        trueFalseQuestionss = helper.getAllTFQes("sub");
        RandomNum randomNum = new RandomNum();
        randomQuestions = randomNum.createRD(0, 9);
        randomTFQuestions = randomNum.createRD(0,2);


        final TextView textViewTime = findViewById(R.id.edit_text_time);

        counter =  helper.getExamTime("sub")*3600;

        int seconds , minutes;

        new CountDownTimer(counter*1000, 1000) {
            public void onTick(long millisUntilFinished) {
                textViewTime.setText(""+String.format(FORMAT,
                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                                TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
              counter --;
            }

            public void onFinish() {
                textViewTime.setText("FINISH!!");
                if(Score.correct >= 5) {
                    intent2 = new Intent(SecActivity.this, ResultSuccessActivity.class);
                    intent2.putExtra(NAME, name);
                    startActivity(intent2);
                    finish();
                }else {
                    intent1 = new Intent(SecActivity.this, ResultFailedActivity.class);
                    intent1.putExtra(NAME, name);
                    startActivity(intent1);
                    finish();
                }
            }
        }.start();




        name = getIntent().getStringExtra(Accesscode_student.Extra_NAME);
        TextView textViewName = findViewById(R.id.text_view_name);

        textViewName.setText("Welcome, " + name.substring(0,name.indexOf('@')));

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

        Score.indexMCQ++;
        if (Score.indexMCQ < randomQuestions.length) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, QesFragment.newInstance()).commit();
        }

        else
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, TrueFalseFragment.newInstance()).commit();
    }

    @Override
    public void onFragmentInteraction2(String value) {
        if (value == null) {
            Toast.makeText(this, "Please select one choice", Toast.LENGTH_SHORT).show();

            return;
        } else if (value.equalsIgnoreCase(TrueFalseFragment.trueFalseQuestion.getAnswer())) {
            Score.correct++;
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
        } else {
            Score.wrong++;
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
        }

        Score.indexTF++;
        if (Score.indexTF < randomTFQuestions.length) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, TrueFalseFragment.newInstance()).commit();
        }else{

            if(Score.correct >= 5) {
                intent2 = new Intent(this, ResultSuccessActivity.class);
                intent2.putExtra(NAME, name);
                startActivity(intent2);
                finish();
            }else {
                intent1 = new Intent(this, ResultFailedActivity.class);
                intent1.putExtra(NAME, name);
                startActivity(intent1);
                finish();
            }
        }
    }

    @Override
    public void toNextFragment() {

        if (Score.correct >= 5) {
            intent2 = new Intent(this, ResultSuccessActivity.class);
            intent2.putExtra(NAME, name);
            startActivity(intent2);
            finish();
            DBHelper dbHelper=new DBHelper(this);
            dbHelper.addResult(new Result(name.substring(0,name.indexOf('@')),Score.correct));
        } else {
            intent1 = new Intent(this, ResultFailedActivity.class);
            intent1.putExtra(NAME, name);
            startActivity(intent1);
            finish();
            DBHelper dbHelper=new DBHelper(this);
            dbHelper.addResult(new Result(name.substring(0,name.indexOf('@')),Score.correct));
        }
    }

}

