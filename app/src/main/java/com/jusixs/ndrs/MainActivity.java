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

        // Enables edge-to-edge display for the activity
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Sets padding to the main view to accommodate system UI insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize ViewModel with context to handle interactions
        viewModel = new com.jusixs.ndrs.ViewModel(this);

        // Retrieve ImageView elements for different emergency contacts
        ImageView image_phone_coa = findViewById(R.id.phone_id_coa);
        ImageView image_phone_red = findViewById(R.id.phone_id_red);
        ImageView image_phone_pol = findViewById(R.id.phone_id_pol);
        ImageView image_phone_amb = findViewById(R.id.phone_id_amb);
        ImageView image_phone_child = findViewById(R.id.phone_id_chld);
        ImageView image_phone_rab = findViewById(R.id.phone_id_rab);
        ImageView image_phone_flod = findViewById(R.id.phone_id_flod);
        ImageView image_phone_fire = findViewById(R.id.phone_id_fire);
        ImageView image_phone_polHe = findViewById(R.id.phone_id_polHe);

        // Configure click listeners for each ImageView using ViewModel
        viewModel.initializePhoneClickListeners(image_phone_coa, image_phone_red, image_phone_pol,
                image_phone_amb, image_phone_child, image_phone_rab, image_phone_flod, image_phone_fire,
                image_phone_polHe);
    }
}
