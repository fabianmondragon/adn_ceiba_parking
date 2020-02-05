package com.example.parkingapp.data.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.sql.Date;

import static androidx.room.ForeignKey.CASCADE;


@Entity(indices = {@Index("fk_parking")},tableName = "parking_space", foreignKeys = {

        @ForeignKey(entity = Parking.class,
                parentColumns = "paking_id",
                childColumns = "fk_parking"

        )
})
public class ParkingSpace {
    @PrimaryKey (autoGenerate =  true)
    @ColumnInfo (name = "parking_space_id")
    private int parkingSpaceId;

    @ColumnInfo (name = "state")
    private boolean state;

    @ColumnInfo (name = "date")
    private Date startOcupation;



    @ColumnInfo (name = "fk_parking")
    public int parking;

    public ParkingSpace( boolean state, Date startOcupation, int parking) {
        this.state = state;
        this.startOcupation = startOcupation;
        this.parking = parking;
    }

    public int getParkingSpaceId() {
        return parkingSpaceId;
    }

    public void setParkingSpaceId(int parkingSpaceId) {
        this.parkingSpaceId = parkingSpaceId;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Date getStartOcupation() {
        return startOcupation;
    }

    public void setStartOcupation(Date startOcupation) {
        this.startOcupation = startOcupation;
    }


    public int getParking() {
        return parking;
    }

    public void setParking(int parking) {
        this.parking = parking;
    }
}
