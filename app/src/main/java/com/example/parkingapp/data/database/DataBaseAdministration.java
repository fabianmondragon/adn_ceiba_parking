package com.example.parkingapp.data.database;

import android.util.Log;

import com.example.parkingapp.BaseApplication;
import com.example.parkingapp.data.database.entity.CilindrajeRulesEntity;
import com.example.parkingapp.data.database.entity.ParkingEntity;
import com.example.parkingapp.data.database.entity.ParkingSpaceEntitiy;
import com.example.parkingapp.data.database.entity.PlateRulesEntity;
import com.example.parkingapp.data.database.entity.TariffEntity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class DataBaseAdministration {

    @Inject
    public DataBaseAdministration() {
        ((BaseApplication)(BaseApplication.getAppContext().getApplicationContext())).getAppComponent().inject(this);
    }

    public ParkingEntity prepareParking(){
        return  new ParkingEntity(20, 10);
    }

    public PlateRulesEntity preparePlatRules(){
        return  new PlateRulesEntity("b", true);
    }

    public TariffEntity prepareTariff(){
        return new TariffEntity(1000.0, 500.0, 8000.0, 4000.0, 2000.0);
    }

    public CilindrajeRulesEntity prepareCylindrical(){
        return new CilindrajeRulesEntity(150, 1);

    }

    public List<ParkingSpaceEntitiy> prepareParkingSpace() {
        final List<ParkingSpaceEntitiy> parkingSpaceEntityList = new ArrayList();
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        return parkingSpaceEntityList;
    }
}
