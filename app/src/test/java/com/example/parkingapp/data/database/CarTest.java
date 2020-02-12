package com.example.parkingapp.data.database;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CarTest {

    private Car car;

    @Test
    public void validateConstruct_withTwoParams() {
        Car car = new Car("lmo21", 1);
        assertTrue(car.getPlateID().equals("lmo21"));
    }

    @Test
    public void validateSet_Plate() {
        Car car = new Car("lmo21", 1);
        car.setPlateID("l");
        assertTrue(car.getPlateID().equals("l"));
    }

    @Test
    public void validateSet_FKParkingSpace() {
        Car car = new Car("lmo21", 1);
        car.setFkParkingSpace(1);
        assertTrue(car.getFkParkingSpace() == 1);
    }

}