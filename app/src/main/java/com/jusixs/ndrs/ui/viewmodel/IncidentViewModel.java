package com.jusixs.ndrs.ui.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.jusixs.ndrs.data.model.Incident;
import com.jusixs.ndrs.data.repository.IncidentRepository;

import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.List;

/**
 * ViewModel for managing incident data in the application.
 *
 * This ViewModel interacts with the IncidentRepository to fetch and store incident data. It provides
 * LiveData objects for the UI components to observe and display incident information.
 */
public class IncidentViewModel extends ViewModel {
    private final IncidentRepository repository;
    private final MutableLiveData<Incident> incidentLiveData = new MutableLiveData<>();
    private List<Incident> reportedIncidents = new ArrayList<>();

    /**
     * Constructs the IncidentViewModel with the given IncidentRepository.
     *
     * @param repository The repository used to access incident data.
     */
    public IncidentViewModel(IncidentRepository repository) {
        this.repository = repository;
        // Initialize the list of reported incidents with some dummy data.
        reportedIncidents.add(new Incident("Flood", "Water", "Chicago", "2024-11-10T08:30", "200 sq ft", "Rescue and medical"));
        reportedIncidents.add(new Incident("Fire", "Building", "New York", "2024-11-11T10:00", "500 sq ft", "Rescue"));
    }

    /**
     * Returns the LiveData object for incident data.
     *
     * This LiveData object can be observed by UI components to display incident details.
     *
     * @return A LiveData object containing the current incident.
     */
    public LiveData<Incident> getIncidentLiveData() {
        return incidentLiveData;
    }

    /**
     * Reports a new incident to the repository.
     *
     * This method checks if the incident has already been reported before storing it. If the incident
     * is null or already reported, the method returns early without storing it.
     *
     * @param incident The Incident object to be reported.
     */
    public void reportIncident(Incident incident) {
        if (incident == null) {
            return;
        }

        boolean alreadyReported = repository.isIncidentReported(
                incident.getName(),
                incident.getLocation(),
                incident.getTime()
        );

        if (alreadyReported) {
            System.out.println("This incident is already reported.");
            return;
        }
        repository.storeIncident(incident);
        //incidentLiveData.setValue(incident); // Uncomment if you want to set the value when incident is reported
    }

    /**
     * Fetches an incident by its name from the repository and updates the LiveData.
     *
     * This method retrieves the incident data from the repository and updates the incidentLiveData
     * object with the fetched incident information.
     *
     * @param name The name of the incident to be fetched.
     */
    public void fetchIncident(String name) {
        Incident incident = repository.getIncident(name);
        incidentLiveData.setValue(incident); // Update LiveData with fetched incident
    }

    /**
     * Checks if an incident with the given name, location, and time has already been reported.
     *
     * This method can be used to prevent duplicate incident reports. It currently returns false by
     * default, but this logic could be expanded to check a data source.
     *
     * @param name    The name of the incident.
     * @param location The location of the incident.
     * @param time    The time of the incident.
     * @return true if the incident has already been reported, false otherwise.
     */
    public boolean isIncidentReported(String name, String location, String time) {
        return false;
    }
}