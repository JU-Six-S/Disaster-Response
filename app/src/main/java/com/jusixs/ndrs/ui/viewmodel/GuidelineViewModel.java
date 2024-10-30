package com.jusixs.ndrs.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.jusixs.ndrs.data.model.Guideline;
import com.jusixs.ndrs.data.repository.GuidelineRepository;

import java.util.List;

/**
 * ViewModel for managing the retrieval and storage of guidelines.
 */
public class GuidelineViewModel extends ViewModel {

    private final GuidelineRepository repository;
    private final MutableLiveData<String> errorMessage = new MutableLiveData<>();
    private final LiveData<List<Guideline>> guidelines;

    public GuidelineViewModel() {
        repository = GuidelineRepository.getInstance();
        guidelines = repository.getGuidelines();
    }

    /**
     * Retrieves guidelines based on search criteria.
     *
     * @param type The type of incident.
     * @param location The location associated with the incident.
     * @param severity The severity level.
     * @return LiveData containing a list of guidelines that match the criteria.
     */
    public LiveData<List<Guideline>> getGuidelines(String type, String location, String severity) {
        try {
            // Filter guidelines based on search criteria (if the repository supports filtering).
            // If not, add filtering here or in the repository.
            return repository.getGuidelines(); // Modify this to filter by type, location, and severity if needed.
        } catch (Exception e) {
            errorMessage.setValue("Failed to retrieve guidelines.");
            return new MutableLiveData<>(null);  // Return empty data if error occurs
        }
    }

    /**
     * Retrieves the full list of guidelines.
     *
     * @return LiveData containing the list of guidelines.
     */
    public LiveData<List<Guideline>> getGuidelines() {
        return guidelines;
    }

    /**
     * Retrieves error messages for displaying to the user.
     *
     * @return LiveData containing the error message.
     */
    public LiveData<String> getErrorMessage() {
        return errorMessage;
    }
}
