package com.example.parkingapp.data.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;


@Dao
public interface ParkingDao {
    @Query("SELECT * FROM paking")
    List<Parking> getAll();

    @Insert
    void inserParking(Parking parking);
}
