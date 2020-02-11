package com.example.parkingapp.data.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface CarDao {

    @Query("SELECT * FROM car")
    List<Car> getAll();

    @Insert
    void insertCar(Car cars);

    @Query("SELECT * FROM car WHERE car.plate_id = :id")
    Car getCar(String id);

    @Query("DELETE FROM car WHERE car.plate_id = :plate")
    void delete(String plate);

    @Query("DELETE FROM car" )
    void deleteAll();
}
