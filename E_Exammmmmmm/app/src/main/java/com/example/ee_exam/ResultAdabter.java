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

public class ResultAdabter extends ArrayAdapter <Result> {


    public ResultAdabter(@NonNull Context context, int resource, @NonNull List<Result> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.students_results_item,parent,false);

        Result currentMCQ =getItem(position);

        TextView textViewStudentName =convertView.findViewById(R.id.text_view_student_name_item);
        textViewStudentName.setText(currentMCQ.getSubject_access_code());

        TextView textViewResult =convertView.findViewById(R.id.text_view_student_result_item);
        textViewResult.setText(String.valueOf(currentMCQ.getMarks()));


        return convertView;
    }
}
