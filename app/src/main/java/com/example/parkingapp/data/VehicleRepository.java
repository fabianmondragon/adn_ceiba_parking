package com.example.parkingapp.data;

import com.example.parkingapp.BaseApplication;
import com.example.parkingapp.data.database.Car;
import com.example.parkingapp.data.database.Motorcycle;
import com.example.parkingapp.data.database.ParkingSpace;

import java.util.List;

public class VehicleRepository {

    public List<Motorcycle> getListMotorCycle (){
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        try{
            return db.motorCycleDao().getAllMotorcycle();
        }catch (Exception e){
            return null;
        }
    }
    public List<Car> getListCar (){
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        try{
            return db.carDao().getAll();
        }catch (Exception e){
            return null;
        }
    }

    public boolean setCar (Car car){
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        try {
            db.carDao().insertCar(car);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public boolean setMotorcycle (Motorcycle motorcycle){
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        try {
            db.motorCycleDao().insertMotorcycle(motorcycle);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
