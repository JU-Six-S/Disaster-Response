package com.jusixs.ndrs.data.repository;

import com.jusixs.ndrs.data.model.Donation;
import com.jusixs.ndrs.util.Result;

/**
 * Repository class for handling donation-related operations in the National Disaster Response System (NDRS).
 * Provides functionality to process and validate donation transactions.
 *
 * <p>Author: Sadman</p>
 */
public class DonationRepository {

    /**
     * Processes a donation and returns the result of the operation.
     * Validates the donation amount to ensure it is greater than 0.
     *
     * @param donation the {@link Donation} object containing details of the donation
     * @return a {@link Result} containing a success message if the donation is valid,
     *         or an error message if the donation amount is invalid
     */
    public Result<String> donate(Donation donation) {
        // Simulate donation operation with dummy data
        if (donation.getAmount() > 0) {
            return Result.success("Donation successful!");
        } else {
            return Result.failure("Donation amount must be greater than 0.");
        }
    }
}
