package com.jusixs.ndrs.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jusixs.ndrs.data.model.Donation;
import com.jusixs.ndrs.data.repository.DonationRepository;
import com.jusixs.ndrs.util.Result;

/**
 * The {@code DonationViewModel} class serves as the ViewModel for managing the donation functionality
 * in the National Disaster Response System (NDRS) project.
 *
 * <p>This class acts as a bridge between the {@link com.jusixs.ndrs.ui.view.DonationActivity}
 * and the {@link DonationRepository}, handling data operations and providing observable results
 * to the UI. It manages the donation process by invoking the repository and exposing the result
 * through LiveData.</p>
 *
 * <p>Author: Sadman</p>
 */
public class DonationViewModel extends ViewModel {

    private final DonationRepository donationRepository;
    private final MutableLiveData<Result<String>> donationResult = new MutableLiveData<>();

    /**
     * Default constructor for {@code DonationViewModel}.
     * Initializes the {@link DonationRepository} to handle donation-related data operations.
     */
    public DonationViewModel() {
        donationRepository = new DonationRepository();
    }

    /**
     * Provides observable donation results to the UI.
     *
     * @return a {@link LiveData} object containing the result of the donation operation
     */
    public LiveData<Result<String>> getDonationResult() {
        return donationResult;
    }

    /**
     * Initiates the donation process by passing the provided {@link Donation} object to the repository.
     * The result of the operation is stored in the {@code donationResult} LiveData.
     *
     * @param donation the {@link Donation} object containing donor details and donation information
     */
    public void makeDonation(Donation donation) {
        Result<String> result = donationRepository.donate(donation);
        donationResult.setValue(result);
    }
}
