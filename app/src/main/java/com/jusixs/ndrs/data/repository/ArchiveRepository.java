package com.jusixs.ndrs.data.repository;

import com.jusixs.ndrs.data.model.DisasterArchive;
import java.util.ArrayList;
import java.util.List;

public class ArchiveRepository {

    public List<DisasterArchive> getArchivedData() {
        // Dummy data
        List<DisasterArchive> archives = new ArrayList<>();
        archives.add(new DisasterArchive("Flood 2022", "2022-09-15", "Severe flooding in the eastern region."));
        archives.add(new DisasterArchive("Cyclone 2021", "2021-07-20", "Cyclone caused major damage to the coastline."));
        // Add more dummy entries as needed
        return archives;
    }
}