package com.example.parkingapp.domain;

import com.example.parkingapp.domain.services.VehicleOperations;

import org.junit.Before;
import org.junit.Test;


public class DomainVehicleOperationsTest {
    private Domain domain;
    private VehicleOperations vehicleOperations;

    @Before
    public void config() {

        //domain = new Domain("LMO21", 100, 1);
        //vehicleOperations = new VehicleOperations();
    }

    @Test
    public void registerVehicle() {
       /* DomainRespond domainRespond = new DomainRespond();
        domainRespond.setMsg(Constant.REGISTER_SUCCESSFULL);
        domainRespond.setState(true);
        domainRespond.setTransactionType(Constant.SET_MOTORCYCLE);*/

        // Assert.assertEquals(domainRespond, vehicleOperations.registerVehicle(domain));
    }

    @Test
    public void setRegisterListener() {
    }

    @Test
    public void respond() {
    }

    @Test
    public void checkoutVehicle() {
    }
}