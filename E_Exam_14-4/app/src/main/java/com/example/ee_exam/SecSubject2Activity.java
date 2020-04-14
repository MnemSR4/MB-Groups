package com.example.ee_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SecSubject2Activity extends AppCompatActivity implements OnFragmentInteractionListener{

    public static int counter = 7200;
    private static final String FORMAT = "%02d:%02d:%02d";
    public static List<Question> questionSubject2List;
    public static List<TrueFalseQuestion> tfqSub2List;
    public static int[] randomQuestionsList;
    public static int[] randomTFQuestionsList;
    String name2;
    public static final String NAME = "NAME";
    Intent intent2;
    Intent intent1;
    DBHelper helper = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);

        name2=getIntent().getStringExtra(Accesscode_student.Extra_NAME2);


        final DBHelper helper = new DBHelper(this);
        questionSubject2List = helper.getAllQes("sub2");
        tfqSub2List = helper.getAllTFQes("sub2");
        RandomNum randomNum = new RandomNum();
        randomQuestionsList = randomNum.createRD(0, 11);
        randomTFQuestionsList = randomNum.createRD(0,2);

        final TextView textViewTime = findViewById(R.id.edit_text_time);

        counter =  helper.getExamTime("sub2")*3600;

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
                    intent2 = new Intent(SecSubject2Activity.this, ResultSub2SuccessActivity.class);
                    intent2.putExtra(NAME, name2);
                    startActivity(intent2);
                    finish();
                }else {
                    intent1 = new Intent(SecSubject2Activity.this, ResultFailedSub2Activity.class);
                    intent1.putExtra(NAME, name2);
                    startActivity(intent1);
                    finish();
                }
            }
        }.start();


        TextView textViewName = findViewById(R.id.text_view_name);
        textViewName.setText("Welcome, " + name2.substring(0, name2.indexOf('@')));

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, QuestionSubject2Fragment.newInstance()).commit();
    }

    @Override
    public void onFragmentInteraction(String value) {

        if (value == null) {
            Toast.makeText(this, "Please select one choice", Toast.LENGTH_SHORT).show();

            return;
        } else if (value.equalsIgnoreCase(QuestionSubject2Fragment.questionSubject2.getAnswer())) {
            Score.correct++;
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
        } else {
            Score.wrong++;
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
        }

        Score.indexMCQ++;
        if (Score.indexMCQ < randomQuestionsList.length) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, QuestionSubject2Fragment.newInstance()).commit();
        }

        else
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, TFQSub2Fragment.newInstance()).commit();
    }


    @Override
    public void onFragmentInteraction2(String value) {

        if (value == null) {
            Toast.makeText(this, "Please select one choice", Toast.LENGTH_SHORT).show();

            return;
        } else if (value.equalsIgnoreCase(TFQSub2Fragment.tfqSub2.getAnswer())) {
            Score.correct++;
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
        } else {
            Score.wrong++;
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
        }

        Score.indexTF++;
        if (Score.indexTF < randomTFQuestionsList.length) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, TFQSub2Fragment.newInstance()).commit();
        }else{

            if(Score.correct >= 5) {
                intent2 = new Intent(this, ResultSub2SuccessActivity.class);
                intent2.putExtra(NAME, name2);
                startActivity(intent2);
                finish();
            }else {
                intent1 = new Intent(this, ResultFailedSub2Activity.class);
                intent1.putExtra(NAME, name2);
                startActivity(intent1);
                finish();
            }
        }
    }

    @Override
    public void toNextFragment() {

    }
}
