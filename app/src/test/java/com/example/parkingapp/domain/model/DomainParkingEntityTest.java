package com.example.parkingapp.domain.model;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DomainParkingEntityTest {
    @Test
    public void validate_ConstructWitParmas() {
        Parking parking = new Parking(5, 6);
        assertTrue(parking.getNumMotorcycle() == 6);
    }

    @Test
    public void validate_ConstructWitParmas_getNumberCars() {
        Parking parking = new Parking(5, 6);
        assertTrue(parking.getNumCars() == 5);
    }


}