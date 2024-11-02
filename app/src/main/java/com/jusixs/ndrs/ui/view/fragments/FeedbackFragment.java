package com.jusixs.ndrs.ui.view.fragments;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.jusixs.ndrs.R;
import com.jusixs.ndrs.data.model.TrainingSession;

import java.util.ArrayList;
import java.util.List;

public class FeedbackFragment extends Fragment {

    private static final String SESSION_ID_KEY = "sessionId";
    private EditText feedbackEditText;
    private TrainingSession session;

    public static FeedbackFragment newInstance(String sessionId) {
        FeedbackFragment fragment = new FeedbackFragment();
        Bundle args = new Bundle();
        args.putString(SESSION_ID_KEY, sessionId);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feedback, container, false);

        initializeViews(view);
        retrieveSession();

        return view;
    }

    private void initializeViews(View view) {
        feedbackEditText = view.findViewById(R.id.et_feedback);
        Button submitButton = view.findViewById(R.id.btn_submit_feedback);
        submitButton.setOnClickListener(v -> submitFeedback());
    }

    private void retrieveSession() {
        if (getArguments() != null) {
            String sessionId = getArguments().getString(SESSION_ID_KEY);
            session = findSessionById(sessionId); // Fetch session from mock database
        }
    }

    private List<TrainingSession> getMockSessions() {
        List<TrainingSession> sessions = new ArrayList<>();
        // Add mock sessions for testing
        sessions.add(new TrainingSession("1", "Session 1", "Practical", "2024-11-10", "Trainer A", "Region A", "Role A", false));
        sessions.add(new TrainingSession("2", "Session 2", "Theoretical", "2024-11-11", "Trainer B", "Region B", "Role B", true));
        return sessions;
    }

    private TrainingSession findSessionById(String sessionId) {
        for (TrainingSession s : getMockSessions()) {
            if (s.getSessionId().equals(sessionId)) {
                return s;
            }
        }
        return null;
    }

    private void submitFeedback() {
        String feedback = feedbackEditText.getText().toString().trim();
        if (TextUtils.isEmpty(feedback)) {
            Toast.makeText(getContext(), "Please enter feedback", Toast.LENGTH_SHORT).show();
            return;
        }

        if (session != null) {
            session.addFeedback(feedback); // Add feedback to the session
            Toast.makeText(getContext(), "Feedback submitted", Toast.LENGTH_SHORT).show();
            getParentFragmentManager().popBackStack(); // Return to previous screen
        } else {
            Toast.makeText(getContext(), "Session not found", Toast.LENGTH_SHORT).show();
        }
    }
}
