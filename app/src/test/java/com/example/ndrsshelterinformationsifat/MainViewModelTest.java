package com.example.ndrsshelterinformationsifat.ui.viewmodel;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import androidx.test.core.app.ApplicationProvider;
import androidx.lifecycle.Observer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MainViewModelTest {

    private MainViewModel viewModel;

    @Before
    public void setUp() {
        Application application = ApplicationProvider.getApplicationContext();
        viewModel = new MainViewModel(application);
    }

    @Test
    public void testLoginUserSuccess() {
        // Set up observer to observe loginStatus
        MutableLiveData<Boolean> loginStatus = viewModel.loginStatus;

        // Create a test observer to assert the LiveData value
        Observer<Boolean> observer = new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isSuccess) {
                // Assert login success
                assertTrue(isSuccess);
            }
        };

        // Observe the LiveData
        loginStatus.observeForever(observer);

        // Simulate the login
        viewModel.loginUser("musfikus@gmail.com", "sifat12");

        // Cleanup observer after test
        loginStatus.removeObserver(observer);
    }

    @Test
    public void testLoginUserFailure() {
        // Set up observer to observe loginStatus
        MutableLiveData<Boolean> loginStatus = viewModel.loginStatus;

        // Create a test observer to assert the LiveData value
        Observer<Boolean> observer = new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isSuccess) {
                // Assert login failure
                assertFalse(isSuccess);
            }
        };

        // Observe the LiveData
        loginStatus.observeForever(observer);

        // Simulate the login
        viewModel.loginUser("wrong@example.com", "wrongpassword");

        // Cleanup observer after test
        loginStatus.removeObserver(observer);
    }
}
