package com.jusixs.ndrs.ui.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.jusixs.ndrs.R;
import com.jusixs.ndrs.data.model.TrainingSession;
import com.jusixs.ndrs.ui.adapter.TrainingAdapter;
import com.jusixs.ndrs.ui.viewmodel.TrainingViewModel;
import java.util.List;

/**
 * Fragment that displays a list of training sessions and handles interactions
 * such as registration, attendance marking, and feedback submission.
 */
public class TrainingListFragment extends Fragment {

    private TrainingViewModel trainingViewModel;
    private TrainingAdapter adapter;

    /**
     * Inflates the fragment layout and sets up the RecyclerView with the list of training sessions.
     *
     * @param inflater           The LayoutInflater object that can be used to inflate views in the fragment.
     * @param container          The parent view that the fragment's UI should be attached to.
     * @param savedInstanceState If non-null, this fragment is being re-constructed from a previous state.
     * @return The root View for the fragment's layout.
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_training_list, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.trainingRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        trainingViewModel = new ViewModelProvider(this).get(TrainingViewModel.class);
        adapter = new TrainingAdapter(trainingViewModel.getTrainingSessions(), new TrainingAdapter.OnSessionActionListener() {

            @Override
            public void onRegister(TrainingSession session) {
                session.setRegistered(true);
                Toast.makeText(getContext(), "Registered for " + session.getTitle(), Toast.LENGTH_SHORT).show();
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onMarkAttendance(TrainingSession session) {
                session.setAttendanceMarked(true);
                Toast.makeText(getContext(), "Attendance marked for " + session.getTitle(), Toast.LENGTH_SHORT).show();
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onSubmitFeedback(TrainingSession session) {
                Toast.makeText(getContext(), "Feedback submitted for " + session.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(adapter);
        return view;
    }
}
