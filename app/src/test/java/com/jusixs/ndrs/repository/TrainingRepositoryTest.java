package com.jusixs.ndrs.repository;
import com.jusixs.ndrs.data.repository.TrainingRepository;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.List;

public class TrainingRepositoryTest {

    @Test
    public void testRegisterForSession() {
        TrainingRepository repository = new TrainingRepository();
        boolean isRegistered = repository.registerForSession("1", "user123");
        assertTrue(isRegistered);
    }

    @Test
    public void testMarkAttendance() {
        TrainingRepository repository = new TrainingRepository();
        boolean isMarked = repository.markAttendanceOffline("1", "user123");
        assertTrue(isMarked);
    }

    @Test
    public void testGetTrainingMaterials() {
        TrainingRepository repository = new TrainingRepository();
        List<String> materials = repository.getTrainingMaterials("1");
        assertNotNull(materials);
        assertTrue(materials.isEmpty());
    }
}

