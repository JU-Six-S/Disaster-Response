// ViewsInfoUserAdminActivity.java
package com.example.ndrsshelterinformationsifat.ui.view;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.ndrsshelterinformationsifat.R;
import com.example.ndrsshelterinformationsifat.ui.viewmodel.ViewsInfoUserAdminViewModel;

import java.io.File;

public class ViewsInfoUserAdminActivity extends AppCompatActivity {

    private ViewsInfoUserAdminViewModel viewsInfoUserAdminViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_viewsinfouseradmin);

        viewsInfoUserAdminViewModel = new ViewModelProvider(this).get(ViewsInfoUserAdminViewModel.class);

        viewsInfoUserAdminViewModel.categoryItemsMap.observe(this, categoryItemsMap -> {
            LinearLayout container = findViewById(R.id.itemsContainer);
            for (String category : categoryItemsMap.keySet()) {
                Toast.makeText(this, "Category: " + category, Toast.LENGTH_SHORT).show();
            }
        });

        loadItemsFromFiles();
    }

    private void loadItemsFromFiles() {
        File[] files = getFilesDir().listFiles();
        viewsInfoUserAdminViewModel.loadItems(files);
    }
}
