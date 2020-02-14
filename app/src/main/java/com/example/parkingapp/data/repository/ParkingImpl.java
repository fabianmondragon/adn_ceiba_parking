package com.example.parkingapp.data.repository;


import com.example.parkingapp.BaseApplication;
import com.example.parkingapp.data.database.entity.ParkingEntity;

import java.util.List;

public class ParkingImpl implements ParkingRepository {

    private CeibaDataBase cb;

    public ParkingImpl() {
        cb = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
    }

    public List<ParkingEntity> getParking() {
        cb = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        return cb.parkingDao().getAllParkinList();
    }

}
