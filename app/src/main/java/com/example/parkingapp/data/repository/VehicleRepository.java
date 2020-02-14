package com.example.parkingapp.data.repository;

import com.example.parkingapp.data.database.entity.CarEntity;
import com.example.parkingapp.data.database.entity.MotorcycleEntity;
import com.example.parkingapp.domain.model.Car;
import com.example.parkingapp.domain.model.Motorcycle;


import java.util.List;

public interface VehicleRepository {

    List<Motorcycle> getListMotorCycle();
    List<Car> getListCar();
    boolean setCar(Car car, int space);
    boolean setMotorcycle(Motorcycle motorcycle, int space);
    Motorcycle getMotoCycle(String plateId);
    void deleteMotorcycle(String plate);
    Car getCar(String plate);
    void deleteCar(String plate);

}
