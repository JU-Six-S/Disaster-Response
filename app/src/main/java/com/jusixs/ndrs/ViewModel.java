// ViewModel.java
package com.example.final_emergency_2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;

public class ViewModel {

    private com.example.final_emergency_2.Model model;
    private Context context;

    public ViewModel(Context context) {
        this.context = context;
        this.model = new com.example.final_emergency_2.Model();
    }

    public void setPhoneClickListener(ImageView imageView, String phoneNumber) {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
                context.startActivity(intent);
            }
        });
    }

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
