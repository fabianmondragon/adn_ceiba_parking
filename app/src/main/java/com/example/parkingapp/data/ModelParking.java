package com.example.parkingapp.data;

import androidx.lifecycle.LiveData;

import com.example.parkingapp.data.database.Motorcycle;
import com.example.parkingapp.data.database.Parking;
import java.util.List;

public class ModelParking {

    LiveData<List<Parking>> listPaking;

    public ModelParking() {

    }

    public LiveData<List<Parking>> getParking() {
        return listPaking;
    }

}
