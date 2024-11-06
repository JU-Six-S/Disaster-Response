package com.jusixs.ndrs.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jusixs.ndrs.data.model.Donation;
import com.jusixs.ndrs.data.repository.DonationRepository;
import com.jusixs.ndrs.util.Result;

public class DonationViewModel extends ViewModel {
    private final DonationRepository donationRepository;
    private final MutableLiveData<Result<String>> donationResult = new MutableLiveData<>();

    public DonationViewModel() {
        donationRepository = new DonationRepository();
    }

    public LiveData<Result<String>> getDonationResult() {
        return donationResult;
    }

    public void makeDonation(Donation donation) {
        Result<String> result = donationRepository.donate(donation);
        donationResult.setValue(result);
    }
}

