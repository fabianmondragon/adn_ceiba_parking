package com.example.parkingapp.data.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ParkingSpaceDao {

    @Query("SELECT * FROM parking_space")
    List<ParkingSpace> getAll();

    @Insert
    void insertParkingAll(List<ParkingSpace> parkingSpace);

    @Query ("UPDATE parking_space SET state =:stateParman WHERE parking_space_id =:idPaquingSpace")
    void setUpdateStateParking (boolean stateParman, int idPaquingSpace);
}
