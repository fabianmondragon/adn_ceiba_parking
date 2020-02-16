package com.example.parkingapp.data.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "paking")
public class ParkingEntity {

    @PrimaryKey
    @ColumnInfo(name = "paking_id")
    private int parkinId;

    @ColumnInfo(name = "number_car")
    private int numberCar;

    @ColumnInfo(name = "number_moto")
    private int numberMotorcycle;

    public ParkingEntity(int numberCar, int numberMotorcycle) {
        this.numberCar = numberCar;
        this.numberMotorcycle = numberMotorcycle;
    }

    public int getParkinId() {
        return parkinId;
    }

    public void setParkinId(int parkinId) {
        this.parkinId = parkinId;
    }

    public int getNumberCar() {
        return numberCar;
    }

    public void setNumberCar(int numberCar) {
        this.numberCar = numberCar;
    }

    public int getNumberMotorcycle() {
        return numberMotorcycle;
    }

    public void setNumberMotorcycle(int numberMotorcycle) {
        this.numberMotorcycle = numberMotorcycle;
    }
}
