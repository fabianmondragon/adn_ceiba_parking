package com.example.parkingapp.data.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MotorCycleDao {
    @Insert
   void insertMotorcycle(Motorcycle motorcycle);

    @Query("SELECT * FROM moto")
    List<Motorcycle> getAll();
}
