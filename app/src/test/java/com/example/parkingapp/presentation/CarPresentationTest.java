package com.example.parkingapp.presentation;

import com.example.parkingapp.domain.model.Car;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CarPresentationTest {

    @Test
    public void validate_Constructor_WithParams() {
        Car carPresentation = new Car("LMO");
        assertTrue(carPresentation.getPlate().equals("LMO"));
    }

    @Test
    public void validate_setPlate_WithParams() {
        Car carPresentation = new Car("LMO");
        carPresentation.setPlate("L");
        assertTrue(carPresentation.getPlate().equals("L"));
    }


}