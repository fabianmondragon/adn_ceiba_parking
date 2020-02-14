package com.example.parkingapp.data.database;

import com.example.parkingapp.data.database.entity.PlateRulesEntity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PlateRulesEntityTest {
    PlateRulesEntity plateRulesEntity;

    @Before
    public void config() {
        plateRulesEntity = new PlateRulesEntity("A", true);
        assertTrue(plateRulesEntity.getLetter_plate_rule().equals("A"));
        assertTrue(plateRulesEntity.getState() == true);
    }

    @Test
    public void validateGetAndSetter_PlateRulesId() {
        plateRulesEntity.setPlateRulesId(1);
        assertTrue(plateRulesEntity.getPlateRulesId() == 1);
    }

    @Test
    public void validateGetAndSetter_Letter() {
        plateRulesEntity.setLetter_plate_rule("B");

        assertTrue(plateRulesEntity.getLetter_plate_rule().equals("B"));
    }

    @Test
    public void validateGetAndSetter_State() {
        plateRulesEntity.setState(false);
        assertTrue(plateRulesEntity.getState() == false);
    }

}