package com.example.parkingapp.domain.services;

import com.example.parkingapp.domain.interfaces_repository.ParkingSpaceRepository;
import com.example.parkingapp.domain.interfaces_repository.VehicleRepository;
import com.example.parkingapp.domain.model.Car;
import com.example.parkingapp.domain.model.Motorcycle;
import com.example.parkingapp.domain.model.Response;
import com.example.parkingapp.domain.operations.BillOperations;
import com.example.parkingapp.domain.operations.CylindricalRulesOperations;
import com.example.parkingapp.domain.operations.ParkingSpaceOperations;
import com.example.parkingapp.domain.operations.TariffOperations;
import com.example.parkingapp.domain.operations.Validation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Calendar;
import java.util.Date;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class VehicleOperationsTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @InjectMocks
    VehicleOperations vehicleOperations;

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

    @Mock
    BillOperations billOperations;

    @Mock
    Car car;

    @Mock
    CylindricalRulesOperations cylindricalRulesOperations;

    @Mock
    TariffOperations tariffOperations;

    private Date previosDate;
    private Date currentDate;
    private Long minuts;
    private Motorcycle motorcycle;

    @Before
    public void config(){
        motorcycle = new Motorcycle("l", 100, 0);
        currentDate = Calendar.getInstance().getTime();
        previosDate = Calendar.getInstance().getTime();
        minuts = (long)10;
    }


    @Test
    public void registerMotorcycle_ValidMotocycle_Success (){
        int identificador =10;
        when (validation.isValid(motorcycle.getPlate())).thenReturn(true);
        when(validation.isLessThanMotorCycleLimit()).thenReturn(true);
        when (parkingSpaceOperations.getFreeSpace()).thenReturn(identificador);
        when (vehicleRepository.setMotorcycle(motorcycle, 10)).thenReturn(true);
        when (parkingSpaceOperations.occupySpace(10, Calendar.getInstance().getTime())).thenReturn(true);

        Assert.assertTrue(vehicleOperations.registermotorcycle(motorcycle).state);
    }

    @Test
    public void registerMotorcycle_ValidMotocycle_Fail (){
        Date currentDate = Calendar.getInstance().getTime();
        when (validation.isValid(motorcycle.getPlate())).thenReturn(true);
        when(validation.isLessThanMotorCycleLimit()).thenReturn(true);
        when (parkingSpaceRepository.getFreeSpace()).thenReturn(0);
        when (vehicleRepository.setMotorcycle(motorcycle, 0)).thenReturn(false);
        when (parkingSpaceOperations.occupySpace(motorcycle.getFkParkingSpace(), currentDate)).thenReturn(true)  ;
        Assert.assertFalse(vehicleOperations.registermotorcycle(motorcycle).state);
    }

    @Test
    public void registerMotorcycle_EqualLimitAllowed_ThereIsNotSpace_Fail (){
        Date currentDate = Calendar.getInstance().getTime();
        when (validation.isValid("a")).thenReturn(true);
        when(validation.isLessThanMotorCycleLimit()).thenReturn(false);
        when (parkingSpaceRepository.getFreeSpace()).thenReturn(0);
        when (vehicleRepository.setMotorcycle(motorcycle, 0)).thenReturn(true);
        when (parkingSpaceOperations.occupySpace(1, currentDate)).thenReturn(true)  ;
        Assert.assertFalse(vehicleOperations.registermotorcycle(motorcycle).state);
    }

    @Test
    public void registerMotorcycle_ProblemWithSpace_ThereIsNotSpace_Fail (){
        Date currentDate = Calendar.getInstance().getTime();
        when (validation.isValid("a")).thenReturn(true);
        when(validation.isLessThanMotorCycleLimit()).thenReturn(true);
        when (parkingSpaceRepository.getFreeSpace()).thenReturn(0);
        when (vehicleRepository.setMotorcycle(motorcycle, 0)).thenReturn(true);
        when (parkingSpaceOperations.occupySpace(1, currentDate)).thenReturn(false)  ;
        Assert.assertFalse(vehicleOperations.registermotorcycle(motorcycle).state);
    }

    @Test
    public void registerMotorcycle_ValidMotorcicle_FailInDataBase (){
        Date currentDate = Calendar.getInstance().getTime();
        when (validation.isValid("E")).thenReturn(false);
        when(validation.isLessThanMotorCycleLimit()).thenReturn(false);
        when (parkingSpaceRepository.getFreeSpace()).thenReturn(0);
        when (vehicleRepository.setMotorcycle(motorcycle, 0)).thenReturn(false);
        when (parkingSpaceOperations.occupySpace(1, currentDate)).thenReturn(false)  ;
        Assert.assertFalse(vehicleOperations.registermotorcycle(motorcycle).state);
    }

    @Test
    public void registerCar_ValidCar_Success (){
        Date currentDate = Calendar.getInstance().getTime();
        when(validation.isLessThanCarLimit()).thenReturn(true);
        when (parkingSpaceRepository.getFreeSpace()).thenReturn(0);
        when (vehicleRepository.setCar(car, 0)).thenReturn(true);
        when (parkingSpaceOperations.occupySpace(1, currentDate)).thenReturn(true)  ;
        Assert.assertTrue(vehicleOperations.registerCar(car).state);
    }

    @Test
    public void registerCar_ValidCar_Fail (){
        Date currentDate = Calendar.getInstance().getTime();
        when(validation.isLessThanCarLimit()).thenReturn(true);
        when (parkingSpaceRepository.getFreeSpace()).thenReturn(0);
        when (vehicleRepository.setCar(car, 0)).thenReturn(false);
        when (parkingSpaceOperations.occupySpace(1, currentDate)).thenReturn(true)  ;
        Assert.assertFalse(vehicleOperations.registerCar(car).state);
    }

    @Test
    public void registerCar_EqualLimitAllowed_ThereIsNotSpace_Fail (){
        Date currentDate = Calendar.getInstance().getTime();
        when (validation.isValid("a")).thenReturn(true);
        when(validation.isLessThanCarLimit()).thenReturn(false);
        when (parkingSpaceRepository.getFreeSpace()).thenReturn(0);
        when (vehicleRepository.setCar(car, 0)).thenReturn(true);
        when (parkingSpaceOperations.occupySpace(1, currentDate)).thenReturn(true)  ;
        Assert.assertFalse(vehicleOperations.registerCar(car).state);
    }

    @Test
    public void registerCar_ValidCar_FailInDataBase (){
        Date currentDate = Calendar.getInstance().getTime();
        when (validation.isValid("E")).thenReturn(false);
        when(validation.isLessThanCarLimit()).thenReturn(false);
        when (parkingSpaceRepository.getFreeSpace()).thenReturn(0);
        when (vehicleRepository.setCar(car, 0)).thenReturn(false);
        when (parkingSpaceOperations.occupySpace(1, currentDate)).thenReturn(false)  ;
        Assert.assertFalse(vehicleOperations.registerCar(car).state);
    }

    @Test
    public void checkoutMotorcycle_WithMotorcycleRegister_Success (){
        when (vehicleRepository.getMotorcycle(motorcycle.getPlate())).thenReturn(motorcycle);
        when(parkingSpaceOperations.getTimeMotorcycle(motorcycle.getPlate())).thenReturn(previosDate);
        when (billOperations.calculateTime(currentDate, currentDate)).thenReturn(minuts);
        when (billOperations.calculateCost(minuts, 100, 1)).thenReturn((long) 10);
        when(vehicleRepository.deleteMotorcycle(motorcycle.getPlate())).thenReturn(true);
        when (parkingSpaceOperations.freeUpSpace(motorcycle.getFkParkingSpace())).thenReturn(true);
        Assert.assertTrue(vehicleOperations.checkOutMotorcycle(motorcycle).state);
    }
    @Test
    public void checkoutMotorcycle_WithMotorcycleRegister_Fail (){
        when (vehicleRepository.getMotorcycle(motorcycle.getPlate())).thenReturn(motorcycle);
        when(parkingSpaceOperations.getTimeMotorcycle(motorcycle.getPlate())).thenReturn(previosDate);
        when (billOperations.calculateTime(currentDate, currentDate)).thenReturn(minuts);
        when (billOperations.calculateCost(minuts, 100, 1)).thenReturn((long) 10);
        when(vehicleRepository.deleteMotorcycle(motorcycle.getPlate())).thenReturn(false);
        when (parkingSpaceOperations.freeUpSpace(motorcycle.getFkParkingSpace())).thenReturn(true);
        Assert.assertFalse(vehicleOperations.checkOutMotorcycle(motorcycle).state);
    }

    @Test
    public void checkoutMotorcycle_ProblemWithDeleteMotorcycleFromDatabase_False (){
        when (vehicleRepository.getMotorcycle(motorcycle.getPlate())).thenReturn(motorcycle);
        when(parkingSpaceOperations.getTimeMotorcycle(motorcycle.getPlate())).thenReturn(previosDate);
        when (billOperations.calculateTime(currentDate, currentDate)).thenReturn(minuts);
        when (billOperations.calculateCost(minuts, motorcycle.getCylindrical(), 1)).thenReturn((long) 10);
        when(vehicleRepository.deleteMotorcycle(motorcycle.getPlate())).thenReturn(false);
        when (parkingSpaceOperations.freeUpSpace(motorcycle.getFkParkingSpace())).thenReturn(true);
        Assert.assertFalse(vehicleOperations.checkOutMotorcycle(motorcycle).state);
    }

    @Test
    public void checkoutCar_ProblemWithDeleteCarFromDatabase_False (){
        when (vehicleRepository.getCar(car.getPlate())).thenReturn(car);
        when(parkingSpaceOperations.getTimeCar(car.getPlate())).thenReturn(previosDate);
        when (billOperations.calculateTime(currentDate, currentDate)).thenReturn(minuts);
        when (billOperations.calculateCost(minuts, 100, 1)).thenReturn((long) 10);
        when(vehicleRepository.deleteCar(car.getPlate())).thenReturn(false);
        when (parkingSpaceOperations.freeUpSpace(car.getFkParkingSpace())).thenReturn(true);
        Assert.assertFalse(vehicleOperations.checkoutCar(car).state);
    }

    @Test
    public void checkoutCar_DeleteFromDataBase_Success (){
        when (vehicleRepository.getCar(car.getPlate())).thenReturn(car);
        when(parkingSpaceOperations.getTimeCar(car.getPlate())).thenReturn(previosDate);
        when (billOperations.calculateTime(currentDate, currentDate)).thenReturn(minuts);
        when (billOperations.calculateCost(minuts, 100, 1)).thenReturn((long) 10);
        when(vehicleRepository.deleteCar(car.getPlate())).thenReturn(true);
        when (parkingSpaceOperations.freeUpSpace(car.getFkParkingSpace())).thenReturn(true);
        Assert.assertTrue(vehicleOperations.checkoutCar(car).state);
    }


}