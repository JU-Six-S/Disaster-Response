package com.jusixs.ndrs.ui.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.jusixs.ndrs.R;
import com.jusixs.ndrs.data.model.TrainingSession;

public class RegistrationActivity extends AppCompatActivity {

    private TextView sessionTitleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration); // Ensure the layout file is correct

        sessionTitleTextView = findViewById(R.id.tv_session_title); // Reference to TextView

        // Get the intent
        Intent intent = getIntent();
        TrainingSession session = (TrainingSession) intent.getSerializableExtra("SESSION");

        // Check if session is not null
        if (session != null) {
            sessionTitleTextView.setText(session.getTitle()); // Display session title
        } else {
            Log.e("RegistrationActivity", "Received null session data");
        }
    }
}
