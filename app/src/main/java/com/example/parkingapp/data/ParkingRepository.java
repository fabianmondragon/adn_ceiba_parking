package com.example.parkingapp.data;

import android.os.AsyncTask;

import androidx.room.Room;

import com.example.parkingapp.data.database.Car;
import com.example.parkingapp.data.database.CilindrajeRules;
import com.example.parkingapp.data.database.Motorcycle;
import com.example.parkingapp.data.database.Parking;
import com.example.parkingapp.data.database.ParkingSpace;
import com.example.parkingapp.data.database.PlateRules;
import com.example.parkingapp.data.database.Tariff;
import com.example.parkingapp.di.BaseApplication;
import com.example.parkingapp.model.ParkingOperations;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ParkingRepository {

    @Inject
    public ParkingRepository() {
    }

    @Inject
    ParkingOperations parkingOperations;

    public void registerCar (final Car car){



    }

    public void getCar() {

    }

    //managment Motorcycle


    public void registerMotorcycle(final Motorcycle motorcycle) {

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

        final Tariff tariff = new Tariff(1000.0, 500.0, 8000.0,4000.0);
        final PlateRules plateRules = new PlateRules("b", true );
        parkingOperations.fillDataBase(parking, cilindrajeRules, parkingSpaceList, tariff, plateRules);
    }


}
