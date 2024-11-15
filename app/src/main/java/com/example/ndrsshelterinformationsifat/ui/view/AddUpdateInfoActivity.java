package com.example.ndrsshelterinformationsifat.ui.view;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.ndrsshelterinformationsifat.R;
import com.example.ndrsshelterinformationsifat.data.model.ShelterItem;
import com.example.ndrsshelterinformationsifat.ui.viewmodel.AddUpdateViewModel;

/**
 * Activity for adding or updating shelter information.
 */
public class AddUpdateInfoActivity extends AppCompatActivity {

    private EditText address;
    private EditText capacity;
    private EditText contact;
    private Spinner spinnerCategory;
    private AddUpdateViewModel addUpdateViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_addupdateinfo);

        addUpdateViewModel = new ViewModelProvider(this).get(AddUpdateViewModel.class);

        address = findViewById(R.id.adres);
        capacity = findViewById(R.id.capci);
        contact = findViewById(R.id.cont);
        spinnerCategory = findViewById(R.id.spinnerCategory);
        Button btnSave = findViewById(R.id.btnSave);

        setupSpinner();
        btnSave.setOnClickListener(v -> saveItem());
    }

    /**
     * Configures the spinner with shelter categories.
     */
    private void setupSpinner() {
        String[] categories = {
                "Select Shelter Name",
                "City Hall Shelter Hub",
                "Southside Civic Shelter",
                "Riverbend Emergency Shelter"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(adapter);
    }

    /**
     * Saves the shelter item to the view model.
     */
    private void saveItem() {
        ShelterItem item = new ShelterItem(
                address.getText().toString().trim(),
                capacity.getText().toString().trim(),
                contact.getText().toString().trim(),
                spinnerCategory.getSelectedItem().toString()
        );
        addUpdateViewModel.saveItem(item);
    }
}
