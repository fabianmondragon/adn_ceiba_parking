package com.example.parkingapp.data.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


import java.util.Date;
import java.util.List;

@Dao
public interface ParkingSpaceDao {

    @Query("SELECT * FROM parking_space")
    List<ParkingSpace> getAll();

    @Insert
    void insertParkingAll(List<ParkingSpace> parkingSpace);

    @Query ("UPDATE parking_space SET state =:stateParman, date =:date WHERE parking_space_id =:idPaquingSpace")
    void setUpdateStateParking (boolean stateParman, int idPaquingSpace, Date date);

    @Query ("Select * FROM parking_space where parking_space.state = 0 LIMIT 1")
    int getSpaceFree ();

    @Query ("Select parking_space_id, date, state, fk_parking From parking_space LEFT JOIN moto ON parking_space_id = moto.fk_parking_space WHERE moto.plate_id =:plate")
    ParkingSpace getTime(String plate);

    @Query ("Select parking_space_id, date, state, fk_parking From parking_space LEFT JOIN car ON parking_space_id = car.fk_parking_space WHERE car.plate_id =:plate")
    ParkingSpace getTimeCar(String plate);
}
