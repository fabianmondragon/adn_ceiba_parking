package com.example.parkingapp.data.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.parkingapp.data.database.entity.ParkingSpaceEntitiy;

import java.util.Date;
import java.util.List;

@Dao
public interface ParkingSpaceDao {

    @Query("SELECT * FROM parking_space")
    List<ParkingSpaceEntitiy> getAll();

    @Insert
    void insertParkingAll(List<ParkingSpaceEntitiy> parkingSpaceEntitiy);

    @Query("UPDATE parking_space SET state =:stateParman, date =:date WHERE parking_space_id =:idPaquingSpace")
    void setUpdateStateParking(boolean stateParman, int idPaquingSpace, Date date);

    @Query("Select * FROM parking_space where parking_space.state = 0 LIMIT 1")
    int getFreeSpace();

    @Query("Select parking_space_id, date, state, fk_parking From parking_space LEFT JOIN moto ON parking_space_id = moto.fk_parking_space WHERE moto.plate_id =:plate")
    ParkingSpaceEntitiy getTime(String plate);

    @Query("Select parking_space_id, date, state, fk_parking From parking_space LEFT JOIN car ON parking_space_id = car.fk_parking_space WHERE car.plate_id =:plate")
    ParkingSpaceEntitiy getTimeCar(String plate);

    @Query("UPDATE parking_space set state = :b")
    void setUpdateAllStateParking(boolean b);

    @Query("Select * FROM parking_space WHERE parking_space_id = :id")
    ParkingSpaceEntitiy getOneParkingSpace(int id);
}
