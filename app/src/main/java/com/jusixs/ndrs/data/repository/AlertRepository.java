package com.jusixs.ndrs.data.repository;

import com.jusixs.ndrs.data.model.Alert;

public class AlertRepository {
    public Alert sendAlert(Alert alert) {
        // Here you would perform the network call or database operation.
        // For the purpose of TDD, we will mock this in tests.
        alert.setStatus("sent"); // Assuming the alert is successfully sent.
        return alert;
    }
}
