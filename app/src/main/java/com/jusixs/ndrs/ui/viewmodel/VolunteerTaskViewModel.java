package com.jusixs.ndrs.ui.viewmodel;

import androidx.lifecycle.ViewModel;
import com.jusixs.ndrs.data.repository.TaskRepository;
import com.jusixs.ndrs.data.repository.FeedbackRepository;

public class VolunteerTaskViewModel extends ViewModel {
    private final TaskRepository taskRepository;
    private final FeedbackRepository feedbackRepository;

    public VolunteerTaskViewModel(TaskRepository taskRepository, FeedbackRepository feedbackRepository) {
        this.taskRepository = taskRepository;
        this.feedbackRepository = feedbackRepository;
    }

    public boolean registerVolunteer(String name, String contact, String expertise, String availability) {
        // Your logic for registering the volunteer with all four parameters
        // For example, saving the data in Firestore or a local database
        if (name.isEmpty() || contact.isEmpty()) {
            return false; // Registration fails if essential fields are empty
        }

        // Implement your logic to save the volunteer's data
        // Example logic (add actual implementation as needed)
        System.out.println("Registering volunteer: " + name + ", " + contact + ", " + expertise + ", " + availability);
        return true; // Return true if registration is successful
    }


    public boolean assignTask(String taskDescription) {
        return taskRepository.assignTask(taskDescription);
    }
    public boolean allocateTask(String taskDescription) {
        if (taskDescription == null || taskDescription.isEmpty()) {
            return false;
        }

        // Logic for allocating the task (simplified example)
        System.out.println("Task allocated: " + taskDescription);
        return true;
    }public boolean sendCommunication(String type) {
        if (type == null || type.isEmpty()) {
            return false;
        }

        // Logic for sending communication (simplified example)
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
    public boolean submitFeedback(String feedback) {
        return feedbackRepository.submitFeedback(feedback);
    }
}
