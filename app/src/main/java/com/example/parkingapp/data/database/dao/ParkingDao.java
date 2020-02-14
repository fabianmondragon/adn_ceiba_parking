package com.example.parkingapp.data.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.parkingapp.data.database.entity.ParkingEntity;

import java.util.List;


@Dao
public interface ParkingDao {
    @Query("SELECT * FROM ParkingEntity")
    LiveData<List<ParkingEntity>> getAll();

    @Insert
    void inserParking(ParkingEntity parkingEntity);

    @Query("SELECT * FROM ParkingEntity")
    List<ParkingEntity> getAllParkinList();
}
