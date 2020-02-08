package com.example.parkingapp.data;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import androidx.room.Index;
import androidx.room.Room;
import com.example.parkingapp.BaseApplication;
import com.example.parkingapp.data.database.Car;
import com.example.parkingapp.data.database.CarCopia;
import com.example.parkingapp.data.database.CilindrajeRules;
import com.example.parkingapp.data.database.Motorcycle;
import com.example.parkingapp.data.database.Parking;
import com.example.parkingapp.data.database.ParkingSpace;
import com.example.parkingapp.data.database.PlateRules;
import com.example.parkingapp.data.database.Tariff;
import java.util.ArrayList;
import java.util.List;

public class ModelParking {

    LiveData<List<CarCopia>> listCarCopia;
    LiveData<List<Parking>> listPaking;
    LiveData<List<Motorcycle>> listMotorCycle;


    public ModelParking() {

    }

    public void registerCar (final Car car){
        CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
    }

    public void registerMotorcycle(String plateMoto, String cilindraje) {

    }




    public LiveData<List<Parking>> getParking() {
        return listPaking;
    }

    public LiveData<List<Motorcycle>> getMotorcycleAll() {
        return listMotorCycle;
    }
}
