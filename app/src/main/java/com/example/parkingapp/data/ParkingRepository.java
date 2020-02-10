package com.example.parkingapp.data;


import com.example.parkingapp.BaseApplication;
import com.example.parkingapp.data.database.Parking;
import java.util.List;

public class ParkingRepository {

    private CeibaDataBase cb;

    public ParkingRepository() {
        cb = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
    }

    public List<Parking> getParking() {
        cb = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        return cb.parkingDao().getAllParkinList();
    }

}
