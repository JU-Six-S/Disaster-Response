package com.jusixs.ndrs.adapter;

import static org.junit.Assert.assertEquals;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

import com.jusixs.ndrs.data.model.TrainingSession;
import com.jusixs.ndrs.ui.adapter.TrainingAdapter;

import org.junit.Before;
import org.junit.Test;
import org.robolectric.Robolectric;
import org.robolectric.annotation.Config;
import org.robolectric.annotation.LooperMode;
import org.robolectric.android.controller.ActivityController;

import java.util.ArrayList;
import java.util.List;

@Config(sdk = 28)
@LooperMode(LooperMode.Mode.PAUSED)
public class TrainingAdapterTest {

    private TrainingAdapter adapter;
    private List<TrainingSession> sessions;
    private RecyclerView recyclerView;
    private Activity activity;

    @Before
    public void setUp() {
        // Create sample data
        sessions = new ArrayList<>();
        sessions.add(new TrainingSession("1", "Disaster Preparedness", "Theoretical",
                "10:00 AM - 12:00 PM", "John Doe",
                "Region 1", "Responder", false));

        // Create a mock activity
        ActivityController<Activity> activityController = Robolectric.buildActivity(Activity.class);
        activity = activityController.create().start().resume().get();

        // Create the RecyclerView and the adapter
        recyclerView = new RecyclerView(activity);
        recyclerView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        adapter = new TrainingAdapter(sessions, new TrainingAdapter.OnSessionActionListener() {
            @Override
            public void onRegister(TrainingSession session) {}
            @Override
            public void onMarkAttendance(TrainingSession session) {}
            @Override
            public void onSubmitFeedback(TrainingSession session) {}
        });

        // Set the adapter for RecyclerView
        recyclerView.setAdapter(adapter);
    }

    @Test
    public void testTrainingAdapterBinding() {
        // Notify the adapter of data changes
        adapter.notifyDataSetChanged();

        // Assert that the RecyclerView's adapter item count matches the session list size
        assertEquals(1, recyclerView.getAdapter().getItemCount());
    }
}
