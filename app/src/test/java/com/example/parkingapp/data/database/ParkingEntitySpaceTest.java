package com.example.parkingapp.data.database;

import com.example.parkingapp.data.database.entity.ParkingSpaceEntitiy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ParkingEntitySpaceTest {

    ParkingSpaceEntitiy parkingSpaceEntitiy;

    @Before
    public void config() {
        parkingSpaceEntitiy = new ParkingSpaceEntitiy(false, null, 1);
    }

    @Test
    public void validateConstruct_WihtParmas() {
        assertTrue(parkingSpaceEntitiy.isState() == false);
        assertTrue(parkingSpaceEntitiy.getStartOcupation() == null);
    }

    @Test
    public void validateSetParkingSpace() {
        parkingSpaceEntitiy.setParkingSpaceId(10);
        assertTrue(parkingSpaceEntitiy.getParkingSpaceId() == 10);
    }

    @Test
    public void validateSetParking() {
        parkingSpaceEntitiy.setParking(10);
        assertTrue(parkingSpaceEntitiy.getParking() == 10);
    }


}