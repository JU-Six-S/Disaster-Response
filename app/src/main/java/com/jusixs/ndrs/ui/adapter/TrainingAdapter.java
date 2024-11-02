package com.jusixs.ndrs.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.jusixs.ndrs.R;
import com.jusixs.ndrs.data.model.TrainingSession;
import java.util.List;

/**
 * Adapter for displaying a list of training sessions in a RecyclerView.
 * Provides options for registration, attendance marking, and feedback submission.
 */
public class TrainingAdapter extends RecyclerView.Adapter<TrainingAdapter.TrainingViewHolder> {

    private List<TrainingSession> trainingSessions;
    private final OnSessionActionListener actionListener;

    /**
     * Listener interface for handling user actions on each training session.
     */
    public interface OnSessionActionListener {
        /**
         * Called when the user registers for a session.
         *
         * @param session The session being registered for.
         */
        void onRegister(TrainingSession session);

        /**
         * Called when the user marks attendance for a session.
         *
         * @param session The session for which attendance is marked.
         */
        void onMarkAttendance(TrainingSession session);

        /**
         * Called when the user submits feedback for a session.
         *
         * @param session The session for which feedback is submitted.
         */
        void onSubmitFeedback(TrainingSession session);
    }

    /**
     * Constructs a TrainingAdapter.
     *
     * @param trainingSessions List of training sessions to display.
     * @param actionListener   Listener to handle actions on each session.
     */
    public TrainingAdapter(List<TrainingSession> trainingSessions, OnSessionActionListener actionListener) {
        this.trainingSessions = trainingSessions;
        this.actionListener = actionListener;
    }

    /**
     * Creates a new ViewHolder for a training session item.
     *
     * @param parent   The parent ViewGroup.
     * @param viewType The view type of the new View.
     * @return A new TrainingViewHolder.
     */
    @NonNull
    @Override
    public TrainingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_training_session, parent, false);
        return new TrainingViewHolder(view);
    }

    /**
     * Binds data to the ViewHolder at the specified position.
     *
     * @param holder   The TrainingViewHolder to bind data to.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull TrainingViewHolder holder, int position) {
        TrainingSession session = trainingSessions.get(position);
        holder.bind(session);
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The size of the training sessions list.
     */
    @Override
    public int getItemCount() {
        return trainingSessions.size();
    }

    /**
     * Updates the list of training sessions displayed in the RecyclerView.
     *
     * @param newSessions The updated list of training sessions.
     */
    public void updateSessions(List<TrainingSession> newSessions) {
        this.trainingSessions = newSessions;
        notifyDataSetChanged();
    }

    /**
     * ViewHolder for displaying individual training session details.
     */
    class TrainingViewHolder extends RecyclerView.ViewHolder {

        private final TextView titleTextView;
        private final TextView scheduleTextView;
        private final Button registerButton;
        private final Button attendanceButton;
        private final Button feedbackButton;

        /**
         * Constructs a TrainingViewHolder, initializing UI elements.
         *
         * @param itemView The view associated with this ViewHolder.
         */
        TrainingViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            scheduleTextView = itemView.findViewById(R.id.scheduleTextView);
            registerButton = itemView.findViewById(R.id.registerButton);
            attendanceButton = itemView.findViewById(R.id.attendanceButton);
            feedbackButton = itemView.findViewById(R.id.feedbackButton);
        }

        /**
         * Binds a TrainingSession object to the ViewHolder's UI components.
         *
         * @param session The TrainingSession object to display.
         */
        void bind(TrainingSession session) {
            titleTextView.setText(session.getTitle());
            scheduleTextView.setText(session.getSchedule());

            // Configure the register button
            registerButton.setEnabled(!session.isRegistered());
            registerButton.setOnClickListener(v -> actionListener.onRegister(session));

            // Configure the attendance button
            attendanceButton.setEnabled(session.isRegistered() && !session.isAttendanceMarked());
            attendanceButton.setOnClickListener(v -> actionListener.onMarkAttendance(session));

            // Configure the feedback button
            feedbackButton.setOnClickListener(v -> actionListener.onSubmitFeedback(session));
        }
    }
}
