package com.example.parkingapp.presentation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidationPresentationTest {
    ValidationPresentation validationPresentation;

    @Before
    public void config(){
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
    public void validateFieldCar_WithNullField_Test() {
        assertFalse(validationPresentation.validateFieldCar(null));
    }

    @Test
    public void validateFieldMotorcycle_WithInvalidField_Test() {
        assertFalse(validationPresentation.validateFieldCar(""));
    }

    @Test
    public void validateFieldMotorcycle_WithValidField_Test() {
        assertTrue(validationPresentation.validateFieldCar("A"));
    }

    @Test
    public void validateFieldMotorcycle_WithNullField_Test() {
        assertFalse(validationPresentation.validateFieldCar(null));
    }
}