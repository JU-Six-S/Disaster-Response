/**
 * ViewModel class for managing click events and initiating phone calls for various emergency services.
 * <p>
 * This class handles setting click listeners on emergency service icons, triggering phone dial actions
 * using the specified phone numbers from the Model class.
 * </p>
 * <p>
 * Project: National Disaster Response System (NDRS)
 * Developed by: Sifat
 * </p>
 */
package com.jusixs.ndrs;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;

public class ViewModel {

    private com.jusixs.ndrs.Model model;
    private Context context;

    /**
     * Constructs a ViewModel object with the given context.
     *
     * @param context The context of the activity where the ViewModel is used.
     */
    public ViewModel(Context context) {
        this.context = context;
        this.model = new com.jusixs.ndrs.Model();
    }

    /**
     * Sets a click listener on the provided ImageView to initiate a phone dial action with the specified phone number.
     *
     * @param imageView   The ImageView on which the click listener will be set.
     * @param phoneNumber The phone number to dial when the ImageView is clicked.
     */
    public void setPhoneClickListener(ImageView imageView, String phoneNumber) {
        imageView.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
            context.startActivity(intent);
        });
    }

    /**
     * Initializes click listeners for various emergency contact ImageViews,
     * associating each with the respective phone numbers from the Model.
     *
     * @param imagePhoneCoastGuard   ImageView for the Coast Guard contact.
     * @param imagePhoneRedCrescent  ImageView for the Red Crescent contact.
     * @param imagePhonePolice       ImageView for the National Emergency contact.
     * @param imagePhoneAmbulance    ImageView for the Ambulance contact.
     * @param imagePhoneChildHelpline ImageView for the Child Helpline contact.
     * @param imagePhoneRAB          ImageView for the RAB contact.
     * @param imagePhoneFlood        ImageView for the Flood Forecasting contact.
     * @param imagePhoneFire         ImageView for the Fire service contact.
     * @param imagePhonePoliceHQ     ImageView for the Police Headquarters contact.
     */
    public void initializePhoneClickListeners(ImageView imagePhoneCoastGuard, ImageView imagePhoneRedCrescent,
                                              ImageView imagePhonePolice, ImageView imagePhoneAmbulance,
                                              ImageView imagePhoneChildHelpline, ImageView imagePhoneRAB,
                                              ImageView imagePhoneFlood, ImageView imagePhoneFire,
                                              ImageView imagePhonePoliceHQ) {
        setPhoneClickListener(imagePhoneCoastGuard, model.getCoastGuardNumber());
        setPhoneClickListener(imagePhoneRedCrescent, model.getRedCrescentNumber());
        setPhoneClickListener(imagePhonePolice, model.getNationalEmergencyNumber());
        setPhoneClickListener(imagePhoneAmbulance, model.getAmbulanceNumber());
        setPhoneClickListener(imagePhoneChildHelpline, model.getChildHelplineNumber());
        setPhoneClickListener(imagePhoneRAB, model.getRabNumber());
        setPhoneClickListener(imagePhoneFlood, model.getFloodForecastingNumber());
        setPhoneClickListener(imagePhoneFire, model.getFireNumber());
        setPhoneClickListener(imagePhonePoliceHQ, model.getPoliceHeadNumber());
    }
}
