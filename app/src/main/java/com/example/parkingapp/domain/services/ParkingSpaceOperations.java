package com.example.parkingapp.domain.services;

import com.example.parkingapp.data.repository.ParkingSpaceRepository;

import java.util.Date;

import javax.inject.Inject;

public class ParkingSpaceOperations {

    @Inject
    ParkingSpaceRepository parkingSpaceRepository;

    @Inject
    public ParkingSpaceOperations() {

    }

    public int getFreeSpace() {
        return parkingSpaceRepository.getFreeSpace();
    }

    public boolean occupySpace(int spaceIdentifier, Date date) {
        return parkingSpaceRepository.updateParkingSpace(spaceIdentifier, date, true);
    }

    public boolean freeUpSpace(int spaceIdentifier) {
        return parkingSpaceRepository.updateParkingSpace(spaceIdentifier, null, false);
    }

    public Date getTimeMotorcycle(String plateMotorcycle) {
        return parkingSpaceRepository.getTime(plateMotorcycle);
    }

    public Date getTimeCar(String plate) {
        return parkingSpaceRepository.getTimeCar(plate);
    }
}
