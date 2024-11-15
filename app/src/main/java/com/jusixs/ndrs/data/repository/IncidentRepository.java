package com.jusixs.ndrs.data.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.jusixs.ndrs.data.model.Incident;
import java.util.HashMap;
import java.util.Map;

/**
 * Repository class responsible for managing incidents.
 * This class handles incident data storage, retrieval, and checks for redundancy.
 */
public class IncidentRepository {

    // LiveData object for holding the incident data and notifying observers.
    private final MutableLiveData<Incident> incidentLiveData = new MutableLiveData<>();

    // In-memory database for storing incident information (using a HashMap as a placeholder).
    private final Map<String, Incident> incidentDatabase = new HashMap<>();

    /**
     * Stores an incident in the repository.
     * This method adds the incident to the in-memory database and updates the LiveData.
     *
     * @param incident the incident to be stored.
     */
    public void storeIncident(Incident incident) {
        // Store incident in the database
        incidentDatabase.put(incident.getName(), incident);

        // Update LiveData with the new incident
        //incidentLiveData.setValue(incident);
    }

    /**
     * Retrieves LiveData containing the incident information.
     * This method is used to fetch the current incident data.
     *
     * @param incidentName the name of the incident to retrieve.
     * @return LiveData object containing the incident data.
     */
    public LiveData<Incident> getIncidentLiveData(String incidentName) {
        // In a real application, this would fetch from the database and update the LiveData
        return incidentLiveData;
    }

    /**
     * Checks whether an incident has already been reported based on its name, location, and time.
     * This method simulates checking for existing incidents in the repository.
     *
     * @param name     the name of the incident.
     * @param location the location where the incident occurred.
     * @param time     the time of the incident.
     * @return true if the incident is reported, false otherwise.
     */
    public boolean isIncidentReported(String name, String location, String time) {
        // Simulate logic to check if an incident is already reported.
        // This would usually involve a database or data query.
        return false; // Return false as a placeholder for now.
    }

    /**
     * Retrieves an incident by its name from the database.
     * This method fetches the incident details from the in-memory database.
     *
     * @param name the name of the incident to retrieve.
     * @return the incident object, or null if not found.
     */
    public Incident getIncident(String name) {
        return incidentDatabase.get(name);
    }
}
