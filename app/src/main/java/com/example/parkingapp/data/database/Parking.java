package com.example.parkingapp.data.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "paking")
public class Parking {

    @PrimaryKey
    @ColumnInfo(name = "paking_id")
    private int parkinId;

    @ColumnInfo(name = "number_car")
    private int numberCar;

    @ColumnInfo(name = "number_moto")
    private int numberMoto;

    public Parking(int numberCar, int numberMoto) {
        this.numberCar = numberCar;
        this.numberMoto = numberMoto;
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

    public int getNumberMoto() {
        return numberMoto;
    }

    public void setNumberMoto(int numberMoto) {
        this.numberMoto = numberMoto;
    }
}
