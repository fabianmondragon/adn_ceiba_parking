package com.example.parkingapp.presentation;

import com.example.parkingapp.domain.model.Validation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidationPresentationTest {
    Validation validationPresentation;

    @Before
    public void config() {
        validationPresentation = new Validation();
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
        assertFalse(validationPresentation.validateMotorcycleFields("", ""));
    }

    @Test
    public void validateFieldMotorcycle_WithValidField_Test() {
        assertTrue(validationPresentation.validateMotorcycleFields("lmo", "100"));
    }


}