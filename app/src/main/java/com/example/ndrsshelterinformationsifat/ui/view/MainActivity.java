package com.example.ndrsshelterinformationsifat.ui.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.ndrsshelterinformationsifat.R;
import com.example.ndrsshelterinformationsifat.ui.viewmodel.MainViewModel;

/**
 * Main activity for user login and navigation.
 */
public class MainActivity extends AppCompatActivity {

    private Button btnViewItems;
    private Button btnLogin;
    private EditText etEmail;
    private EditText etPassword;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        initializeUI();
        observeLoginStatus();
    }

    /**
     * Initializes the UI components and sets up button listeners.
     */
    private void initializeUI() {
        btnViewItems = findViewById(R.id.btnViewItems);
        btnLogin = findViewById(R.id.btnLogin);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);

        btnViewItems.setOnClickListener(v -> navigateToViewItems());
        btnLogin.setOnClickListener(v -> loginUser());
    }

    /**
     * Observes the login status from the view model and provides user feedback.
     */
    private void observeLoginStatus() {
        mainViewModel.loginStatus.observe(this, isAuthenticated -> {
            if (isAuthenticated) {
                Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                navigateToHomeScreen();
            } else {
                Toast.makeText(MainActivity.this, "Login failed: Invalid credentials", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Navigates to the ViewsInfoUserAdminActivity.
     */
    private void navigateToViewItems() {
        Intent intent = new Intent(this, ViewsInfoUserAdminActivity.class);
        startActivity(intent);
    }

    /**
     * Navigates to the home screen activity upon successful login.
     */
    private void navigateToHomeScreen() {
        Intent intent = new Intent(MainActivity.this, MainViewModel.class); // Change this to the correct destination activity.
        startActivity(intent);
    }

    /**
     * Initiates the login process by retrieving user input and calling the view model's login function.
     */
    private void loginUser() {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        mainViewModel.loginUser(email, password);
    }
}
