package com.example.parkingapp.domain.operations;

import com.example.parkingapp.domain.repository.ParkingRepository;
import com.example.parkingapp.domain.repository.VehicleRepository;

import java.util.Calendar;

import javax.inject.Inject;

public class Validation {

    @Inject
    VehicleRepository vehicleRepository;

    @Inject
    ParkingRepository parkingRepository;

    @Inject
    public Validation() {
        // se utiliza de esta manera para Dagger y para las pruebas unitarias
    }

    public boolean isValid(String plateId) {
        int day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        boolean valDay;

        if (plateId.startsWith("A")) {
            valDay = (day == 1 || day == 3);
            return valDay;
        }
        return true;
    }

    public boolean isLessThanMotorCycleLimit() {
        int numberMotorcycles = parkingRepository.getParking().get(0).getNumberMotorcycle();
        return vehicleRepository.getListMotorCycle().size() < numberMotorcycles;
    }

    public boolean isLessThanCarLimit() {
        int numberCars = parkingRepository.getParking().get(0).getNumberMotorcycle();
        return (vehicleRepository.getListCar().size() < numberCars);
    }
}
