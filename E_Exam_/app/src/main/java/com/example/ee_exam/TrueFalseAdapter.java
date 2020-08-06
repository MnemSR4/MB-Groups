package com.example.ee_exam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class TrueFalseAdapter extends ArrayAdapter <TrueFalseQuestion> {
    public TrueFalseAdapter(@NonNull Context context, int resource, @NonNull List<TrueFalseQuestion> objects) {
        super(context, resource, objects);
    }
    public View getView(int position, View convertView , ViewGroup parent){
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.true_false_item , parent , false);

        TrueFalseQuestion currentTrueFalseQuestion = getItem(position);

        TextView textViewTFQuestion = convertView.findViewById(R.id.text_view_t_f_question_item);
        textViewTFQuestion.setText(currentTrueFalseQuestion.getQuestion());

        TextView textViewTFAnswer = convertView.findViewById(R.id.text_view_t_f_answer_item);
        textViewTFAnswer.setText(currentTrueFalseQuestion.getAnswer());

        return convertView;


    }
}
