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
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
                context.startActivity(intent);
            }
        });
    }

    /**
     * Initializes click listeners for various emergency contact ImageViews,
     * associating each with the respective phone numbers from the Model.
     *
     * @param image_phone_coa   ImageView for the Coast Guard contact.
     * @param image_phone_red   ImageView for the Red Crescent contact.
     * @param image_phone_pol   ImageView for the National Emergency contact.
     * @param image_phone_amb   ImageView for the Ambulance contact.
     * @param image_phone_child ImageView for the Child Helpline contact.
     * @param image_phone_rab   ImageView for the RAB contact.
     * @param image_phone_flod  ImageView for the Flood Forecasting contact.
     * @param image_phone_fire  ImageView for the Fire service contact.
     * @param image_phone_polHe ImageView for the Police Headquarters contact.
     */
    public void initializePhoneClickListeners(ImageView image_phone_coa, ImageView image_phone_red, ImageView image_phone_pol,
                                              ImageView image_phone_amb, ImageView image_phone_child, ImageView image_phone_rab,
                                              ImageView image_phone_flod, ImageView image_phone_fire,
                                              ImageView image_phone_polHe) {
        setPhoneClickListener(image_phone_coa, model.getCoastGuardNumber());
        setPhoneClickListener(image_phone_red, model.getRedCrescentNumber());
        setPhoneClickListener(image_phone_pol, model.getNationalEmergencyNumber());
        setPhoneClickListener(image_phone_amb, model.getAmbulanceNumber());
        setPhoneClickListener(image_phone_child, model.getChildHelplineNumber());
        setPhoneClickListener(image_phone_rab, model.getRabNumber());
        setPhoneClickListener(image_phone_flod, model.getFloodForecastingNumber());
        setPhoneClickListener(image_phone_fire, model.getFireNumber());
        setPhoneClickListener(image_phone_polHe, model.getPoliceHeadNumber());
    }
}
