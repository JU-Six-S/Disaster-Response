package com.jusixs.ndrs.data.repository;

import com.jusixs.ndrs.data.model.Donation;
import com.jusixs.ndrs.util.Result;

public class DonationRepository {
    public Result<String> donate(Donation donation) {
        // Simulate donation operation with dummy data
        if (donation.getAmount() > 0) {
            return Result.success("Donation successful!");
        } else {
            return Result.failure("Donation amount must be greater than 0.");
        }
    }
}
