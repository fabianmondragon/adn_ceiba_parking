package com.example.parkingapp.data;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import com.example.parkingapp.BaseApplication;
import com.example.parkingapp.data.database.Car;
import com.example.parkingapp.data.database.CarCopia;
import com.example.parkingapp.data.database.CilindrajeRules;
import com.example.parkingapp.data.database.Motorcycle;
import com.example.parkingapp.data.database.Parking;
import com.example.parkingapp.data.database.ParkingSpace;
import com.example.parkingapp.data.database.PlateRules;
import com.example.parkingapp.data.database.Tariff;


import java.util.ArrayList;
import java.util.List;



public class ParkingRepository {


    LiveData<List<CarCopia>> listCarCopia;
    Application application;


    public ParkingRepository(Application application) {
        CeibaDataBase db = CeibaDataBase.getDatabase(application);
        listCarCopia = db.carDaoCopia().getAll();
        this.application = application;
    }

    public void registerCar (final Car car){


        CeibaDataBase db = CeibaDataBase.getDatabase(application);


    }

    public void getCar() {

    }

    //managment Motorcycle


    public void registerMotorcycle(final Motorcycle motorcycle) {

    }

    public CeibaDataBase getInstanceDataBase (){
        return  Room.databaseBuilder(BaseApplication.getAppContext(),
                CeibaDataBase.class, "database-parking.db").build();
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

        final CeibaDataBase db = CeibaDataBase.getDatabase(application);
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                db.parkingDao().inserParking(parking);
                db.parkingSpaceDao().insertParkingAll(parkingSpaceList);
                db.cilindrajeRulesDao().insertCilindrajeRules(cilindrajeRules);
                db.tariffDao().insertTarif(tariff);
                db.plateRulesDao().insetPlateRulse(plateRules);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
            }
        }.execute();

    }

    public void registerCarCopia(final CarCopia carCopia) {
        final CeibaDataBase db = CeibaDataBase.getDatabase(application);

        db.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                db.carDaoCopia().insertCarCopia(carCopia);
            }
        });


    }

    public LiveData<List<CarCopia>> getCarCopia(){
        return listCarCopia;
    }
}
