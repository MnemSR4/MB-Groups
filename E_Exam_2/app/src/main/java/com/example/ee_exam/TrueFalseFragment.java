package com.example.ee_exam;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import static com.example.ee_exam.SecActivity.questions;
import static com.example.ee_exam.SecActivity.randomQuestions;
import static com.example.ee_exam.SecActivity.randomTFQuestions;
import static com.example.ee_exam.SecActivity.trueFalseQuestionss;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TrueFalseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TrueFalseFragment extends Fragment {

    private OnFragmentInteractionListener listener;
   private String value;
    public static TrueFalseQuestion trueFalseQuestion;
    RandomNum randomNum;


    public TrueFalseFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) ;
        listener = (OnFragmentInteractionListener) context;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_true_false, container, false);

        TextView textViewQues = view.findViewById(R.id.text_view_ques_t_f);
        final RadioGroup radioGroup = view.findViewById(R.id.radio_group_t_f);
        final RadioButton rb1 = view.findViewById(R.id.rbTrue);
        final RadioButton rb2 = view.findViewById(R.id.rbFalse);
        Button buttonNext = view.findViewById(R.id.button_next1);

        randomNum = new RandomNum();


        trueFalseQuestion = trueFalseQuestionss.get(randomTFQuestions[Score.index]);

        textViewQues.setText(trueFalseQuestion.getQuestion());



        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {
                    case R.id.rbTrue:
                        value = rb1.getText().toString();
                        break;
                    case R.id.rbFalse:
                        value = rb2.getText().toString();
                        break;

                }
            }
        });


        buttonNext.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        listener.onFragmentInteraction2(value);
                    }
                });

        radioGroup.clearCheck();

        return view;
    }

    public static TrueFalseFragment newInstance() {

        TrueFalseFragment trueFalseFragment = new TrueFalseFragment();

        return trueFalseFragment;
    }
}
