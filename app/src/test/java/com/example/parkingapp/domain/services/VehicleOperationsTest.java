package com.example.parkingapp.domain.services;

import com.example.parkingapp.data.repository.ParkingSpaceRepository;
import com.example.parkingapp.data.repository.VehicleRepository;
import com.example.parkingapp.domain.model.Motorcycle;
import com.example.parkingapp.domain.model.Response;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Calendar;
import java.util.Date;

import static org.mockito.Mockito.when;

public class VehicleOperationsTest {

    @InjectMocks
    VehicleOperations vehicleOperations;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    ParkingSpaceOperations parkingSpaceOperations;

    @Mock
    Validation validation;

    @Mock
    ParkingSpaceRepository parkingSpaceRepository;

    @Mock
    VehicleRepository vehicleRepository;

    @Mock
    Response response;

    @Test
    public void registerMotorcycle_ValidMotocycle_Success (){
        Date currentDate = Calendar.getInstance().getTime();
        Motorcycle motorcycle = new Motorcycle("a", 100, 1 );
        when (validation.isValid("a")).thenReturn(true);
        when(validation.isLessThanMotorCycleLimit()).thenReturn(true);
        when (parkingSpaceRepository.getFreeSpace()).thenReturn(0);
        when (vehicleRepository.setMotorcycle(motorcycle, 0)).thenReturn(true);
        when (parkingSpaceOperations.occupySpace(1, currentDate)).thenReturn(true)  ;
        Assert.assertTrue(vehicleOperations.registerMotorCycle(motorcycle).state);
    }

    @Test
    public void registerMotorcycle_EqualLimitAllowed_ThereIsNotSpace_Fail (){
        Date currentDate = Calendar.getInstance().getTime();
        Motorcycle motorcycle = new Motorcycle("a", 100, 1 );
        when (validation.isValid("a")).thenReturn(true);
        when(validation.isLessThanMotorCycleLimit()).thenReturn(false);
        when (parkingSpaceRepository.getFreeSpace()).thenReturn(0);
        when (vehicleRepository.setMotorcycle(motorcycle, 0)).thenReturn(true);
        when (parkingSpaceOperations.occupySpace(1, currentDate)).thenReturn(true)  ;
        Assert.assertFalse(vehicleOperations.registerMotorCycle(motorcycle).state);
    }

    @Test
    public void registerMotorcycle_ProblemWithSpace_ThereIsNotSpace_Fail (){
        Date currentDate = Calendar.getInstance().getTime();
        Motorcycle motorcycle = new Motorcycle("a", 100, 1 );
        when (validation.isValid("a")).thenReturn(true);
        when(validation.isLessThanMotorCycleLimit()).thenReturn(false);
        when (parkingSpaceRepository.getFreeSpace()).thenReturn(0);
        when (vehicleRepository.setMotorcycle(motorcycle, 0)).thenReturn(true);
        when (parkingSpaceOperations.occupySpace(1, currentDate)).thenReturn(false)  ;
        Assert.assertFalse(vehicleOperations.registerMotorCycle(motorcycle).state);
    }

    @Test
    public void registerMotorcycle_ValidMotorcicle_FailInDataBase (){
        Date currentDate = Calendar.getInstance().getTime();
        Motorcycle motorcycle = new Motorcycle("a", 100, 1 );
        when (validation.isValid("E")).thenReturn(false);
        when(validation.isLessThanMotorCycleLimit()).thenReturn(false);
        when (parkingSpaceRepository.getFreeSpace()).thenReturn(0);
        when (vehicleRepository.setMotorcycle(motorcycle, 0)).thenReturn(false);
        when (parkingSpaceOperations.occupySpace(1, currentDate)).thenReturn(false)  ;
        Assert.assertFalse(vehicleOperations.registerMotorCycle(motorcycle).state);
    }


}