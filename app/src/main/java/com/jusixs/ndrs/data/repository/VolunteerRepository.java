package com.jusixs.ndrs.data.repository;

import androidx.lifecycle.MutableLiveData;
import com.jusixs.ndrs.data.model.VolunteerNGO;
import java.util.ArrayList;
import java.util.List;

public class VolunteerRepository {
    private final List<VolunteerNGO> volunteers = new ArrayList<>();
    private final MutableLiveData<List<VolunteerNGO>> volunteerLiveData = new MutableLiveData<>();

    public MutableLiveData<List<VolunteerNGO>> getVolunteerLiveData() {
        return volunteerLiveData;
    }

    public void registerVolunteer(VolunteerNGO volunteer) {
        volunteers.add(volunteer);
        volunteerLiveData.setValue(volunteers);
    }

    public void updateVolunteerList() {
        volunteerLiveData.setValue(volunteers);
    }
}
