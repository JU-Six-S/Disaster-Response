package com.jusixs.ndrs;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
//import com.jusixs.ndrs.ui.view.VolunteerFragment;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
             //   .replace(R.id.fragment_volunteer, new VolunteerFragment())
                .commit();
    }
}
