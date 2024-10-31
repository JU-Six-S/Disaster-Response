package com.jusixs.ndrs.data.repository;

import com.jusixs.ndrs.data.model.DisasterArchive;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository class for handling archived disaster data in the National Disaster Response System (NDRS) project.
 * Provides methods to retrieve a list of archived disaster incidents with details such as date and description.
 *
 * <p>This class currently provides dummy data for demonstration purposes.</p>
 *
 * @author Sadman
 */
public class ArchiveRepository {

    /**
     * Retrieves a list of archived disaster incidents.
     *
     * <p>The method currently returns dummy data representing past disasters, including details like
     * disaster name, date, and a brief description.</p>
     *
     * @return a list of {@link DisasterArchive} objects containing archived disaster details.
     */
    public List<DisasterArchive> getArchivedData() {
        // Dummy data
        List<DisasterArchive> archives = new ArrayList<>();
        archives.add(new DisasterArchive("Flood 2022", "2022-09-15", "Severe flooding in the eastern region."));
        archives.add(new DisasterArchive("Cyclone 2021", "2021-07-20", "Cyclone caused major damage to the coastline."));
        // Add more dummy entries as needed
        return archives;
    }
}
