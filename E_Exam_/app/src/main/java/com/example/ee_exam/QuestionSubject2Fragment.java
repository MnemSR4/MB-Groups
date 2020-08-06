package com.example.ee_exam;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;



/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionSubject2Fragment extends Fragment {


    private OnFragmentInteractionListener listener;
    private String value;
    public static Question questionSubject2;
    RandomNum randomNum;
    private String value1;
    private String value2;
    private String value3;
    private String value4;
    StringBuffer buffer = new StringBuffer();

    public QuestionSubject2Fragment() {
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
        View view = inflater.inflate(R.layout.fragment_qes, container, false);

        TextView textViewQues = view.findViewById(R.id.text_view_ques);
        final CheckBox chb1 = view.findViewById(R.id.chb1);
        final CheckBox chb2 = view.findViewById(R.id.chb2);
        final CheckBox chb3 = view.findViewById(R.id.chb3);
        final CheckBox chb4 = view.findViewById(R.id.chb4);
        Button buttonNext = view.findViewById(R.id.button_next);

        randomNum = new RandomNum();

        questionSubject2=SecSubject2Activity.questionSubject2List.get(SecSubject2Activity.randomQuestionsList[Score.indexMCQ]);
        String[] options = new String[]{questionSubject2.getOption_1(), questionSubject2.getOption_2(), questionSubject2.getOption_3(), questionSubject2.getOption_4()};
        int[] randomOptions = randomNum.createRD(0, 3);

        textViewQues.setText(questionSubject2.getQuestion());
        chb1.setText(options[randomOptions[0]]);
        chb2.setText(options[randomOptions[1]]);
        chb3.setText(options[randomOptions[2]]);
        chb4.setText(options[randomOptions[3]]);


        chb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    value1 = chb1.getText().toString();
                buffer.append(value1+" ");
            }
        });

        chb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    value2 = chb2.getText().toString();
                buffer.append(value2+" ");
            }
        });

        chb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    value3 = chb3.getText().toString();
                buffer.append(value3+" ");
            }
        });

        chb4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    value4 = chb4.getText().toString();
                buffer.append(value4+" ");
            }
        });
        buttonNext.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        listener.onFragmentInteraction(buffer.toString().trim());
                    }
                });


        return view;

    }

    public static QuestionSubject2Fragment newInstance() {

        QuestionSubject2Fragment qesSub2Fragment = new QuestionSubject2Fragment();

        return qesSub2Fragment;
    }
}
