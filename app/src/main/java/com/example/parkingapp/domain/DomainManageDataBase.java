package com.example.parkingapp.domain;

import android.app.Application;
import android.os.AsyncTask;

import com.example.parkingapp.BaseApplication;
import com.example.parkingapp.data.CeibaDataBase;
import com.example.parkingapp.data.ManagmentDataBaseRepository;
import com.example.parkingapp.data.database.CilindrajeRules;
import com.example.parkingapp.data.database.Parking;
import com.example.parkingapp.data.database.ParkingSpace;
import com.example.parkingapp.data.database.PlateRules;
import com.example.parkingapp.data.database.Tariff;

import java.util.ArrayList;
import java.util.List;

public class DomainManageDataBase {
    ManagmentDataBaseRepository managmentDataBaseRepository;
    public DomainManageDataBase() {

        managmentDataBaseRepository = new ManagmentDataBaseRepository();
    }

    public void  fillDataBase (){
        final Parking parking = new Parking(20,10);
        final CilindrajeRules cilindrajeRules = new CilindrajeRules(150, 1);
        final List<ParkingSpace> parkingSpaceList = new ArrayList() {{
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
        }};

        final Tariff tariff = new Tariff(1000.0, 500.0, 8000.0,4000.0, 2000.0);
        final PlateRules plateRules = new PlateRules("b", true );
        managmentDataBaseRepository.fillDataBase(parking, parkingSpaceList, cilindrajeRules, tariff, plateRules);

    }
    public void clenaDataBase(){

    }
}
