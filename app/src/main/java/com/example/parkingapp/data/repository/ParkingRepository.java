package com.example.parkingapp.data.repository;

import com.example.parkingapp.data.database.entity.ParkingEntity;

import java.util.List;

public interface ParkingRepository {

     List<ParkingEntity> getParking() ;

}
