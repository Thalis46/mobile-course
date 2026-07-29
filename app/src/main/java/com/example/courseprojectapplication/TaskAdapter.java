package com.example.courseprojectapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    private ArrayList<Task> tasks;

    public TaskAdapter(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        CheckBox cB;
        TextView tV;

        public ViewHolder(View itemView) {
            super(itemView);

            cB = itemView.findViewById(R.id.taskCB);
            tV = itemView.findViewById(R.id.taskTV);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Task task = tasks.get(position);
        holder.tV.setText(task.title);
        holder.cB.setChecked(task.completed);
        holder.cB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                task.completed = isChecked;
            }
        });
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }


}
