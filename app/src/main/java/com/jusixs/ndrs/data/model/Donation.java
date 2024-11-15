package com.jusixs.ndrs.data.model;

/**
 * Represents a donation made in the National Disaster Response System (NDRS).
 * This class holds information about the donor, the donation amount, the payment method used,
 * and the donor's country.
 *
 * <p>Author: Sadman</p>
 */
public class Donation {
    private String donorName;
    private double amount;
    private String paymentMethod;
    private String country;

    /**
     * Constructs a new {@code Donation} instance with the specified donor name, amount,
     * payment method, and country.
     *
     * @param donorName     the name of the donor making the donation
     * @param amount        the amount of the donation
     * @param paymentMethod the payment method used for the donation (e.g., bKash, Nagad)
     * @param country       the country of the donor
     */
    public Donation(String donorName, double amount, String paymentMethod, String country) {
        this.donorName = donorName;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.country = country;
    }

    /**
     * Gets the name of the donor.
     *
     * @return the donor's name
     */
    public String getDonorName() {
        return donorName;
    }

    /**
     * Sets the name of the donor.
     *
     * @param donorName the donor's name to set
     */
    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    /**
     * Gets the amount of the donation.
     *
     * @return the donation amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the amount of the donation.
     *
     * @param amount the donation amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Gets the payment method used for the donation.
     *
     * @return the payment method (e.g., bKash, Nagad)
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Sets the payment method used for the donation.
     *
     * @param paymentMethod the payment method to set (e.g., bKash, Nagad)
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * Gets the country of the donor.
     *
     * @return the donor's country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country of the donor.
     *
     * @param country the donor's country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }
}
