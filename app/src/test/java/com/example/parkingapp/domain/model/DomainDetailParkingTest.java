package com.example.parkingapp.domain.model;

import net.bytebuddy.build.ToStringPlugin;

import org.junit.Test;

import static org.junit.Assert.*;

public class DomainDetailParkingTest {

    @Test
    public void validate_Construct_WithParams (){
        DomainDetailParking domainDetailParking = new DomainDetailParking(10);
        assertTrue(domainDetailParking.getNumberMinuts() == 10);
    }

    @Test
    public void validate_SetCost (){
        DomainDetailParking domainDetailParking = new DomainDetailParking(10);
        domainDetailParking.setCost(10);
        assertTrue(domainDetailParking.getCost() == 10);
    }


}