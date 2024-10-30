package com.jusixs.ndrs.data.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.jusixs.ndrs.data.model.Guideline;

import java.util.ArrayList;
import java.util.List;

/**
 * Repository class for fetching guidelines from data sources.
 */
public class GuidelineRepository {

    private static GuidelineRepository instance;
    private final MutableLiveData<List<Guideline>> guidelines = new MutableLiveData<>();
    private final List<Guideline> demoData;

    private GuidelineRepository() {
        // Initializing with demo data
        demoData = new ArrayList<>();
        demoData.add(new Guideline("1", "Flood", "Bangladesh", "High", "Evacuate immediately", "2024-01-01"));
        demoData.add(new Guideline("2", "Cyclone", "Bangladesh", "Moderate", "Secure windows and doors", "2024-01-02"));
        guidelines.setValue(demoData);
    }

    /**
     * Singleton pattern to get the repository instance.
     *
     * @return the singleton instance of GuidelineRepository.
     */
    public static GuidelineRepository getInstance() {
        if (instance == null) {
            instance = new GuidelineRepository();
        }
        return instance;
    }

    /**
     * Retrieves the list of all guidelines.
     *
     * @return LiveData containing the list of guidelines.
     */
    public LiveData<List<Guideline>> getGuidelines() {
        return guidelines;
    }

    /**
     * Searches guidelines based on incident type, location, or severity.
     *
     * @param incidentType the type of incident to filter (e.g., "Flood")
     * @param location     the location to filter by (e.g., "Bangladesh")
     * @param severity     the severity level to filter by (e.g., "High")
     * @return LiveData containing the filtered list of guidelines.
     */
    public LiveData<List<Guideline>> searchGuidelines(String incidentType, String location, String severity) {
        MutableLiveData<List<Guideline>> filteredGuidelines = new MutableLiveData<>();
        List<Guideline> result = new ArrayList<>();

        for (Guideline guideline : demoData) {
            boolean matchesIncidentType = incidentType == null || guideline.getIncidentType().equalsIgnoreCase(incidentType);
            boolean matchesLocation = location == null || guideline.getLocation().equalsIgnoreCase(location);
            boolean matchesSeverity = severity == null || guideline.getSeverity().equalsIgnoreCase(severity);

            if (matchesIncidentType && matchesLocation && matchesSeverity) {
                result.add(guideline);
            }
        }

        filteredGuidelines.setValue(result);
        return filteredGuidelines;
    }

    /**
     * Simulates a retry mechanism to fetch guidelines in case of a failure.
     *
     * @return LiveData containing the list of guidelines after retrying.
     */
    public LiveData<List<Guideline>> retryFetchingGuidelines() {
        // Simulating a retry mechanism
        guidelines.setValue(demoData);
        return guidelines;
    }

    /**
     * Downloads guidelines as a PDF document.
     *
     * @return boolean indicating whether the download was successful.
     */
    public boolean downloadGuidelinesAsPDF() {
        // Placeholder logic for downloading as a PDF
        // Actual implementation would involve creating a PDF file with the guidelines
        return true; // Assume success for this example
    }

    /**
     * Shares guidelines with team members.
     *
     * @param guideline the guideline to be shared
     * @return boolean indicating whether the sharing was successful.
     */
    public boolean shareGuideline(Guideline guideline) {
        // Placeholder logic for sharing a guideline
        // Actual implementation would involve using Android's sharing capabilities
        return true; // Assume success for this example
    }
}
