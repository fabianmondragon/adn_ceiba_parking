package com.example.parkingapp.data.database;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PlateRulesTest {
    PlateRules plateRules;

    @Before
    public void config() {
        plateRules = new PlateRules("A", true);
        assertTrue(plateRules.getLetter_plate_rule().equals("A"));
        assertTrue(plateRules.getState() == true);
    }

    @Test
    public void validateGetAndSetter_PlateRulesId() {
        plateRules.setPlateRulesId(1);
        assertTrue(plateRules.getPlateRulesId() == 1);
    }

    @Test
    public void validateGetAndSetter_Letter() {
        plateRules.setLetter_plate_rule("B");

        assertTrue(plateRules.getLetter_plate_rule().equals("B"));
    }

    @Test
    public void validateGetAndSetter_State() {
        plateRules.setState(false);
        assertTrue(plateRules.getState() == false);
    }

}