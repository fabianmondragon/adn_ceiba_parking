package com.example.parkingapp.data;

import android.content.Context;

import com.example.parkingapp.BaseApplication;
import com.example.parkingapp.data.database.ParkingSpace;

import java.util.List;

public class SpaceParkingRepository {



    public SpaceParkingRepository() {
    }

    public boolean updateParkingSpace (int id){
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        try {
            db.parkingSpaceDao().setUpdateStateParking(true, id);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public int getFree (){
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        return db.parkingSpaceDao().getSpaceFree();
    }
}
