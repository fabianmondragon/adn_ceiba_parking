package com.example.parkingapp.data.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.parkingapp.data.database.entity.ParkingSpaceEntitiy;

import java.util.Date;
import java.util.List;

@Dao
public interface ParkingSpaceDao {

    @Query("SELECT * FROM ParkingSpaceEntitiy")
    List<ParkingSpaceEntitiy> getAll();

    @Insert
    void insertParkingAll(List<ParkingSpaceEntitiy> parkingSpaceEntitiy);

    @Query("UPDATE ParkingSpaceEntitiy SET state =:stateParman, date =:date WHERE parking_space_id =:idPaquingSpace")
    void setUpdateStateParking(boolean stateParman, int idPaquingSpace, Date date);

    @Query("Select * FROM ParkingSpaceEntitiy where ParkingSpaceEntitiy.state = 0 LIMIT 1")
    int getSpaceFree();

    @Query("Select parking_space_id, date, state, fk_parking From ParkingSpaceEntitiy LEFT JOIN MotorcycleEntity ON parking_space_id = MotorcycleEntity.fk_parking_space WHERE MotorcycleEntity.plate_id =:plate")
    ParkingSpaceEntitiy getTime(String plate);

    @Query("Select parking_space_id, date, state, fk_parking From ParkingSpaceEntitiy LEFT JOIN CarEntity ON parking_space_id = CarEntity.fk_parking_space WHERE CarEntity.plate_id =:plate")
    ParkingSpaceEntitiy getTimeCar(String plate);

    @Query("UPDATE ParkingSpaceEntitiy set state = :b")
    void setUpdateAllStateParking(boolean b);

    @Query("Select * FROM ParkingSpaceEntitiy WHERE parking_space_id = :id")
    ParkingSpaceEntitiy getOneParkingSpace(int id);
}
