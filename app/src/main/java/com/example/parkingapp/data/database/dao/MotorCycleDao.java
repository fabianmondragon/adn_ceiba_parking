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

    @Query("SELECT * FROM MotorcycleEntity")
    LiveData<List<MotorcycleEntity>> getAll();

    @Query("SELECT * FROM MotorcycleEntity")
    List<MotorcycleEntity> getAllMotorcycle();

    @Query("SELECT * FROM MotorcycleEntity WHERE MotorcycleEntity.plate_id = :plateId")
    MotorcycleEntity getMotoCycle(String plateId);

    @Query("DELETE FROM MotorcycleEntity WHERE MotorcycleEntity.plate_id = :plate")
    void delete(String plate);

    @Query("DELETE FROM MotorcycleEntity")
    void deleteAll();
}
