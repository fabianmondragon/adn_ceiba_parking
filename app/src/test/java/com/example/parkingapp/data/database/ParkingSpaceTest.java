package com.example.parkingapp.data.database;

import com.example.parkingapp.data.ParkingRepository;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingSpaceTest {

    ParkingSpace parkingSpace;
    @Before
    public void config (){
        parkingSpace = new ParkingSpace(false, null, 1);
    }

    @Test
    public void validateConstruct_WihtParmas (){
        assertTrue(parkingSpace.isState()== false);
        assertTrue(parkingSpace.getStartOcupation()== null);
    }

    @Test
    public void validateSetParkingSpace (){
        parkingSpace.setParkingSpaceId(10);
        assertTrue(parkingSpace.getParkingSpaceId() == 10);
    }

    @Test
    public void validateSetParking (){
        parkingSpace.setParking(10);
        assertTrue(parkingSpace.getParking() == 10);
    }



}