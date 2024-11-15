package com.jusixs.ndrs.data.repository;

import com.jusixs.ndrs.data.model.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Repository for managing feedback on tasks.
 */
public class FeedbackRepository {

    // List to hold tasks
    private List<Task> taskList;

    /**
     * Constructor to initialize the task list.
     */
    public FeedbackRepository() {
        taskList = new ArrayList<>();
    }

    /**
     * Adds feedback to a specific task.
     *
     * @param feedback      The feedback text to add.
     * @param volunteerName The name of the volunteer providing feedback.
     * @param taskName      The name of the task to which feedback is added.
     * @return {@code true} if feedback was added successfully; {@code false} otherwise.
     */
    public boolean addFeedback(String feedback, String volunteerName, String taskName) {
        if (feedback == null || feedback.isEmpty()) {
            return false; // Invalid feedback
        }

        Task task = findTaskByName(taskName);
        if (task == null) {
            return false; // Task not found
        }

        task.addFeedback(volunteerName, feedback); // Add feedback to the task
        return true;
    }

    /**
     * Finds a task by its name.
     *
     * @param taskName The name of the task to find.
     * @return The task if found; {@code null} if no task is found with the given name.
     */
    private Task findTaskByName(String taskName) {
        for (Task task : taskList) {
            if (task.getName().equals(taskName)) {
                return task;
            }
        }
        return null;
    }

    /**
     * Adds a task to the task list.
     *
     * @param task The task to add to the list.
     */
    public void addTask(Task task) {
        taskList.add(task);
    }
}
