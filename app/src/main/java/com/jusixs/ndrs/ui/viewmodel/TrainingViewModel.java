package com.jusixs.ndrs.ui.viewmodel;

import androidx.lifecycle.ViewModel;
import com.jusixs.ndrs.data.model.TrainingSession;
import java.util.ArrayList;
import java.util.List;

/**
 * ViewModel that manages and provides data related to training sessions.
 * Adheres to MVVM architecture by holding and managing UI-related data for TrainingListFragment.
 */
public class TrainingViewModel extends ViewModel {

    private final List<TrainingSession> trainingSessions;

    /**
     * Constructs a TrainingViewModel and initializes the training session list with sample data.
     */
    public TrainingViewModel() {
        trainingSessions = new ArrayList<>();
        trainingSessions.add(new TrainingSession("1", "Disaster Preparedness", "Theoretical",
                "10:00 AM - 12:00 PM", "John Doe",
                "Region 1", "Responder", false));
        trainingSessions.add(new TrainingSession("2", "Search and Rescue", "Practical",
                "2:00 PM - 4:00 PM", "Jane Smith",
                "Region 2", "Authority", false));
    }

    /**
     * Retrieves the list of training sessions.
     *
     * @return List of TrainingSession objects.
     */
    public List<TrainingSession> getTrainingSessions() {
        return trainingSessions;
    }
}
