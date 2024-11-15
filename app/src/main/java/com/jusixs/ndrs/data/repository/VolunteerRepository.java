package com.jusixs.ndrs.data.repository;

import androidx.lifecycle.MutableLiveData;
import com.jusixs.ndrs.data.model.Volunteer;
import java.util.ArrayList;
import java.util.List;

public class VolunteerRepository {
    private final List<Volunteer> volunteers = new ArrayList<>();
    private final MutableLiveData<List<Volunteer>> volunteerLiveData = new MutableLiveData<>();

    public MutableLiveData<List<Volunteer>> getVolunteerLiveData() {
        return volunteerLiveData;
    }

    public void registerVolunteer(Volunteer volunteer) {
        volunteers.add(volunteer);
        volunteerLiveData.setValue(volunteers);
    }

    public void updateVolunteerList() {
        volunteerLiveData.setValue(volunteers);
    }
}
