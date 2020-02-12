package com.example.parkingapp.presentation;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CarPresentationTest {

    @Test
    public void validate_Constructor_WithParams() {
        CarPresentation carPresentation = new CarPresentation("LMO");
        assertTrue(carPresentation.getPlate().equals("LMO"));
    }

    @Test
    public void validate_setPlate_WithParams() {
        CarPresentation carPresentation = new CarPresentation("LMO");
        carPresentation.setPlate("L");
        assertTrue(carPresentation.getPlate().equals("L"));
    }


}