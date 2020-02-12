package com.example.parkingapp.domain.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class DomainParkingTest {
    @Test
    public void validate_ConstructWitParmas (){
        DomainParking domainParking = new DomainParking(5,6);
        assertTrue(domainParking.getNumMotorcycle() == 6);
    }
    @Test
    public void validate_ConstructWitParmas_getNumberCars (){
        DomainParking domainParking = new DomainParking(5,6);
        assertTrue(domainParking.getNumCars() == 5);
    }


}