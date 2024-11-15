package com.jusixs.ndrs.ui.view;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.jusixs.ndrs.R;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.lifecycle.ViewModelProvider;
import com.jusixs.ndrs.data.model.Donation;
import com.jusixs.ndrs.ui.viewmodel.DonationViewModel;

/**
 * The {@code DonationActivity} class represents the user interface for making donations
 * in the National Disaster Response System (NDRS) project.
 *
 * <p>This activity allows users to input their donation details, including the donor name,
 * donation amount, payment method, and country. The details are submitted to the associated
 * {@link DonationViewModel} for processing, and the result of the operation is displayed
 * using a {@link Toast} message.</p>
 *
 * <p>Author: Sadman</p>
 */
public class DonationActivity extends AppCompatActivity {

    private DonationViewModel donationViewModel;

    /**
     * Called when the activity is first created. Sets up the UI and initializes the
     * {@link DonationViewModel}.
     *
     * @param savedInstanceState a {@link Bundle} object containing the activity's previously saved state, or {@code null} if there is no saved state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);

        // Initialize the DonationViewModel
        donationViewModel = new ViewModelProvider(this).get(DonationViewModel.class);

        // Initialize UI elements
        EditText donorNameEditText = findViewById(R.id.donor_name);
        EditText amountEditText = findViewById(R.id.amount);
        EditText paymentMethodEditText = findViewById(R.id.payment_method);
        EditText countryEditText = findViewById(R.id.country);
        Button donateButton = findViewById(R.id.donate_button);

        /**
         * Handles the click event for the donate button.
         * Collects user input from the form fields, creates a {@link Donation} object,
         * and submits it to the {@link DonationViewModel} for processing.
         */
        donateButton.setOnClickListener(v -> {
            String donorName = donorNameEditText.getText().toString();
            double amount = Double.parseDouble(amountEditText.getText().toString());
            String paymentMethod = paymentMethodEditText.getText().toString();
            String country = countryEditText.getText().toString();

            Donation donation = new Donation(donorName, amount, paymentMethod, country);
            donationViewModel.makeDonation(donation);
        });

        /**
         * Observes the result of the donation operation from the {@link DonationViewModel}.
         * Displays a success or error message using a {@link Toast}.
         */
        donationViewModel.getDonationResult().observe(this, result -> {
            if (result.isSuccess()) {
                Toast.makeText(this, result.getData(), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, result.getErrorMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
