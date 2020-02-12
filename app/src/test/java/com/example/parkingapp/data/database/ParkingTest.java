package com.example.parkingapp.data.database;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ParkingTest {

    @Test
    public void validateConstruct_WihtParmas() {
        Parking parking = new Parking(10, 5);
        assertTrue(parking.getNumberCar() == 10);
        assertTrue(parking.getNumberMoto() == 5);
    }

    @Test
    public void validateSetNumberCar_WihtParmas() {
        Parking parking = new Parking(10, 5);
        parking.setNumberCar(20);
        assertTrue(parking.getNumberCar() == 20);
    }

    @Test
    public void validateSetNumberMotos_WihtParmas() {
        Parking parking = new Parking(10, 5);
        parking.setNumberMoto(1);
        assertTrue(parking.getNumberMoto() == 1);
    }

}