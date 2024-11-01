/**
 * Model class containing emergency contact numbers for various services.
 * <p>
 * This class provides getter methods to retrieve contact numbers for emergency services
 * such as the Coast Guard, Red Crescent, National Emergency, Ambulance, Child Helpline, RAB,
 * Flood Forecasting, Fire service, and Police Headquarters.
 * </p>
 * <p>
 * Project: National Disaster Response System (NDRS)
 * Developed by: Sifat
 * </p>
 */
package com.jusixs.ndrs;

public class Model {

    private String coastGuardNumber = "108";
    private String redCrescentNumber = "+88-02-9330188";
    private String nationalEmergencyNumber = "999";
    private String ambulanceNumber = "199";
    private String childHelplineNumber = "1098";
    private String rabNumber = "101";
    private String floodForecastingNumber = "+88-02-8141188";
    private String fireNumber = "199";
    private String polHeadNumber = "+88-02-55100000";

    /**
     * Gets the Coast Guard emergency contact number.
     *
     * @return the Coast Guard contact number.
     */
    public String getCoastGuardNumber() {
        return coastGuardNumber;
    }

    /**
     * Gets the Red Crescent emergency contact number.
     *
     * @return the Red Crescent contact number.
     */
    public String getRedCrescentNumber() {
        return redCrescentNumber;
    }

    /**
     * Gets the National Emergency contact number.
     *
     * @return the National Emergency contact number.
     */
    public String getNationalEmergencyNumber() {
        return nationalEmergencyNumber;
    }

    /**
     * Gets the Ambulance emergency contact number.
     *
     * @return the Ambulance contact number.
     */
    public String getAmbulanceNumber() {
        return ambulanceNumber;
    }

    /**
     * Gets the Child Helpline contact number.
     *
     * @return the Child Helpline contact number.
     */
    public String getChildHelplineNumber() {
        return childHelplineNumber;
    }

    /**
     * Gets the RAB emergency contact number.
     *
     * @return the RAB contact number.
     */
    public String getRabNumber() {
        return rabNumber;
    }

    /**
     * Gets the Flood Forecasting emergency contact number.
     *
     * @return the Flood Forecasting contact number.
     */
    public String getFloodForecastingNumber() {
        return floodForecastingNumber;
    }

    /**
     * Gets the Fire service emergency contact number.
     *
     * @return the Fire service contact number.
     */
    public String getFireNumber() {
        return fireNumber;
    }

    /**
     * Gets the Police Headquarters contact number.
     *
     * @return the Police Headquarters contact number.
     */
    public String getPoliceHeadNumber() {
        return polHeadNumber;
    }
}
