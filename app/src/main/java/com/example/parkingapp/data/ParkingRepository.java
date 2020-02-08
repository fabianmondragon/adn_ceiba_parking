package com.example.parkingapp.data;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.parkingapp.BaseApplication;
import com.example.parkingapp.data.database.Motorcycle;
import com.example.parkingapp.data.database.Parking;
import com.example.parkingapp.data.database.ParkingSpace;

import java.util.List;

public class ParkingRepository {


    private CeibaDataBase cb;
    private ModelParking modelParking;
    public MutableLiveData<String> plateMoto = new MutableLiveData();
    public MutableLiveData<String> plateCar = new MutableLiveData();
    public MutableLiveData<String> cilindrajeMoto = new MutableLiveData();


    public ParkingRepository() {
        modelParking = new ModelParking();
        cb = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
    }

    public void registerCar (String plate){

    }

    public List<Parking> getParking() {
        cb = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        return cb.parkingDao().getAllParkinList();
    }


    public void fillDataBase() {

    }
}
