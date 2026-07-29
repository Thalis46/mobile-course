package com.example.courseprojectapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddNewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);

        Button addNewTaskBtn = (Button) findViewById(R.id.addNewTaskBtn);
        addNewTaskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText newTaskEditText = (EditText) findViewById((R.id.newTaskEditText));
                String newTask = newTaskEditText.getText().toString().trim();

                if(!newTask.isEmpty()) {

                    TaskStorage.tasks.add(new Task(newTask));

                    finish();
                }


            }
        });
    }
}