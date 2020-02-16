package com.example.parkingapp.domain.services;

import com.example.parkingapp.data.repository.ParkingImpl;
import com.example.parkingapp.data.repository.ParkingRepository;
import com.example.parkingapp.data.repository.VehicleRepository;
import com.example.parkingapp.data.repository.VehicleRepositoryImpl;

import java.util.Calendar;

import javax.inject.Inject;

public class Validation {

    private VehicleRepository vehicleRepository = new VehicleRepositoryImpl();
    private ParkingRepository parkingRepository = new ParkingImpl();
    private int numberMotorcycles;
    private int numberCars;

    @Inject
    public Validation() {
    }

    public boolean isValid(String plateId) {
        int day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        if (plateId.startsWith("A")) {
            if (day == 1 || day == 4) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isLessThanMotorCycleLimit() {
        numberMotorcycles = parkingRepository.getParking().get(0).getNumberMotorcycle();
        if (vehicleRepository.getListMotorCycle().size() < numberMotorcycles) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isLessThanCarLimit() {
        numberCars = parkingRepository.getParking().get(0).getNumberMotorcycle();
        if (vehicleRepository.getListCar().size() < numberCars) {
            return true;
        }
        return false;
    }
}
