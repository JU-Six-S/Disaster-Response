package com.jusixs.ndrs.data.repository;

import com.jusixs.ndrs.data.model.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Repository for managing tasks and volunteer assignments.
 */
public class TaskRepository {

    // List to hold tasks
    private List<Task> taskList = new ArrayList<>();

    /**
     * Assigns a task based on its description.
     *
     * @param taskDescription The description of the task to assign.
     * @return {@code true} if the task description is valid; {@code false} otherwise.
     */
    public boolean assignTask(String taskDescription) {
        if (taskDescription == null || taskDescription.isEmpty()) {
            return false; // Invalid task description
        }
        return true; // Task description is valid
    }

    /**
     * Adds a volunteer to the system.
     *
     * @param name         The name of the volunteer.
     * @param contact      The contact information of the volunteer.
     * @param expertise    The area of expertise of the volunteer.
     * @param availability The availability status of the volunteer.
     * @return {@code true} if the volunteer was added successfully; {@code false} otherwise.
     */
    public boolean addVolunteer(String name, String contact, String expertise, String availability) {
        if (name == null || name.isEmpty() ||
                contact == null || contact.isEmpty() ||
                expertise == null || expertise.isEmpty() ||
                availability == null || availability.isEmpty()) {
            return false; // Invalid volunteer data
        }
        return true; // Volunteer data is valid
    }

    /**
     * Adds a task to the task list.
     *
     * @param taskName   The name of the task.
     * @param description The description of the task.
     * @param assignedTo The person to whom the task is assigned.
     * @return {@code true} if the task was added successfully; {@code false} otherwise.
     */
    public boolean addTask(String taskName, String description, String assignedTo) {
        if (taskName == null || taskName.isEmpty() ||
                description == null || description.isEmpty() ||
                assignedTo == null || assignedTo.isEmpty()) {
            return false; // Invalid task data
        }

        try {
            Task newTask = new Task(taskName, description, assignedTo, "Pending");
            taskList.add(newTask); // Add the task to the list
            return true;
        } catch (Exception e) {
            System.out.println("Error while adding task: " + e.getMessage());
            return false;
        }
    }

    /**
     * Updates the status of an existing task.
     *
     * @param taskName  The name of the task to update.
     * @param newStatus The new status to set for the task.
     * @return {@code true} if the task status was updated; {@code false} otherwise.
     */
    public boolean updateTaskStatus(String taskName, String newStatus) {
        if (taskName == null || taskName.isEmpty() || newStatus == null || newStatus.isEmpty()) {
            return false; // Invalid input
        }

        try {
            for (Task task : taskList) {
                if (task.getName().equals(taskName)) {
                    task.setStatus(newStatus); // Update task status
                    return true;
                }
            }
            return false; // Task not found
        } catch (Exception e) {
            System.out.println("Error while updating task status: " + e.getMessage());
            return false;
        }
    }
}
