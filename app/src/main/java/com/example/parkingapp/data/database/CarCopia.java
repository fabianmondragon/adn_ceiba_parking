package com.example.parkingapp.data.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;


@Entity (tableName = "car_copia")
public class CarCopia {


    @ColumnInfo(name = "id_car")
    @PrimaryKey (autoGenerate = true)
    @NotNull
     int idCarCopia;

    @ColumnInfo(name = "name")
    private String name;

    public int getIdCar() {
        return idCarCopia;
    }

    public void setIdCar(int idCar) {
        this.idCarCopia = idCar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

