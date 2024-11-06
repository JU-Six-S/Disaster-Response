package com.jusixs.ndrs.data.model;

public class Donation {
    private String donorName;
    private double amount;
    private String paymentMethod;
    private String country;

    public Donation(String donorName, double amount, String paymentMethod, String country) {
        this.donorName = donorName;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.country = country;
    }

    // Getters and Setters
    public String getDonorName() { return donorName; }
    public void setDonorName(String donorName) { this.donorName = donorName; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
}
