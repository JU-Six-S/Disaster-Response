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

public class DonationActivity extends AppCompatActivity {
    private DonationViewModel donationViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);

        donationViewModel = new ViewModelProvider(this).get(DonationViewModel.class);

        EditText donorNameEditText = findViewById(R.id.donor_name);
        EditText amountEditText = findViewById(R.id.amount);
        EditText paymentMethodEditText = findViewById(R.id.payment_method);
        EditText countryEditText = findViewById(R.id.country);
        Button donateButton = findViewById(R.id.donate_button);

        donateButton.setOnClickListener(v -> {
            String donorName = donorNameEditText.getText().toString();
            double amount = Double.parseDouble(amountEditText.getText().toString());
            String paymentMethod = paymentMethodEditText.getText().toString();
            String country = countryEditText.getText().toString();

            Donation donation = new Donation(donorName, amount, paymentMethod, country);
            donationViewModel.makeDonation(donation);
        });

        donationViewModel.getDonationResult().observe(this, result -> {
            if (result.isSuccess()) {
                Toast.makeText(this, result.getData(), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, result.getErrorMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
