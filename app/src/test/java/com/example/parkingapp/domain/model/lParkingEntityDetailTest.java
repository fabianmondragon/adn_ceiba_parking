package com.example.parkingapp.domain.model;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class lParkingEntityDetailTest {

    @Test
    public void validate_Construct_WithParams() {
        lParkingDetail lParkingDetail = new lParkingDetail(10);
        assertTrue(lParkingDetail.getNumberMinuts() == 10);
    }

    @Test
    public void validate_SetCost() {
        lParkingDetail lParkingDetail = new lParkingDetail(10);
        lParkingDetail.setCost(10);
        assertTrue(lParkingDetail.getCost() == 10);
    }


}