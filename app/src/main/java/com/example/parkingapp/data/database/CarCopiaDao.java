package com.example.parkingapp.data.database;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CarCopiaDao {

    @Query("SELECT * FROM car_copia")
    LiveData<List<CarCopia>> getAll();

    @Insert
    void insertCarCopia(CarCopia cars);

}
