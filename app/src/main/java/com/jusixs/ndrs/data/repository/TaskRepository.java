package com.jusixs.ndrs.data.repository;

import java.util.ArrayList;
import java.util.List;

import com.jusixs.ndrs.data.model.Task;  // Import the custom Task class

public class TaskRepository {

    private List<Task> taskList = new ArrayList<>();

    // Method to assign a task based on its description
    public boolean assignTask(String taskDescription) {
        // Validate the task description
        if (taskDescription == null || taskDescription.isEmpty()) {
            return false; // Return false if the task description is invalid
        }

        // Proceed with assigning the task if the description is valid
        return true;
    }


    // Method to add a volunteer (for example, adding to a list or database)
    public boolean addVolunteer(String name, String contact, String expertise, String availability) {
        // Validate the input fields for null or empty values
        if (name == null || name.isEmpty() || contact == null || contact.isEmpty() ||
                expertise == null || expertise.isEmpty() || availability == null || availability.isEmpty()) {
            return false; // Return false if any field is invalid
        }

        // Proceed with adding the volunteer if data is valid
        return true; // Assuming data is added successfully, return true
    }


    // Method to add a task (task name, description, assigned to person)
    public boolean addTask(String taskName, String description, String assignedTo) {
        try {
            // Validate inputs
            if (taskName == null || taskName.isEmpty() || description == null || description.isEmpty() || assignedTo == null || assignedTo.isEmpty()) {
                return false; // Return false if any input is invalid
            }

            // Create a new Task object
            Task newTask = new Task(taskName, description, assignedTo, "Pending");  // Status defaulted to "Pending"

            // Add the task to the list (or database)
            taskList.add(newTask); // This is just a simulation, replace with database logic if needed

            return true; // Return true indicating task was added successfully
        } catch (Exception e) {
            // Log the error or handle it appropriately
            System.out.println("Error while adding task: " + e.getMessage());
            return false;
        }
    }

    // Method to update the status of an existing task
    public boolean updateTaskStatus(String taskName, String newStatus) {
        try {
            // Validate inputs
            if (taskName == null || taskName.isEmpty() || newStatus == null || newStatus.isEmpty()) {
                return false; // Return false if any input is invalid
            }

            // Find the task by its name
            for (Task task : taskList) {
                if (task.getName().equals(taskName)) {
                    // If task found, update its status
                    task.setStatus(newStatus);
                    return true; // Return true indicating the status was updated
                }
            }

            // Return false if no task was found with the provided name
            return false;
        } catch (Exception e) {
            // Log the error or handle it appropriately
            System.out.println("Error while updating task status: " + e.getMessage());
            return false;
        }
    }
}
