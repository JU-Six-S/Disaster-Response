package com.jusixs.ndrs.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.jusixs.ndrs.data.model.VolunteerNGO;
import com.jusixs.ndrs.data.repository.VolunteerRepository;
import java.util.List;

public class VolunteerViewModel extends ViewModel {
    private final VolunteerRepository repository;

    public VolunteerViewModel() {
        repository = new VolunteerRepository();
    }

    public LiveData<List<VolunteerNGO>> getVolunteers() {
        return repository.getVolunteerLiveData();
    }

    public void registerVolunteer(String name, String contact, String expertise, String availability) {
        VolunteerNGO volunteer = new VolunteerNGO(name, contact, expertise, availability);
        repository.registerVolunteer(volunteer);
    }
}
