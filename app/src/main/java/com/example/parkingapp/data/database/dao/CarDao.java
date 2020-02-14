package com.example.parkingapp.data.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.parkingapp.data.database.entity.CarEntity;

import java.util.List;

@Dao
public interface CarDao {

    @Query("SELECT * FROM CarEntity")
    List<CarEntity> getAll();

    @Insert
    void insertCar(CarEntity cars);

    @Query("SELECT * FROM CarEntity WHERE CarEntity.plate_id = :id")
    CarEntity getCar(String id);

    @Query("DELETE FROM CarEntity WHERE CarEntity.plate_id = :plate")
    void delete(String plate);

    @Query("DELETE FROM CarEntity")
    void deleteAll();
}
