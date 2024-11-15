package com.example.ndrsshelterinformationsifat.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.ndrsshelterinformationsifat.data.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * ViewModel for managing login functionality and user data.
 */
public class MainViewModel extends AndroidViewModel {

    private List<User> dummyUsers;
    public MutableLiveData<Boolean> loginStatus = new MutableLiveData<>();

    public MainViewModel(@NonNull Application application) {
        super(application);
        initializeDummyUsers();
    }

    /**
     * Initializes a list of dummy users for login simulation.
     */
    private void initializeDummyUsers() {
        dummyUsers = new ArrayList<>();
        dummyUsers.add(new User("musfikus@gmail.com", "sifat12"));
        dummyUsers.add(new User("tamjid@gmail.com", "tamjid12"));
        dummyUsers.add(new User("choyon@gmail.com", "choyon12"));
    }

    /**
     * Verifies login credentials against dummy users and updates the login status.
     * @param email the email entered by the user
     * @param password the password entered by the user
     */
    public void loginUser(String email, String password) {
        boolean isAuthenticated = false;
        for (User user : dummyUsers) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                isAuthenticated = true;
                break;
            }
        }
        loginStatus.postValue(isAuthenticated);
    }
}
