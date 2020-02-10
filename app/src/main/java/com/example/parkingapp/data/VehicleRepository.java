package com.example.parkingapp.data;

import com.example.parkingapp.BaseApplication;
import com.example.parkingapp.data.database.Car;
import com.example.parkingapp.data.database.Motorcycle;
import com.example.parkingapp.domain.model.DomainVehicle;

import java.util.List;

public class VehicleRepository {

    public List<Motorcycle> getListMotorCycle() {
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        try {
            return db.motorCycleDao().getAllMotorcycle();
        } catch (Exception e) {
            return null;
        }
    }

    public List<Car> getListCar() {
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        try {
            return db.carDao().getAll();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean setCar(Car car) {
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        try {
            db.carDao().insertCar(car);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean setMotorcycle(Motorcycle motorcycle) {
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        try {
            db.motorCycleDao().insertMotorcycle(motorcycle);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public Motorcycle getMotoCycle(String plateId) {
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        try {
            return db.motorCycleDao().getMotoCycle(plateId);
        } catch (Exception e) {

        }
        return null;
    }

    public void deleteMotorcycle(String plate) {
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        try {
            db.motorCycleDao().delete(plate);
        } catch (Exception e) {

        }
    }

    public Car getCar(String plate) {
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        try {
            return db.carDao().getCar(plate);
        } catch (Exception e) {

        }
        return null;
    }

    public void deleteCar(String plate) {
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        try {
            db.carDao().delete(plate);
        } catch (Exception e) {

        }
    }

}
