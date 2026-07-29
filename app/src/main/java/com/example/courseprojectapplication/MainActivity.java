package com.example.courseprojectapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rV;
    ArrayList<Task> tasks;
    TaskAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rV = findViewById(R.id.recyclerView);

        tasks = TaskStorage.tasks;

        if (TaskStorage.tasks.isEmpty()) {
            TaskStorage.tasks.add(new Task("Buy Milk"));
        }

        rV.setLayoutManager(new LinearLayoutManager(this));

        adapter = new TaskAdapter(tasks);

        rV.setAdapter(adapter);


        FloatingActionButton addBtn = (FloatingActionButton) findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), AddNewActivity.class);
                startActivity(startIntent);
            }
        });

        Button clearBtn = (Button) findViewById(R.id.clearBtn);
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = tasks.size() - 1; i >= 0; i--) {
                    if (tasks.get(i).completed) {
                        tasks.remove(i);
                    }
                }
                adapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }
}