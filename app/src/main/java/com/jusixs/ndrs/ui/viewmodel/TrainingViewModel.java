package com.jusixs.ndrs.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.jusixs.ndrs.data.model.TrainingSession;
import com.jusixs.ndrs.data.repository.TrainingRepository;
import java.util.List;

/**
 * ViewModel for managing the training sessions.
 */
public class TrainingViewModel extends ViewModel {
    private final TrainingRepository repository;
    private final MutableLiveData<List<TrainingSession>> sessions;

    public TrainingViewModel() {
        repository = new TrainingRepository();
        sessions = new MutableLiveData<>();
        loadTrainingSessions(); // Load sessions on initialization
    }

    /**
     * Fetches available training sessions and updates the LiveData.
     */
    private void loadTrainingSessions() {
        List<TrainingSession> trainingSessions = repository.getTrainingSessions();
        sessions.setValue(trainingSessions);
    }

    /**
     * Gets LiveData of the training sessions.
     *
     * @return LiveData object containing the list of training sessions.
     */
    public LiveData<List<TrainingSession>> getTrainingSessions() {
        return sessions;
    }
}
