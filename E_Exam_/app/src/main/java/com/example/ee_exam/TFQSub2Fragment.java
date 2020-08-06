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



/**
 * A simple {@link Fragment} subclass.
 */
public class TFQSub2Fragment extends Fragment {

    private OnFragmentInteractionListener listener;
    private String value;
    public static TrueFalseQuestion tfqSub2;
    RandomNum randomNum;



    public TFQSub2Fragment() {
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
       // return inflater.inflate(R.layout.fragment_t_f_q_sub2, container, false);
        View view = inflater.inflate(R.layout.fragment_true_false, container, false);

        TextView textViewQues = view.findViewById(R.id.text_view_ques_t_f);
        final RadioGroup radioGroup = view.findViewById(R.id.radio_group_t_f);
        final RadioButton rb1 = view.findViewById(R.id.rbTrue);
        final RadioButton rb2 = view.findViewById(R.id.rbFalse);
        Button buttonNext = view.findViewById(R.id.button_next1);

        randomNum = new RandomNum();

        tfqSub2=SecSubject2Activity.tfqSub2List.get(SecSubject2Activity.randomTFQuestionsList[Score.indexTF]);

        textViewQues.setText(tfqSub2.getQuestion());

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
    public static TFQSub2Fragment newInstance() {

        TFQSub2Fragment tfqSub2Fragment = new TFQSub2Fragment();

        return tfqSub2Fragment;
    }

}
