package com.example.ee_exam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MCQuestionAdabter extends ArrayAdapter <Question> {
    public MCQuestionAdabter(@NonNull Context context, int resource, @NonNull List<Question> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.mcqitem,parent,false);

        Question currentMCQ =getItem(position);

        TextView textViewQuestion =convertView.findViewById(R.id.text_view_question_item);
        textViewQuestion.setText(currentMCQ.getQuestion());

        TextView textViewOption1 =convertView.findViewById(R.id.text_view_option1_item);
        textViewOption1.setText(currentMCQ.getOption_1());

        TextView textViewOption2 =convertView.findViewById(R.id.text_view_option2_item);
        textViewOption2.setText(currentMCQ.getOption_2());

        TextView textViewOption3 =convertView.findViewById(R.id.text_view_option3_item);
        textViewOption3.setText(currentMCQ.getOption_3());

        TextView textViewOption4 =convertView.findViewById(R.id.text_view_option4_item);
        textViewOption4.setText(currentMCQ.getOption_4());

        TextView textViewAnswer =convertView.findViewById(R.id.text_view_answar_item);
        textViewAnswer.setText(currentMCQ.getAnswer());

        return convertView;
    }
}
