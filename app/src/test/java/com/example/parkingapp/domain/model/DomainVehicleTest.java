package com.example.parkingapp.domain.model;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DomainVehicleTest {

    @Test
    public void valid_Constructor_With2Params() {
        Domain domain = new Domain("100", 2);
        assertTrue(domain.getType() == 2);
    }

    @Test
    public void valid_Constructor_With3Params() {
        Domain domain = new Domain("100", 160, 1);
        assertTrue(domain.getPlate().equals("100"));
        assertTrue(domain.getCilindraje() == 160);
        assertTrue(domain.getType() == 1);
    }

    @Test
    public void valid_Setter_With3Params() {
        Domain domain = new Domain("100", 160, 1);
        domain.setCilindraje(100);
        domain.setPlate("lmo21");
        domain.setFsetFkSpace(1);
        assertTrue(domain.getPlate().equals("lmo21"));
        assertTrue(domain.getCilindraje() == 100);
        assertTrue(domain.getFkSpace() == 1);
    }


}