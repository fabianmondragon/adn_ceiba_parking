package com.example.parkingapp.data;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.parkingapp.data.database.Motorcycle;
import com.example.parkingapp.data.database.Parking;

import java.util.List;

public class ParkingRepository {

    private ModelParking modelParking;
    public MutableLiveData<String> plateMoto = new MutableLiveData();
    public MutableLiveData<String> plateCar = new MutableLiveData();
    public MutableLiveData<String> cilindrajeMoto = new MutableLiveData();

    public ParkingRepository(Application application) {
        modelParking = new ModelParking(application);
        modelParking.fillDataBase();
    }

    public void registerMotorcycle(String plateMOto, String cilindraje) {
        modelParking.registerMotorcycle(plateMOto, cilindraje);
    }

    public LiveData<List<Parking>> getParking() {
       return  modelParking.getParking();
    }

    public LiveData<List<Motorcycle>> getMotorcycleAll() {
        return modelParking.getMotorcycleAll();
    }
}
