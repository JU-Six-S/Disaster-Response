package com.jusixs.ndrs.ui.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.jusixs.ndrs.R;
import com.jusixs.ndrs.data.model.TrainingSession;
import java.util.ArrayList;
import java.util.List;

public class TrainingAdapter extends RecyclerView.Adapter<TrainingAdapter.TrainingViewHolder> {

    private final List<TrainingSession> sessions;

    public TrainingAdapter() {
        this.sessions = new ArrayList<>();
    }

    @NonNull
    @Override
    public TrainingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_training_session, parent, false);
        return new TrainingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrainingViewHolder holder, int position) {
        TrainingSession session = sessions.get(position);
        holder.title.setText(session.getTitle());
        holder.type.setText(session.getType());
        holder.trainer.setText(session.getTrainer());
        holder.schedule.setText(session.getSchedule());
    }

    @Override
    public int getItemCount() {
        return sessions.size();
    }

    public void updateSessions(List<TrainingSession> newSessions) {
        sessions.clear();
        sessions.addAll(newSessions);
        notifyDataSetChanged();
    }

    static class TrainingViewHolder extends RecyclerView.ViewHolder {
        TextView title, type, trainer, schedule;

        TrainingViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_session_title);
            type = itemView.findViewById(R.id.tv_session_type);
            trainer = itemView.findViewById(R.id.tv_trainer);
            schedule = itemView.findViewById(R.id.tv_schedule);
        }
    }
}