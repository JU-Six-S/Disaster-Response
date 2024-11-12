package com.jusixs.ndrs.ui.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.jusixs.ndrs.data.model.Incident;
import com.jusixs.ndrs.data.repository.IncidentRepository;

public class IncidentViewModel extends ViewModel {
    private final IncidentRepository repository;
    private final MutableLiveData<Incident> incidentLiveData = new MutableLiveData<>();

    public IncidentViewModel(IncidentRepository repository) {
        this.repository = repository;
    }

//    public LiveData<Incident> getIncidentLiveData() {
//        return incidentLiveData;
//    }


    public void reportIncident(Incident incident) {
        repository.storeIncident(incident);
        //incidentLiveData.setValue(incident);
    }

    public void fetchIncident(String name) {
        Incident incident = repository.getIncident(name);
        incidentLiveData.setValue(incident); // Update LiveData with fetched incident
    }
}
