package com.example.parkingapp.data;

import android.content.Context;

import com.example.parkingapp.BaseApplication;
import com.example.parkingapp.data.database.ParkingSpace;


import java.util.Date;
import java.util.List;

public class SpaceParkingRepository {



    public SpaceParkingRepository() {
    }

    public boolean updateParkingSpace (int id, Date date){
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        try {
            db.parkingSpaceDao().setUpdateStateParking(true, id, date);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public int getFree (){
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        return db.parkingSpaceDao().getSpaceFree();
    }

    public ParkingSpace getTime (String plate){
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
         return db.parkingSpaceDao().getTime(plate);
    }
    public ParkingSpace getTimeCar (String plate){
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        return db.parkingSpaceDao().getTimeCar(plate);
    }

    public void freeSpace(int fk_space) {
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        db.parkingSpaceDao().setUpdateStateParking(false, fk_space, null);
    }
}
