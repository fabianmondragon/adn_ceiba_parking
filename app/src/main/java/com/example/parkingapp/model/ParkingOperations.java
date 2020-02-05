package com.example.parkingapp.model;

import android.os.AsyncTask;

import androidx.room.Room;

import com.example.parkingapp.data.CeibaDataBase;
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

public class ParkingOperations {


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

    public void  fillDataBase(final Parking parking, final CilindrajeRules cilindrajeRules, final List<ParkingSpace> parkingSpaceList, final Tariff tariff, final PlateRules plateRules){
        final CeibaDataBase db =  getInstanceDataBase();
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                if (db.parkingDao().getAll().size()==0) {
                    db.parkingDao().inserParking(parking);
                    db.parkingSpaceDao().insertParkingAll(parkingSpaceList);
                    db.cilindrajeRulesDao().insertCilindrajeRules(cilindrajeRules);
                    db.tariffDao().insertTarif(tariff);
                    db.plateRulesDao().insetPlateRulse(plateRules);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
            }
        }.execute();

    }
}
