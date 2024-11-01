package com.jusixs.ndrs;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ModelTest {

    private Model model;

    @Before
    public void setUp() {
        model = new Model();
    }

    @Test
    public void testGetCoastGuardNumber() {
        String expected = "108";
        String actual = model.getCoastGuardNumber();
        assertEquals("Coast Guard number should be '108'", expected, actual);
    }

    @Test
    public void testGetRedCrescentNumber() {
        String expected = "+88-02-9330188";
        String actual = model.getRedCrescentNumber();
        assertEquals("Red Crescent number should be '+88-02-9330188'", expected, actual);
    }

    @Test
    public void testGetNationalEmergencyNumber() {
        String expected = "999";
        String actual = model.getNationalEmergencyNumber();
        assertEquals("National Emergency number should be '999'", expected, actual);
    }

    @Test
    public void testGetAmbulanceNumber() {
        String expected = "199";
        String actual = model.getAmbulanceNumber();
        assertEquals("Ambulance number should be '199'", expected, actual);
    }

    @Test
    public void testGetChildHelplineNumber() {
        String expected = "1098";
        String actual = model.getChildHelplineNumber();
        assertEquals("Child Helpline number should be '1098'", expected, actual);
    }
}
