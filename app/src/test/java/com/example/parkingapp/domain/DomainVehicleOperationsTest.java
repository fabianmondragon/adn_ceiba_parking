package com.example.parkingapp.domain;

import com.example.parkingapp.domain.model.DomainVehicle;

import org.junit.Before;
import org.junit.Test;


public class DomainVehicleOperationsTest {
    private DomainVehicle domainVehicle;
    private DomainVehicleOperations domainVehicleOperations;

    @Before
    public void config() {

        //domainVehicle = new DomainVehicle("LMO21", 100, 1);
        //domainVehicleOperations = new DomainVehicleOperations();
    }

    @Test
    public void registerVehicle() {
       /* DomainRespond domainRespond = new DomainRespond();
        domainRespond.setMsg(Constant.REGISTER_SUCCESSFULL);
        domainRespond.setState(true);
        domainRespond.setTipeTransaction(Constant.SET_MOTORCYCLE);*/

        // Assert.assertEquals(domainRespond, domainVehicleOperations.registerVehicle(domainVehicle));
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