package com.jusixs.ndrs.ui.viewmodel;

import androidx.lifecycle.ViewModel;
import com.jusixs.ndrs.data.repository.TaskRepository;
import com.jusixs.ndrs.data.repository.FeedbackRepository;
import com.jusixs.ndrs.data.model.Task; // Fixed import for Task

public class VolunteerTaskViewModel extends ViewModel {
    private final TaskRepository taskRepository;
    private final FeedbackRepository feedbackRepository;

    // Constructor
    public VolunteerTaskViewModel(TaskRepository taskRepository, FeedbackRepository feedbackRepository) {
        this.taskRepository = taskRepository;
        this.feedbackRepository = feedbackRepository;
    }

    // Method for registering volunteer
    public boolean registerVolunteer(String name, String contact, String expertise, String availability) {
        // Validation for essential fields
        if (name.isEmpty() || contact.isEmpty()) {
            return false; // Registration fails if essential fields are empty
        }

        // Logic for saving the volunteer (for example, in Firestore or a local database)
        System.out.println("Registering volunteer: " + name + ", " + contact + ", " + expertise + ", " + availability);
        return true; // Return true if registration is successful
    }

    // Method to assign a task
    public boolean assignTask(String taskDescription) {
        return taskRepository.assignTask(taskDescription);
    }

    // Method for allocating a task
    public boolean allocateTask(String taskDescription) {
        if (taskDescription == null || taskDescription.isEmpty()) {
            return false;
        }

        // Logic for allocating the task
        System.out.println("Task allocated: " + taskDescription);
        return true;
    }

    // Method for sending communication (email, sms, notification)
    public boolean sendCommunication(String type) {
        if (type == null || type.isEmpty()) {
            return false;
        }

        // Logic for sending communication
        switch (type.toLowerCase()) {
            case "email":
                System.out.println("Email sent successfully.");
                break;
            case "sms":
                System.out.println("SMS sent successfully.");
                break;
            case "notification":
                System.out.println("Notification sent successfully.");
                break;
            default:
                System.out.println("Invalid communication type.");
                return false;
        }

        return true;
    }

    // Method for submitting feedback (using addFeedback from FeedbackRepository)
//    public boolean submitFeedback(String feedback, String volunteerName, String taskName) {
//        if (feedback == null || feedback.isEmpty() || volunteerName == null || volunteerName.isEmpty() || taskName == null || taskName.isEmpty()) {
//            return false; // Return false if any of the parameters are invalid
//        }
//        return feedbackRepository.addFeedback(feedback, volunteerName, taskName);
//    }

    // Method for updating task status
    public boolean updateTaskStatus(String taskName, String newStatus) {
        // Validate inputs
        if (taskName == null || taskName.isEmpty() || newStatus == null || newStatus.isEmpty()) {
            return false; // Return false if any of the inputs are invalid
        }

        // Use taskRepository to update task status
        return taskRepository.updateTaskStatus(taskName, newStatus);
    }

    public boolean submitFeedback(String feedback, String volunteerName, String taskName) {
        // Check if the parameters are valid
        if (feedback == null || feedback.isEmpty() || volunteerName == null || volunteerName.isEmpty() || taskName == null || taskName.isEmpty()) {
            return false; // Return false if any of the parameters are invalid
        }

        // Call the FeedbackRepository to add the feedback
        return feedbackRepository.addFeedback(feedback, volunteerName, taskName);
    }

    public boolean submitFeedback(String feedback) {
    return true;}
}
