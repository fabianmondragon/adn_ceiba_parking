package com.example.parkingapp.data.repository;

import com.example.parkingapp.BaseApplication;
import com.example.parkingapp.data.database.entity.CarEntity;
import com.example.parkingapp.data.database.entity.MotorcycleEntity;
import com.example.parkingapp.data.mappers.MapperParking;
import com.example.parkingapp.domain.repository.VehicleRepository;
import com.example.parkingapp.domain.model.Car;
import com.example.parkingapp.domain.model.Motorcycle;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class VehicleRepositoryImpl implements VehicleRepository {

    private List<Motorcycle> motorcycleList;
    private List<MotorcycleEntity> entityMotorcycleList;
    private List<Car> carList;
    private List<CarEntity> entityListCar;
    private CarEntity carEntity;
    private MotorcycleEntity motorcycleEntity;
    private Car car;
    private MapperParking mapperParking;

    @Inject
    public VehicleRepositoryImpl() {
        mapperParking = new MapperParking();
    }

    public List<Motorcycle> getListMotorCycle() {
        motorcycleList = new ArrayList<>();
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        entityMotorcycleList = db.motorCycleDao().getAllMotorcycle();
        motorcycleList = mapperParking.convertListToMotorcycle(entityMotorcycleList);
        return motorcycleList;
    }

    public List<Car> getListCar() {
        carList = new ArrayList<>();
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        entityListCar = db.carDao().getAll();
        carList = mapperParking.convertListToCar(entityListCar);
        return carList;
    }

    public boolean setCar(Car car, int space) {
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        CarEntity carEntity = new CarEntity(car.getPlate(), space);
        db.carDao().insertCar(carEntity);
        return true;
    }

    public boolean setMotorcycle(Motorcycle motorcycle, int space) {
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        motorcycleEntity = new MotorcycleEntity(motorcycle.getPlate(), motorcycle.getCylindrical(), space);
        db.motorCycleDao().insertMotorcycle(motorcycleEntity);
        return true;
    }

    public Motorcycle getMotorcycle(String plateId) {
        MotorcycleEntity motorcycleEntity;
        Motorcycle motorcycle = null;
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        motorcycleEntity = db.motorCycleDao().getMotoCycle(plateId);
        if (motorcycleEntity != null )
            motorcycle = mapperParking.convertToMotorcycle(motorcycleEntity);
        return motorcycle;
    }

    public boolean deleteMotorcycle(String plate) {
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        db.motorCycleDao().delete(plate);
        return true;
    }

    public Car getCar(String plate) {
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        carEntity = db.carDao().getCar(plate);
        if (carEntity!=null)
            car = mapperParking.convertToCar(carEntity);
        return car;
    }

    public boolean deleteCar(String plate) {
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        db.carDao().delete(plate);
        return true;
    }

}
