package com.example.parkingapp.domain;

import com.example.parkingapp.TransactionResponse;
import com.example.parkingapp.data.repository.ManagmentDataBaseImpl;
import com.example.parkingapp.data.repository.VehicleRepositoryImpl;
import com.example.parkingapp.domain.services.DataBaseAdministration;
import com.example.parkingapp.domain.services.VehicleOperations;

import org.junit.Before;
import org.junit.Test;


public class DomainVehicleOperationsTest implements RequestListener {

    VehicleOperations vehicleOperations;
    Domain domain;
    VehicleRepositoryImpl vehicleRepositoryImpl;
    DataBaseAdministration dataBaseAdministration;
    ManagmentDataBaseImpl managmentDataBaseImpl;


    @Before
    public void config() {
        dataBaseAdministration = new DataBaseAdministration();
        vehicleRepositoryImpl = new VehicleRepositoryImpl();
        vehicleOperations = new VehicleOperations();

        domain = new Domain("lmo21", 100, 1);
        dataBaseAdministration.fillDataBase();

    }

    @Test
    public void registerVehicule_Success() {
        vehicleOperations.setRegisterListener(this);
        vehicleOperations.registerVehicle(domain);
    }

    @Override
    public void respond(TransactionResponse repondTransaction) {

    }
}