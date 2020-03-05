package com.example.ee_exam;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

import static com.example.ee_exam.SecActivity.*;


/**
 * A simple {@link Fragment} subclass.
 */
public class QesFragment extends Fragment {

    private OnFragmentInteractionListener listener;
    private String value;
    List <Question> questions ;

    public QesFragment() {
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
        final RadioGroup radioGroup = view.findViewById(R.id.radio_group);
        final RadioButton rb1 = view.findViewById(R.id.rb1);
        final RadioButton rb2 = view.findViewById(R.id.rb2);
        final RadioButton rb3 = view.findViewById(R.id.rb3);
        final RadioButton rb4 = view.findViewById(R.id.rb4);
        Button buttonNext = view.findViewById(R.id.button_next);



        textViewQues.setText(questionlist.get(Score.flag));
        rb1.setText(options_1.get(Score.flag));
        rb2.setText(options_2.get(Score.flag));
        rb3.setText(options_3.get(Score.flag));
        rb4.setText(options_4.get(Score.flag));


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {

            switch (checkedId) {
                case R.id.rb1:
                    value = rb1.getText().toString();
                    break;
                case R.id.rb2:
                    value = rb2.getText().toString();
                    break;
                case R.id.rb3:
                    value = rb3.getText().toString();
                    break;
                case R.id.rb4:
                    value = rb4.getText().toString();
                    break;

            }
        }
    });


        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listener.onFragmentInteraction(value);
            }
        });

        radioGroup.clearCheck();
        textViewQues.clearComposingText();
        rb1.clearComposingText();
        rb2.clearComposingText();
        rb3.clearComposingText();
        rb4.clearComposingText();

        return view;
    }

    public static QesFragment newInstance(){

        QesFragment q1Fragment =new QesFragment();

        return q1Fragment;
    }

}
