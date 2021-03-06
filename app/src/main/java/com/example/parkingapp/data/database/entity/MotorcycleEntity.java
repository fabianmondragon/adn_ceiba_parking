package com.example.parkingapp.data.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "moto", indices = {@Index("fk_parking_space")},
        foreignKeys = {
                @ForeignKey(entity = ParkingSpaceEntitiy.class,
                        parentColumns = "parking_space_id",
                        childColumns = "fk_parking_space")
        })
public class MotorcycleEntity {

    @ColumnInfo(name = "plate_id")
    @PrimaryKey()
    @NotNull
    private String plateID;

    @ColumnInfo(name = "cylindrical")
    private int cylindrical;

    @ColumnInfo(name = "fk_parking_space")
    @NotNull
    private int fkParkingSpace;

    @Ignore
    public MotorcycleEntity(String plateID, int cylindrical, int fkParkingSpace) {
        this.fkParkingSpace = fkParkingSpace;
        this.plateID = plateID;
        this.cylindrical = cylindrical;
    }

    public MotorcycleEntity(String plateID) {
        this.plateID = plateID;
    }

    public String getPlateID() {
        return plateID;
    }

    public void setPlateID(String plateID) {
        this.plateID = plateID;
    }

    public int getCylindrical() {
        return cylindrical;
    }

    public void setCylindrical(int cylindrical) {
        this.cylindrical = cylindrical;
    }

    public int getFkParkingSpace() {
        return fkParkingSpace;
    }

    public void setFkParkingSpace(int fkParkingSpace) {
        this.fkParkingSpace = fkParkingSpace;
    }
}
