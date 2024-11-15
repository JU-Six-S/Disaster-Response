package com.jusixs.ndrs.data.repository;

import com.jusixs.ndrs.data.model.Alert;

public class AlertRepository {
    public Alert sendAlert(Alert alert) {

        alert.setStatus("sent");
        return alert;
    }
}
