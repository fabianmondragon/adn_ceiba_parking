package com.example.parkingapp.data.database;

import com.example.parkingapp.data.database.entity.ParkingEntity;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ParkingEntityTest {

    @Test
    public void validateConstruct_WihtParmas() {
        ParkingEntity parkingEntity = new ParkingEntity(10, 5);
        assertTrue(parkingEntity.getNumberCar() == 10);
        assertTrue(parkingEntity.getNumberMotorcycle() == 5);
    }

    @Test
    public void validateSetNumberCar_WihtParmas() {
        ParkingEntity parkingEntity = new ParkingEntity(10, 5);
        parkingEntity.setNumberCar(20);
        assertTrue(parkingEntity.getNumberCar() == 20);
    }

    @Test
    public void validateSetNumberMotos_WihtParmas() {
        ParkingEntity parkingEntity = new ParkingEntity(10, 5);
        parkingEntity.setNumberMotorcycle(1);
        assertTrue(parkingEntity.getNumberMotorcycle() == 1);
    }

}