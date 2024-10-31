package com.jusixs.ndrs;

import android.app.Application;

import com.google.firebase.FirebaseApp;

/**
 * NDRSApplication is the application class for the National Disaster Response System (NDRS).
 * It initializes Firebase when the application is created.
 */
public class NDRSApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseApp.initializeApp(this); // Initialize Firebase
    }
}
