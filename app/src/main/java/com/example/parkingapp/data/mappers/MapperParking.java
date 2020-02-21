package com.example.parkingapp.data.mappers;

import com.example.parkingapp.data.database.entity.CarEntity;
import com.example.parkingapp.data.database.entity.MotorcycleEntity;
import com.example.parkingapp.domain.model.Car;
import com.example.parkingapp.domain.model.Motorcycle;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class MapperParking {

    public Motorcycle convertToMotorcycle(MotorcycleEntity motorcycleEntity) {
        ModelMapper modelMapper = new ModelMapper();
        Motorcycle motorcycle = modelMapper.map(motorcycleEntity, Motorcycle.class);
        return motorcycle;
    }

    public Car convertToCar (CarEntity carEntity){
        ModelMapper modelMapper = new ModelMapper();
        Car car = modelMapper.map(carEntity, Car.class);
        return car;
    }

    public List<Motorcycle> convertListToMotorcycle (List<MotorcycleEntity> motorcycleEntityList){
        ModelMapper modelMapper = new ModelMapper();
        List<Motorcycle> motorcycleList = new ArrayList<>();
        motorcycleList  = modelMapper.map(motorcycleEntityList, motorcycleList.getClass());
        return motorcycleList;
    }

    public List<Car> convertListToCar (List<CarEntity> carEntitiesEntityList){
        ModelMapper modelMapper = new ModelMapper();
        List<Car> carsList = new ArrayList<>();
        carsList  = modelMapper.map(carEntitiesEntityList, carsList.getClass());
        return carsList;
    }

}
