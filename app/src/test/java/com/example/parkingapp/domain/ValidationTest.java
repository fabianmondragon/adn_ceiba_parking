package com.example.parkingapp.domain;

import androidx.transition.Transition;

import com.example.parkingapp.data.database.entity.MotorcycleEntity;
import com.example.parkingapp.data.database.entity.ParkingEntity;
import com.example.parkingapp.data.repository.ManagmentDataBaseRepository;
import com.example.parkingapp.data.repository.ParkingRepository;
import com.example.parkingapp.data.repository.VehicleRepository;
import com.example.parkingapp.domain.model.Car;
import com.example.parkingapp.domain.model.Motorcycle;
import com.example.parkingapp.domain.model.Parking;
import com.example.parkingapp.domain.services.Validation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class ValidationTest {

    private List<ParkingEntity> parkingList;
    private List<Motorcycle> motorcycleList;
    private List<Car> carsList;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    ParkingRepository parkingRepository;

    @Mock
    VehicleRepository vehicleRepository;

    @Mock
    ManagmentDataBaseRepository managmentDataBaseRepository;

    @Mock
    ParkingEntity parkingEntity;

    @InjectMocks
    Validation validation;

    @Before
    public void config() {
        parkingList = new ArrayList<>();
        motorcycleList = new ArrayList<>();
        parkingEntity = new ParkingEntity(10,20);
        motorcycleList.add(new Motorcycle("a", 100, 1));
        parkingList.add(parkingEntity);
    }

    @Test
    public void isPlateValid_WithValidPlate_Success (){
        Boolean b = validation.isValid("A");
        Assert.assertEquals(true, validation.isValid("A"));
    }

    @Test
    public void isPlateValid_EmptyField_Success (){
        Assert.assertEquals(true, validation.isValid("A"));
    }

    @Test
    public void thereIsFreeSpace_WithNumberOfMotorcyclesLowerThanRegistered_True (){
        when (parkingRepository.getParking()).thenReturn(parkingList);
        when (vehicleRepository.getListMotorCycle()).thenReturn(motorcycleList);
        Assert.assertTrue (validation.isLessThanMotorCycleLimit());
    }

    @Test
    public void thereIsFreeSpace_WithNumberOfMotorcyclesEqualThanRegister_False(){
        motorcycleList = new ArrayList<>();
        parkingList = new ArrayList<>();
        motorcycleList.add(new Motorcycle("a", 100, 1));
        parkingList.add(new ParkingEntity(10,1));
        when (parkingRepository.getParking()).thenReturn(parkingList);
        when (vehicleRepository.getListMotorCycle()).thenReturn(motorcycleList);
        Assert.assertFalse(validation.isLessThanMotorCycleLimit());
    }

    @Test
    public void thereIsFreeSpace_WithNumberOfCarsEqualThanRegister_False(){
        carsList = new ArrayList<>();
        parkingList = new ArrayList<>();
        carsList.add(new Car("a"));
        parkingList.add(new ParkingEntity(1,1));
        when (parkingRepository.getParking()).thenReturn(parkingList);
        when (vehicleRepository.getListCar()).thenReturn(carsList);
        Assert.assertFalse(validation.isLessThanCarLimit());
    }

    @Test
    public void thereIsFreeSpace_WithNumberOfCarLowerThanRegistered_False(){
        carsList = new ArrayList<>();
        parkingList = new ArrayList<>();
        carsList.add(new Car("a"));
        parkingList.add(new ParkingEntity(10,1));
        when (parkingRepository.getParking()).thenReturn(parkingList);
        when (vehicleRepository.getListCar()).thenReturn(carsList);
        Assert.assertFalse(validation.isLessThanCarLimit());
    }

}