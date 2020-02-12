package com.example.parkingapp.data.database;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MotorcycleTest {

    @Test
    public void validateConstruct_MOtorcycle_WithParamsn(){
        Motorcycle motorcycle = new Motorcycle("lmo", 500, 1);
        assertTrue (motorcycle.getPlateID().equals("lmo"));
        assertTrue (motorcycle.getCilindraje() == 500);
        assertTrue (motorcycle.getFkParkingSpace() ==1);
    }

    @Test
    public void validateSetCilindraje_MOtorcycle_WithParamsn(){
        Motorcycle motorcycle = new Motorcycle("lmo", 500, 1);
        motorcycle.setCilindraje(600);
        assertTrue (motorcycle.getCilindraje() == 600);
    }

    @Test
    public void validateSetPlate_MOtorcycle_WithParamsn(){
        Motorcycle motorcycle = new Motorcycle("lmo", 500, 1);
        motorcycle.setPlateID("l");
        assertTrue (motorcycle.getPlateID().equals("l"));
    }

    @Test
    public void validateSetFkParking_MOtorcycle_WithParamsn(){
        Motorcycle motorcycle = new Motorcycle("lmo", 500, 1);
        motorcycle.setFkParkingSpace(0);
        assertTrue (motorcycle.getFkParkingSpace() == 0);
    }
}