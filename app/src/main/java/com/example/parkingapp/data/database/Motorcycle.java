package com.example.parkingapp.data.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity (tableName = "moto", indices = {@Index("fk_parking_space")},
        foreignKeys = {
                @ForeignKey(entity = ParkingSpace.class,
                        parentColumns = "parking_space_id",
                        childColumns = "fk_parking_space")
        })
public class Motorcycle {

    @ColumnInfo(name = "plate_id")
    @PrimaryKey ()
    @NotNull
    private String plateID;

    @ColumnInfo(name = "cilindraje")
    private int cilindraje;

    @ColumnInfo(name = "fk_parking_space")
    @NotNull
    private int fkParkingSpace;

    @Ignore
    public Motorcycle(String plateID, int cilindraje, int fkParkingSpace) {
        this.fkParkingSpace=fkParkingSpace;
        this.plateID = plateID;
        this.cilindraje = cilindraje;
    }
    public Motorcycle(String plateID) {
        this.plateID = plateID;
    }


    public String getPlateID() {
        return plateID;
    }

    public void setPlateID(String plateID) {
        this.plateID = plateID;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public int getFkParkingSpace() {
        return fkParkingSpace;
    }

    public void setFkParkingSpace(int fkParkingSpace) {
        this.fkParkingSpace = fkParkingSpace;
    }
}
