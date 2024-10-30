package com.jusixs.ndrs.data.repository;

import com.jusixs.ndrs.data.model.TrainingSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository class to manage training sessions.
 */
public class TrainingRepository {

    /**
     * Retrieves the list of available training sessions.
     *
     * @return List of TrainingSession objects.
     */
    public List<TrainingSession> getTrainingSessions() {
        List<TrainingSession> sessions = new ArrayList<>();
        sessions.add(new TrainingSession("1", "Disaster Preparedness Basics", "Theoretical", "2023-10-15 10:00 AM", "John Doe", false));
        sessions.add(new TrainingSession("2", "Emergency Response Techniques", "Practical", "2023-11-01 2:00 PM", "Jane Smith", false));
        return sessions;
    }
}
