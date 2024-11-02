package com.jusixs.ndrs.data.repository;

import com.jusixs.ndrs.data.model.DisasterArchive;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ArchiveRepositoryTest {

    @Test
    public void getArchivedData_shouldReturnDummyData() {
        // Arrange
        ArchiveRepository repository = new ArchiveRepository();

        // Act
        List<DisasterArchive> archives = repository.getArchivedData();

        // Assert
        assertNotNull("Data should not be null", archives);
        assertEquals("Expected 2 items in dummy data", 2, archives.size());
        assertEquals("First item should be 'Flood 2022'", "Flood 2022", archives.get(0).getTitle());
    }
}
