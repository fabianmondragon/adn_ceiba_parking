package com.example.parkingapp.data.repository;

import com.example.parkingapp.BaseApplication;

import java.util.Date;

public class ParkingSpaceRepositoryImpl implements ParkingSpaceRepository {

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
        return db.parkingSpaceDao().getTime(plate).getStartOcupation();
    }

    public Date getTimeCar(String plate) {
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        return db.parkingSpaceDao().getTimeCar(plate).getStartOcupation();
    }

    public void freeSpace(int fk_space) {
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        db.parkingSpaceDao().setUpdateStateParking(false, fk_space, null);
    }

}
