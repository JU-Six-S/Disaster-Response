package com.jusixs.ndrs.data.repository;

import com.jusixs.ndrs.data.model.Task;

import java.util.ArrayList;
import java.util.List;

public class FeedbackRepository {

    // List to hold tasks
    private List<Task> taskList;

    // Constructor to initialize the task list
    public FeedbackRepository() {
        taskList = new ArrayList<>();
    }

    // Add feedback to a specific task
    public boolean addFeedback(String feedback, String volunteerName, String taskName) {
        if (feedback == null || feedback.isEmpty()) {
            return false; // Return false if feedback is invalid
        }

        // Find the task by its name
        Task task = findTaskByName(taskName);
        if (task == null) {
            return false; // Return false if the task doesn't exist
        }

        // Add feedback to the task
        task.addFeedback(volunteerName, feedback);
        return true; // Return true indicating feedback was added successfully
    }

    // Method to find a task by its name
    private Task findTaskByName(String taskName) {
        for (Task task : taskList) {
            if (task.getName().equals(taskName)) {
                return task;
            }
        }
        return null; // Return null if no task found
    }

    // Method to add a task to the task list (for testing purposes or task management)
    public void addTask(Task task) {
        taskList.add(task);
    }
}
