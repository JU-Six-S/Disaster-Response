package com.jusixs.ndrs.ui.view;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.jusixs.ndrs.R;
import com.jusixs.ndrs.ui.viewmodel.TrainingViewModel;

public class TrainingActivity extends AppCompatActivity {

    private TrainingAdapter adapter;
    private TrainingViewModel trainingViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

        // Initialize RecyclerView and adapter
        RecyclerView recyclerView = findViewById(R.id.rv_training_sessions);
        adapter = new TrainingAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize ViewModel and observe data
        trainingViewModel = new ViewModelProvider(this).get(TrainingViewModel.class);
        trainingViewModel.getTrainingSessions().observe(this, sessions -> {
            adapter.updateSessions(sessions);
        });
    }
}
