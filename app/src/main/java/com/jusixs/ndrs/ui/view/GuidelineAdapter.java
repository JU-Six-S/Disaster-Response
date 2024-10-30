package com.jusixs.ndrs.ui.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.jusixs.ndrs.R;
import com.jusixs.ndrs.data.model.Guideline;

import java.util.ArrayList;
import java.util.List;

/**
 * Adapter for displaying guidelines in a RecyclerView.
 */
public class GuidelineAdapter extends RecyclerView.Adapter<GuidelineAdapter.GuidelineViewHolder> {

    private List<Guideline> guidelines = new ArrayList<>();

    @NonNull
    @Override
    public GuidelineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_guideline, parent, false);
        return new GuidelineViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GuidelineViewHolder holder, int position) {
        Guideline guideline = guidelines.get(position);
        holder.bind(guideline);
    }

    @Override
    public int getItemCount() {
        return guidelines.size();
    }

    /**
     * Sets the list of guidelines for the adapter.
     *
     * @param guidelines List of guidelines to display.
     */
    public void setGuidelines(List<Guideline> guidelines) {
        this.guidelines = guidelines;
        notifyDataSetChanged();
    }

    /**
     * ViewHolder class for displaying individual guideline items.
     */
    static class GuidelineViewHolder extends RecyclerView.ViewHolder {
        private final TextView incidentTypeTextView;
        private final TextView locationTextView;
        private final TextView severityTextView;
        private final TextView contentTextView;
        private final TextView lastUpdatedTextView;

        public GuidelineViewHolder(@NonNull View itemView) {
            super(itemView);
            incidentTypeTextView = itemView.findViewById(R.id.incident_type);
            locationTextView = itemView.findViewById(R.id.location);
            severityTextView = itemView.findViewById(R.id.severity);
            contentTextView = itemView.findViewById(R.id.content);
            lastUpdatedTextView = itemView.findViewById(R.id.last_updated);
        }

        /**
         * Binds guideline data to the UI components.
         *
         * @param guideline the guideline data to display.
         */
        public void bind(Guideline guideline) {
            incidentTypeTextView.setText(guideline.getIncidentType());
            locationTextView.setText(guideline.getLocation());
            severityTextView.setText(guideline.getSeverity());
            contentTextView.setText(guideline.getContent());
            lastUpdatedTextView.setText(guideline.getLastUpdated());
        }
    }
}
