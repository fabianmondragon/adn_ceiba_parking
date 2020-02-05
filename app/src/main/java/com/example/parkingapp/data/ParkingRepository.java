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

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ParkingRepository {

    @Inject
    public ParkingRepository() {
    }

    public void registerCar (final Car car){


        final CeibaDataBase db = getInstanceDataBase();

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                db.carDao().insertCar(car);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
            }
        }.execute();
    }

    public void getCar() {
        final CeibaDataBase db = Room.databaseBuilder(BaseApplication.getAppContext(),
                CeibaDataBase.class, "database-parkinga.db").build();

        //  List<Car> carlist = db.carDao().getAll();


        new AsyncTask<Void, Void, List<Car>>() {
            @Override
            protected List<Car> doInBackground(Void... voids) {
                return db.carDao().getAll();

            }

            @Override
            protected void onPostExecute(List<Car> aVoid) {
                super.onPostExecute(aVoid);
            }
        }.execute();
    }

    //managment Motorcycle


    public void registerMotorcycle(final Motorcycle motorcycle) {
        final CeibaDataBase db = getInstanceDataBase();
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                db.motorCycleDao().insertMotorcycle(motorcycle);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
            }
        }.execute();
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

        final CeibaDataBase db =  getInstanceDataBase();
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


}
