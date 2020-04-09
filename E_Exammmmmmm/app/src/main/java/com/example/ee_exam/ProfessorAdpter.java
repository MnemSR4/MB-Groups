package com.example.ee_exam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.ee_exam.Model.Professor;

import java.util.List;

public class ProfessorAdpter extends ArrayAdapter <Professor> {

    public ProfessorAdpter(@NonNull Context context, int resource, @NonNull List<Professor> objects) {
        super(context, resource, objects);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.prpfitem,parent,false);

        Professor currentProfessor =getItem(position);

        TextView textViewQuestion =convertView.findViewById(R.id.text_id_item);
        textViewQuestion.setText(currentProfessor.getId());

        TextView textViewOption1 =convertView.findViewById(R.id.text_name_item);
        textViewOption1.setText(currentProfessor.getUserName());

        TextView textViewOption2 =convertView.findViewById(R.id.text_email_item_item);
        textViewOption2.setText(currentProfessor.getEmail());

        TextView textViewOption3 =convertView.findViewById(R.id.text_subject_item);
        textViewOption3.setText(currentProfessor.getSubjectName());

        TextView textViewOption4 =convertView.findViewById(R.id.text_view_password_item);
        textViewOption4.setText(currentProfessor.getPassword());


        return convertView;
    }
}
