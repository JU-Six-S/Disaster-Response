package com.jusixs.ndrs.data.repository;

import com.jusixs.ndrs.data.model.Incident;
import java.util.HashMap;
import java.util.Map;

public class IncidentRepository {
    private final Map<String, Incident> incidentDatabase = new HashMap<>();

    public void storeIncident(Incident incident) {

        incidentDatabase.put(incident.getName(), incident);    // Placeholder: Add database or storage logic here later
    }

    public Incident getIncident(String name) {
        return incidentDatabase.get(name);
    }
}
