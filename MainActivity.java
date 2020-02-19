package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        // 1.
        List<String> toDoList = new ArrayList<>();
        toDoList.add(getString(R.string.call_mom));
        toDoList.add(getString(R.string.appointment));
        toDoList.add(getString(R.string.buy_a_cake));
        toDoList.add(getString(R.string.tickets));


        // 3.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.list_item, toDoList);

        // 4.
        ListView listViewToDoList = findViewById(R.id.to_do_list);
        listViewToDoList.setAdapter(adapter);
    }
}
