package com.jusixs.ndrs.ui.viewmodel;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;

import com.jusixs.ndrs.data.model.Donation;
import com.jusixs.ndrs.util.Result;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;

public class DonationViewModelTest {

    @Rule
    public InstantTaskExecutorRule rule = new InstantTaskExecutorRule();

    private DonationViewModel viewModel;

    @Mock
    private Observer<Result<String>> observer;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        viewModel = new DonationViewModel();
    }

    @Test
    public void testValidDonation() {
        Donation donation = new Donation("John Doe", 100.00, "bKash", "Bangladesh");
        viewModel.getDonationResult().observeForever(observer);
        viewModel.makeDonation(donation);

        Result<String> result = viewModel.getDonationResult().getValue();
        assertEquals(true, result.isSuccess());
    }

    @Test
    public void testInvalidDonationAmount() {
        Donation donation = new Donation("John Doe", -10.0, "bKash", "Bangladesh");
        viewModel.getDonationResult().observeForever(observer);
        viewModel.makeDonation(donation);

        Result<String> result = viewModel.getDonationResult().getValue();
        assertEquals(false, result.isSuccess());
        assertEquals("Donation amount must be greater than 0.", result.getErrorMessage());
    }

    @Test
    public void testEmptyDonorName() {
        Donation donation = new Donation("", 50.0, "bKash", "Bangladesh");
        viewModel.getDonationResult().observeForever(observer);
        viewModel.makeDonation(donation);

        Result<String> result = viewModel.getDonationResult().getValue();
        assertEquals(false, result.isSuccess());
        assertEquals("Donor name cannot be empty.", result.getErrorMessage());
    }

    @Test
    public void testInvalidPaymentMethod() {
        Donation donation = new Donation("John Doe", 50.0, "UnknownMethod", "Bangladesh");
        viewModel.getDonationResult().observeForever(observer);
        viewModel.makeDonation(donation);

        Result<String> result = viewModel.getDonationResult().getValue();
        assertEquals(false, result.isSuccess());
        assertEquals("Invalid payment method.", result.getErrorMessage());
    }

    @Test
    public void testEmptyCountryField() {
        Donation donation = new Donation("John Doe", 50.0, "bKash", "");
        viewModel.getDonationResult().observeForever(observer);
        viewModel.makeDonation(donation);

        Result<String> result = viewModel.getDonationResult().getValue();
        assertEquals(false, result.isSuccess());
        assertEquals("Country cannot be empty.", result.getErrorMessage());
    }

    @Test
    public void testWhitespaceInFields() {
        Donation donation = new Donation("  ", 50.0, "bKash", "   ");
        viewModel.getDonationResult().observeForever(observer);
        viewModel.makeDonation(donation);

        Result<String> result = viewModel.getDonationResult().getValue();
        assertEquals(false, result.isSuccess());
        assertEquals("Fields cannot contain only whitespace.", result.getErrorMessage());
    }

    @Test
    public void testMinimumValidAmount() {
        Donation donation = new Donation("John Doe", 0.01, "bKash", "Bangladesh");
        viewModel.getDonationResult().observeForever(observer);
        viewModel.makeDonation(donation);

        Result<String> result = viewModel.getDonationResult().getValue();
        assertEquals(true, result.isSuccess());
    }

    @Test
    public void testLargeDonationAmount() {
        Donation donation = new Donation("John Doe", 1000000.0, "bKash", "Bangladesh");
        viewModel.getDonationResult().observeForever(observer);
        viewModel.makeDonation(donation);

        Result<String> result = viewModel.getDonationResult().getValue();
        assertEquals(true, result.isSuccess());
    }

    @Test
    public void testNullDonation() {
        viewModel.getDonationResult().observeForever(observer);
        viewModel.makeDonation(null);

        Result<String> result = viewModel.getDonationResult().getValue();
        assertEquals(false, result.isSuccess());
        assertEquals("Donation details cannot be null.", result.getErrorMessage());
    }

    @Test
    public void testMultipleValidDonations() {
        Donation donation1 = new Donation("John Doe", 50.0, "bKash", "Bangladesh");
        Donation donation2 = new Donation("Jane Smith", 100.0, "Nagad", "USA");

        viewModel.getDonationResult().observeForever(observer);

        viewModel.makeDonation(donation1);
        Result<String> result1 = viewModel.getDonationResult().getValue();
        assertEquals(true, result1.isSuccess());

        viewModel.makeDonation(donation2);
        Result<String> result2 = viewModel.getDonationResult().getValue();
        assertEquals(true, result2.isSuccess());
    }

    @Test
    public void testDonationWithSpecialCharactersInName() {
        Donation donation = new Donation("John O'Doe-Smith", 50.0, "bKash", "Bangladesh");
        viewModel.getDonationResult().observeForever(observer);
        viewModel.makeDonation(donation);

        Result<String> result = viewModel.getDonationResult().getValue();
        assertEquals(true, result.isSuccess());
    }
}
