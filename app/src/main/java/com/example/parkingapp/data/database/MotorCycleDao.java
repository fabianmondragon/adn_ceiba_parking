package com.example.parkingapp.data.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface MotorCycleDao {
    @Insert
    void insertMotorcycle(Motorcycle motorcycle);

    @Query("SELECT * FROM moto")
    LiveData<List<Motorcycle>> getAll();

    @Query("SELECT * FROM moto")
    List<Motorcycle> getAllMotorcycle();

    @Query("SELECT * FROM moto WHERE moto.plate_id = :plateId")
    Motorcycle getMotoCycle(String plateId);

    @Query("DELETE FROM moto WHERE moto.plate_id = :plate")
    void delete(String plate);

    @Query("DELETE FROM moto")
    void deleteAll();
}
