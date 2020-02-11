package com.example.parkingapp.presentation;

import com.example.parkingapp.data.database.Motorcycle;

import org.junit.Test;

import static org.junit.Assert.*;

public class MotorcyclePresentationTest {

    @Test
    public void validate_Constructor_WithParams() {
        MotorcyclePresentation motorcycle = new MotorcyclePresentation("lmo", 100);
        assertTrue(motorcycle.getPlate().equals("lmo"));
        assertTrue(motorcycle.getCilindraje() == 100);
    }

    @Test
    public void validate_Constructor_Secondary_WithParams() {
        MotorcyclePresentation motorcycle = new MotorcyclePresentation("lmo");
        assertTrue(motorcycle.getPlate().equals("lmo"));
    }

    @Test
    public void validate_SetCilindraje() {
        MotorcyclePresentation motorcycle = new MotorcyclePresentation("lmo", 100);
        motorcycle.setCilindraje(200);
        assertTrue(motorcycle.getCilindraje() == 200);
    }

    @Test
    public void validate_SetPlate() {
        MotorcyclePresentation motorcycle = new MotorcyclePresentation("lmo", 100);
        motorcycle.setPlate("AM5");
        assertTrue(motorcycle.getPlate().equals("AM5"));
    }

    @Test
    public void setPlate() {
    }

    @Test
    public void getCilindraje() {
    }

    @Test
    public void setCilindraje() {
    }
}