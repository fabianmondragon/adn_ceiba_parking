package com.example.parkingapp.data.repository;

import com.example.parkingapp.BaseApplication;
import com.example.parkingapp.data.database.entity.CarEntity;
import com.example.parkingapp.data.database.entity.MotorcycleEntity;
import com.example.parkingapp.domain.model.Car;
import com.example.parkingapp.domain.model.Motorcycle;

import java.util.ArrayList;
import java.util.List;

public class VehicleRepositoryImpl implements VehicleRepository {

    private List<Motorcycle> motorcycleList;
    private List<MotorcycleEntity> entityMotorcycleList;
    private List<Car> carList;
    private List<CarEntity> entityListCar;
    private CarEntity carEntity;
    private MotorcycleEntity motorcycleEntity;
    private Car car;

    public List<Motorcycle> getListMotorCycle() {
        motorcycleList = new ArrayList<>();
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        try {
            entityMotorcycleList = db.motorCycleDao().getAllMotorcycle();
            for (MotorcycleEntity motorcycleEntity : entityMotorcycleList) {
                motorcycleList.add(new Motorcycle(motorcycleEntity.getPlateID(), motorcycleEntity.getCylindrical()));
            }
            return motorcycleList;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Car> getListCar() {
        carList = new ArrayList<>();
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        try {
            entityListCar = db.carDao().getAll();
            for (CarEntity carItem : entityListCar) {
                carList.add(new Car(carItem.getPlateID()));
            }
            return carList;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean setCar(Car car, int space) {
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        CarEntity carEntity = new CarEntity(car.getPlate(), space);
        try {
            db.carDao().insertCar(carEntity);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean setMotorcycle(Motorcycle motorcycle, int space) {
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        motorcycleEntity = new MotorcycleEntity(motorcycle.getPlate(), motorcycle.getCylindrical(), space);
        try {
            db.motorCycleDao().insertMotorcycle(motorcycleEntity);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public Motorcycle getMotorcycle(String plateId) {
        MotorcycleEntity motorcycleEntity;
        Motorcycle motorcycle;
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        try {
            motorcycleEntity = db.motorCycleDao().getMotoCycle(plateId);
            motorcycle = new Motorcycle(motorcycleEntity.getPlateID(), motorcycleEntity.getCylindrical(), motorcycleEntity.getFkParkingSpace());
            return motorcycle;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean deleteMotorcycle(String plate) {
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        try {
            db.motorCycleDao().delete(plate);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Car getCar(String plate) {
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        try {
            carEntity = db.carDao().getCar(plate);
            car = new Car(carEntity.getPlateID());
            return car;
        } catch (Exception e) {

        }
        return null;
    }

    public boolean deleteCar(String plate) {
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        try {
            db.carDao().delete(plate);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
