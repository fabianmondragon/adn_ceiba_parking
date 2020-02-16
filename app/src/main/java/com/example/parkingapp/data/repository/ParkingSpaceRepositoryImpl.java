package com.example.parkingapp.data.repository;

import com.example.parkingapp.BaseApplication;
import com.example.parkingapp.data.database.entity.ParkingSpaceEntitiy;
import com.example.parkingapp.domain.model.ParkingSpace;

import java.util.Date;
import java.util.List;

public class ParkingSpaceRepositoryImpl implements ParkingSpaceRepository {

    ParkingSpaceEntitiy parkingSpaceEntitiy;
    ParkingSpace parkingSpace;

    public ParkingSpaceRepositoryImpl() {
    }

    public boolean updateParkingSpace(int id, Date date, boolean state) {
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        try {
            db.parkingSpaceDao().setUpdateStateParking(true, id, date);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public int getFreeSpace() {
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        return db.parkingSpaceDao().getFreeSpace();
    }

    public Date getTime(String plate) {
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        return  db.parkingSpaceDao().getTime(plate).getStartOcupation();
    }

    public Date getTimeCar(String plate) {
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        return db.parkingSpaceDao().getTimeCar(plate).getStartOcupation();
    }

    public void freeSpace(int fk_space) {
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        db.parkingSpaceDao().setUpdateStateParking(false, fk_space, null);
    }

    public List<ParkingSpaceRepository> getParkingSpace() {
        return null;
        /*final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        return db.parkingSpaceDao().getAll();*/
    }

    public ParkingSpaceRepository getOneParkingSpace(int id) {
        return null;
        /*final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        return db.parkingSpaceDao().getOneParkingSpace(id);*/
    }
}
