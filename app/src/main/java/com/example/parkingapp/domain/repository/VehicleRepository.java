package com.example.parkingapp.domain.repository;

import com.example.parkingapp.domain.exceptions.ParkingException;
import com.example.parkingapp.domain.model.Car;
import com.example.parkingapp.domain.model.Motorcycle;

import java.util.List;

public interface VehicleRepository {

    List<Motorcycle> getListMotorCycle();

    List<Car> getListCar();

    boolean setCar(Car car, int space);

    boolean setMotorcycle(Motorcycle motorcycle, int space);

    Motorcycle getMotorcycle(String plateId);

    boolean deleteMotorcycle(String plate);

    Car getCar(String plate);

    boolean deleteCar(String plate);

}
