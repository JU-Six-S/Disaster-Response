/**
 * National Disaster Response System (NDRS) - MainActivity class
 * <p>
 * This class represents the main entry point of the National Disaster Response System (NDRS) app.
 * It initializes the UI, sets up edge-to-edge display, and configures the ViewModel for handling
 * click events on various emergency contact ImageViews.
 * </p>
 * <p>
 * Project: National Disaster Response System (NDRS)
 * Developed by: Sifat
 * </p>
 */
package com.jusixs.ndrs;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jusixs.ndrs.R;

public class MainActivity extends AppCompatActivity {

    private com.jusixs.ndrs.ViewModel viewModel;

    /**
     * Initializes the activity.
     *
     * @param savedInstanceState Bundle containing the activity's previously saved state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Enable edge-to-edge display for the activity
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Set padding to the main view to accommodate system UI insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (view, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize ViewModel for handling interactions
        viewModel = new com.jusixs.ndrs.ViewModel(this);

        // Retrieve ImageView elements for emergency contacts
        ImageView imagePhoneCoastGuard = findViewById(R.id.phone_id_coa);
        ImageView imagePhoneRedCrescent = findViewById(R.id.phone_id_red);
        ImageView imagePhonePolice = findViewById(R.id.phone_id_pol);
        ImageView imagePhoneAmbulance = findViewById(R.id.phone_id_amb);
        ImageView imagePhoneChildHelpline = findViewById(R.id.phone_id_chld);
        ImageView imagePhoneRAB = findViewById(R.id.phone_id_rab);
        ImageView imagePhoneFloodForecasting = findViewById(R.id.phone_id_flod);
        ImageView imagePhoneFire = findViewById(R.id.phone_id_fire);
        ImageView imagePhonePoliceHeadquarters = findViewById(R.id.phone_id_polHe);

        // Configure click listeners for each ImageView using ViewModel
        viewModel.initializePhoneClickListeners(
                imagePhoneCoastGuard,
                imagePhoneRedCrescent,
                imagePhonePolice,
                imagePhoneAmbulance,
                imagePhoneChildHelpline,
                imagePhoneRAB,
                imagePhoneFloodForecasting,
                imagePhoneFire,
                imagePhonePoliceHeadquarters
        );
    }
}
