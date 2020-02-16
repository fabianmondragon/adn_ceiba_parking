package com.example.parkingapp.data.repository;

import java.util.Date;


public interface ParkingSpaceRepository {

    boolean updateParkingSpace(int id, Date date, boolean state);

    int getFreeSpace();

    Date getTime(String plate);

    Date getTimeCar(String plate);

    void freeSpace(int fk_space);

}
