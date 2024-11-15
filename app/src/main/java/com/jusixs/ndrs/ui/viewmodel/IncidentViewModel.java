package com.jusixs.ndrs.ui.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.jusixs.ndrs.data.model.Incident;
import com.jusixs.ndrs.data.repository.IncidentRepository;

import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.List;

public class IncidentViewModel extends ViewModel {
    private final IncidentRepository repository;
    private final MutableLiveData<Incident> incidentLiveData = new MutableLiveData<>();
    private List<Incident> reportedIncidents = new ArrayList<>();

    public IncidentViewModel(IncidentRepository repository) {

        this.repository = repository;

        reportedIncidents.add(new Incident("Flood", "Water", "Chicago", "2024-11-10T08:30", "200 sq ft","Rescue and medical"));
        reportedIncidents.add(new Incident("Fire", "Building", "New York", "2024-11-11T10:00", "500 sq ft","Rescue"));
    }

    public LiveData<Incident> getIncidentLiveData() {
        return incidentLiveData;
    }


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
        //incidentLiveData.setValue(incident);
    }

    public void fetchIncident(String name) {
        Incident incident = repository.getIncident(name);
        incidentLiveData.setValue(incident); // Update LiveData with fetched incident
    }


}
