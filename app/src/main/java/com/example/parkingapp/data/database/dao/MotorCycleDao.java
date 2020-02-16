package com.example.parkingapp.data.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.parkingapp.data.database.entity.MotorcycleEntity;

import java.util.List;

@Dao
public interface MotorCycleDao {
    @Insert
    void insertMotorcycle(MotorcycleEntity motorcycleEntity);

    @Query("SELECT * FROM moto")
    LiveData<List<MotorcycleEntity>> getAll();

    @Query("SELECT * FROM moto")
    List<MotorcycleEntity> getAllMotorcycle();

    @Query("SELECT * FROM moto WHERE moto.plate_id = :plateId")
    MotorcycleEntity getMotoCycle(String plateId);

    @Query("DELETE FROM moto WHERE moto.plate_id = :plate")
    void delete(String plate);

    @Query("DELETE FROM moto")
    void deleteAll();
}
