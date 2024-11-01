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

    private static final String COAST_GUARD_NUMBER = "108";
    private static final String RED_CRESCENT_NUMBER = "+88-02-9330188";
    private static final String NATIONAL_EMERGENCY_NUMBER = "999";
    private static final String AMBULANCE_NUMBER = "199";
    private static final String CHILD_HELPLINE_NUMBER = "1098";
    private static final String RAB_NUMBER = "101";
    private static final String FLOOD_FORECASTING_NUMBER = "+88-02-8141188";
    private static final String FIRE_NUMBER = "199";
    private static final String POLICE_HEAD_NUMBER = "+88-02-55100000";

    /**
     * Gets the Coast Guard emergency contact number.
     *
     * @return the Coast Guard contact number.
     */
    public String getCoastGuardNumber() {
        return COAST_GUARD_NUMBER;
    }

    /**
     * Gets the Red Crescent emergency contact number.
     *
     * @return the Red Crescent contact number.
     */
    public String getRedCrescentNumber() {
        return RED_CRESCENT_NUMBER;
    }

    /**
     * Gets the National Emergency contact number.
     *
     * @return the National Emergency contact number.
     */
    public String getNationalEmergencyNumber() {
        return NATIONAL_EMERGENCY_NUMBER;
    }

    /**
     * Gets the Ambulance emergency contact number.
     *
     * @return the Ambulance contact number.
     */
    public String getAmbulanceNumber() {
        return AMBULANCE_NUMBER;
    }

    /**
     * Gets the Child Helpline contact number.
     *
     * @return the Child Helpline contact number.
     */
    public String getChildHelplineNumber() {
        return CHILD_HELPLINE_NUMBER;
    }

    /**
     * Gets the RAB emergency contact number.
     *
     * @return the RAB contact number.
     */
    public String getRabNumber() {
        return RAB_NUMBER;
    }

    /**
     * Gets the Flood Forecasting emergency contact number.
     *
     * @return the Flood Forecasting contact number.
     */
    public String getFloodForecastingNumber() {
        return FLOOD_FORECASTING_NUMBER;
    }

    /**
     * Gets the Fire service emergency contact number.
     *
     * @return the Fire service contact number.
     */
    public String getFireNumber() {
        return FIRE_NUMBER;
    }

    /**
     * Gets the Police Headquarters contact number.
     *
     * @return the Police Headquarters contact number.
     */
    public String getPoliceHeadNumber() {
        return POLICE_HEAD_NUMBER;
    }
}
