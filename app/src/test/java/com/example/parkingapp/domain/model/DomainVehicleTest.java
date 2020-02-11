package com.example.parkingapp.domain.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class DomainVehicleTest {

    @Test
    public void valid_Constructor_With2Params (){
        DomainVehicle domainVehicle = new DomainVehicle("100", 2);
        assertTrue(domainVehicle.getType() == 2);
    }
    @Test
    public void valid_Constructor_With3Params (){
        DomainVehicle domainVehicle = new DomainVehicle("100", 160, 1);
        assertTrue(domainVehicle.getPlate().equals("100") );
        assertTrue(domainVehicle.getCilindraje() == 160);
        assertTrue(domainVehicle.getType() == 1);
    }

    @Test
    public void valid_Setter_With3Params (){
        DomainVehicle domainVehicle = new DomainVehicle("100", 160, 1);
        domainVehicle.setCilindraje(100);
        domainVehicle.setPlate("lmo21");
        domainVehicle.setFsetFkSpace(1);
        assertTrue(domainVehicle.getPlate().equals("lmo21") );
        assertTrue(domainVehicle.getCilindraje() == 100);
        assertTrue(domainVehicle.getFkSpace() == 1);
    }


}