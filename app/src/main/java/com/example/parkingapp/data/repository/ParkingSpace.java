package com.example.parkingapp.data.repository;

import java.util.Date;
import java.util.List;

public interface ParkingSpace {

    boolean updateParkingSpace(int id, Date date);

    int getFree();

    ParkingSpace getTime(String plate);

    ParkingSpace getTimeCar(String plate);

    void freeSpace(int fk_space);

    List<ParkingSpace> getParkingSpace();

    ParkingSpace getOneParkingSpace(int id);


}
