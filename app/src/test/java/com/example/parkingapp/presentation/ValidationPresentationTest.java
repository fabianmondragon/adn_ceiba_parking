package com.example.parkingapp.presentation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidationPresentationTest {
    ValidationPresentation validationPresentation;

    @Before
    public void config() {
        validationPresentation = new ValidationPresentation();
    }

    @Test
    public void validateFieldCar_WithInvalidField_Test() {
        assertFalse(validationPresentation.validateFieldCar(""));
    }

    @Test
    public void validateFieldCar_WithValidField_Test() {
        assertTrue(validationPresentation.validateFieldCar("A"));
    }


    @Test
    public void validateFieldMotorcycle_WithInvalidField_Test() {
        assertFalse(validationPresentation.validateFieldMotorcycle("", ""));
    }

    @Test
    public void validateFieldMotorcycle_WithValidField_Test() {
        assertTrue(validationPresentation.validateFieldMotorcycle("lmo", "100"));
    }


}