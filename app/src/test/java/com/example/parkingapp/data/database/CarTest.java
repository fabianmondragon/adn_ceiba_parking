package com.example.parkingapp.data.database;

import com.example.parkingapp.data.database.entity.CarEntity;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CarTest {

    private CarEntity carEntity;

    @Test
    public void validateConstruct_withTwoParams() {
        CarEntity carEntity = new CarEntity("lmo21", 1);
        assertTrue(carEntity.getPlateID().equals("lmo21"));
    }

    @Test
    public void validateSet_Plate() {
        CarEntity carEntity = new CarEntity("lmo21", 1);
        carEntity.setPlateID("l");
        assertTrue(carEntity.getPlateID().equals("l"));
    }

    @Test
    public void validateSet_FKParkingSpace() {
        CarEntity carEntity = new CarEntity("lmo21", 1);
        carEntity.setFkParkingSpace(1);
        assertTrue(carEntity.getFkParkingSpace() == 1);
    }

}