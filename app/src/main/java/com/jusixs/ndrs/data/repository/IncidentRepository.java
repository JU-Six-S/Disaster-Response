package com.jusixs.ndrs.data.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.jusixs.ndrs.data.model.Incident;
import java.util.HashMap;
import java.util.Map;

public class IncidentRepository {
    private final MutableLiveData<Incident> incidentLiveData = new MutableLiveData<>();
    private final Map<String, Incident> incidentDatabase = new HashMap<>();

    public void storeIncident(Incident incident) {

        incidentDatabase.put(incident.getName(), incident);// Placeholder: Add database or storage logic here later
        incidentLiveData.setValue(incident);
    }

    public LiveData<Incident> getIncidentLiveData(String incidentName) {
        // Perform database fetch and set it to incidentLiveData (mocked here)
        return incidentLiveData;
    }

    public boolean isIncidentReported(String name, String location, String time) {
        // Implement logic to check if an incident is already reported.
        // This could involve querying a database or data source.
        return false; // Return true if reported, false otherwise
    }

    public Incident getIncident(String name) {
        return incidentDatabase.get(name);
    }

//    public LiveData<Incident> getIncidentLiveData(String incidentName) {
//        MutableLiveData<Incident> liveData = new MutableLiveData<>();
//        // Assume fetchIncidentByName is a method in your repository to get incident details
//        liveData.setValue(fetchIncidentByName(incidentName));
//        return liveData;
//    }
//
//    public Incident fetchIncidentByName(String incidentName) {
//        // For now, you can return dummy data or fetch from an actual data source
//        // Replace this with actual data retrieval logic
//        if (incidentName.equals("Flood")) {
//            return new Incident("Flood", "Water", "Chicago", "2024-11-10T08:30", "200 sq ft");
//        }
//        return null;
//    }
//
//    public Incident getIncident(String name) {
//        return incidentDatabase.get(name);
//    }
}
