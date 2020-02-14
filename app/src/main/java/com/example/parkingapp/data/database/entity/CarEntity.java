package com.example.parkingapp.data.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;


@Entity(indices = {@Index("fk_parking_space")}, tableName = "car",
        foreignKeys = {
                @ForeignKey(entity = ParkingSpaceEntitiy.class,
                        parentColumns = "parking_space_id",
                        childColumns = "fk_parking_space")
        })
public class CarEntity {

    @ColumnInfo(name = "plate_id")
    @PrimaryKey()
    @NotNull
    private String plateID;

    @ColumnInfo(name = "fk_parking_space")
    @NotNull
    private int fkParkingSpace;

    public CarEntity(String plateID, int fkParkingSpace) {
        this.fkParkingSpace = fkParkingSpace;
        this.plateID = plateID;
    }

    public String getPlateID() {
        return plateID;
    }

    public void setPlateID(String plateID) {
        this.plateID = plateID;
    }

    public int getFkParkingSpace() {
        return fkParkingSpace;
    }

    public void setFkParkingSpace(int fkParkingSpace) {
        this.fkParkingSpace = fkParkingSpace;
    }
}

