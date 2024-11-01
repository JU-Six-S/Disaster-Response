package com.jusixs.ndrs;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class ModelTest {

    private Model model;

    // Constants for expected values
    private static final String COAST_GUARD_NUMBER = "108";
    private static final String RED_CRESCENT_NUMBER = "+88-02-9330188";
    private static final String NATIONAL_EMERGENCY_NUMBER = "999";
    private static final String AMBULANCE_NUMBER = "199";
    private static final String CHILD_HELPLINE_NUMBER = "1098";
    private static final String RAB_NUMBER = "101";
    private static final String FLOOD_FORECASTING_NUMBER = "+88-02-8141188";
    private static final String FIRE_NUMBER = "199";
    private static final String POLICE_HEADQUARTERS_NUMBER = "+88-02-55100000";

    @Before
    public void setUp() {
        model = new Model();
    }

    @Test
    public void testGetCoastGuardNumber() {
        assertEquals("Coast Guard number should be '108'", COAST_GUARD_NUMBER, model.getCoastGuardNumber());
    }

    @Test
    public void testGetRedCrescentNumber() {
        assertEquals("Red Crescent number should be '+88-02-9330188'", RED_CRESCENT_NUMBER, model.getRedCrescentNumber());
    }

    @Test
    public void testGetNationalEmergencyNumber() {
        assertEquals("National Emergency number should be '999'", NATIONAL_EMERGENCY_NUMBER, model.getNationalEmergencyNumber());
    }

    @Test
    public void testGetAmbulanceNumber() {
        assertEquals("Ambulance number should be '199'", AMBULANCE_NUMBER, model.getAmbulanceNumber());
    }

    @Test
    public void testGetChildHelplineNumber() {
        assertEquals("Child Helpline number should be '1098'", CHILD_HELPLINE_NUMBER, model.getChildHelplineNumber());
    }

    @Test
    public void testGetRabNumber() {
        assertEquals("RAB number should be '101'", RAB_NUMBER, model.getRabNumber());
    }

    @Test
    public void testGetFloodForecastingNumber() {
        assertEquals("Flood Forecasting number should be '+88-02-8141188'", FLOOD_FORECASTING_NUMBER, model.getFloodForecastingNumber());
    }

    @Test
    public void testGetFireNumber() {
        assertEquals("Fire number should be '199'", FIRE_NUMBER, model.getFireNumber());
    }

    @Test
    public void testGetPoliceHeadNumber() {
        assertEquals("Police Headquarters number should be '+88-02-55100000'", POLICE_HEADQUARTERS_NUMBER, model.getPoliceHeadNumber());
    }
}
