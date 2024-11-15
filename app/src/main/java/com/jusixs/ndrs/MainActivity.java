package com.jusixs.ndrs;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.jusixs.ndrs.R; // Explicit import for clarity
import com.jusixs.ndrs.ui.view.VolunteerFragment;

/**
 * Main activity for the National Disaster Response System application.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Initializes the main activity and sets up the layout.
     *
     * @param savedInstanceState The saved instance state bundle.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize and replace the fragment
        getSupportFragmentManager().beginTransaction()
                //.replace(R.id.fragmentContainer, new VolunteerFragment())
                .commit();
    }
}
