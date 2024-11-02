package com.jusixs.ndrs.ui.view;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.jusixs.ndrs.R;

/**
 * Main activity that hosts the TrainingListFragment and serves as the entry point of the app.
 */
public class TrainingActivity extends AppCompatActivity {

    /**
     * Called when the activity is first created.
     * Sets up the content view and initializes the TrainingListFragment.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously
     *                           being shut down, this Bundle contains the most recent data.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                    .replace(R.id.fragment_container, new TrainingListFragment())
                    .commit();
        }
    }
}
