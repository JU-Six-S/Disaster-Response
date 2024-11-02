package com.jusixs.ndrs.viewmodel;

import static org.junit.Assert.*;
import org.junit.Test;
import com.jusixs.ndrs.ui.viewmodel.TrainingViewModel;
import com.jusixs.ndrs.data.model.TrainingSession;
import java.util.List;

public class TrainingViewModelTest {

    @Test
    public void testTrainingSessionsInitialization() {
        TrainingViewModel viewModel = new TrainingViewModel();
        List<TrainingSession> sessions = viewModel.getTrainingSessions();
        assertNotNull(sessions);
        assertEquals(2, sessions.size());
        assertEquals("Disaster Preparedness", sessions.get(0).getTitle());
    }

    @Test
    public void testTrainingSessionDataIntegrity() {
        TrainingViewModel viewModel = new TrainingViewModel();
        TrainingSession session = viewModel.getTrainingSessions().get(0);
        assertEquals("Theoretical", session.getType());
        assertFalse(session.isRegistered());
    }
}
