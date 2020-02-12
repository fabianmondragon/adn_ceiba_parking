package com.example.parkingapp.domain;

import android.os.AsyncTask;

import com.example.parkingapp.TransactionResponse;
import com.example.parkingapp.data.ManagmentDataBaseRepository;
import com.example.parkingapp.data.RequestListener;
import com.example.parkingapp.data.VehicleRepository;
import com.example.parkingapp.data.database.Motorcycle;
import com.example.parkingapp.domain.model.DomainParking;
import com.example.parkingapp.domain.model.DomainRespond;
import com.example.parkingapp.domain.model.DomainVehicle;
import com.example.parkingapp.util.Constant;

import org.junit.Before;
import org.junit.Test;


public class DomainVehicleOperationsTest implements RequestListener {

    DomainVehicleOperations domainVehicleOperations;
    DomainVehicle domainVehicle;
    VehicleRepository vehicleRepository;
    DomainManageDataBase domainManageDataBase;
    ManagmentDataBaseRepository managmentDataBaseRepository;


    @Before
    public void config (){
        domainManageDataBase = new DomainManageDataBase();
        vehicleRepository = new VehicleRepository();
        domainVehicleOperations = new DomainVehicleOperations();

        domainVehicle = new DomainVehicle("lmo21", 100, 1);
        domainManageDataBase.fillDataBase();

    }

    @Test
    public void registerVehicule_Success (){
        domainVehicleOperations.setRegisterListener(this);
        domainVehicleOperations.registerVehicle(domainVehicle);
    }

    @Override
    public void respond(TransactionResponse repondTransaction) {

    }
}