package com.example.parkingapp.data.database;

import com.example.parkingapp.data.database.entity.MotorcycleEntity;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MotorcycleEntityTest {

    @Test
    public void validateConstruct_MOtorcycle_WithParamsn() {
        MotorcycleEntity motorcycleEntity = new MotorcycleEntity("lmo", 500, 1);
        assertTrue(motorcycleEntity.getPlateID().equals("lmo"));
        assertTrue(motorcycleEntity.getCilindraje() == 500);
        assertTrue(motorcycleEntity.getFkParkingSpace() == 1);
    }

    @Test
    public void validateSetCilindraje_MOtorcycle_WithParamsn() {
        MotorcycleEntity motorcycleEntity = new MotorcycleEntity("lmo", 500, 1);
        motorcycleEntity.setCilindraje(600);
        assertTrue(motorcycleEntity.getCilindraje() == 600);
    }

    @Test
    public void validateSetPlate_MOtorcycle_WithParamsn() {
        MotorcycleEntity motorcycleEntity = new MotorcycleEntity("lmo", 500, 1);
        motorcycleEntity.setPlateID("l");
        assertTrue(motorcycleEntity.getPlateID().equals("l"));
    }

    @Test
    public void validateSetFkParking_MOtorcycle_WithParamsn() {
        MotorcycleEntity motorcycleEntity = new MotorcycleEntity("lmo", 500, 1);
        motorcycleEntity.setFkParkingSpace(0);
        assertTrue(motorcycleEntity.getFkParkingSpace() == 0);
    }
}