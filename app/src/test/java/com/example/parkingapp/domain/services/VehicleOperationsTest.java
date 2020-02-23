package com.example.parkingapp.domain.services;

import com.example.parkingapp.domain.model.Car;
import com.example.parkingapp.domain.model.Motorcycle;
import com.example.parkingapp.domain.model.Response;
import com.example.parkingapp.domain.operations.BillOperations;
import com.example.parkingapp.domain.operations.CylindricalRulesOperations;
import com.example.parkingapp.domain.operations.ParkingSpaceOperations;
import com.example.parkingapp.domain.operations.TariffOperations;
import com.example.parkingapp.domain.operations.Validation;
import com.example.parkingapp.domain.repository.ParkingSpaceRepository;
import com.example.parkingapp.domain.repository.VehicleRepository;

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
        car = new Car("lmo23");
        currentDate = Calendar.getInstance().getTime();
        previosDate = Calendar.getInstance().getTime();
        minuts = (long)10;
    }


    @Test
    public void registerMotorcycle_ValidMotorcycle_Success (){
        //Arrange
        int parkingIdentifier =10;
        when (validation.isValid(motorcycle.getPlate())).thenReturn(true);
        when(validation.isLessThanMotorCycleLimit()).thenReturn(true);
        when (parkingSpaceOperations.getFreeSpace()).thenReturn(parkingIdentifier);
        when (vehicleRepository.setMotorcycle(motorcycle, 10)).thenReturn(true);
        when (parkingSpaceOperations.occupySpace(10, Calendar.getInstance().getTime())).thenReturn(true);
        //Act
        boolean result = vehicleOperations.registerMotorcycle(motorcycle).state;
        //Assert
        Assert.assertTrue(result);
    }

    @Test
    public void registerMotorcycle_ValidMotorcycle_Fail (){
        //Arrange
        Date currentDate = Calendar.getInstance().getTime();
        when (validation.isValid(motorcycle.getPlate())).thenReturn(true);
        when(validation.isLessThanMotorCycleLimit()).thenReturn(true);
        when (parkingSpaceRepository.getFreeSpace()).thenReturn(0);
        when (vehicleRepository.setMotorcycle(motorcycle, 0)).thenReturn(false);
        when (parkingSpaceOperations.occupySpace(motorcycle.getFkParkingSpace(), currentDate)).thenReturn(true)  ;
        //Act
        boolean result = vehicleOperations.registerMotorcycle(motorcycle).state;
        //Assert
        Assert.assertFalse(result);
    }

    @Test
    public void registerMotorcycle_EqualLimitAllowed_ThereIsNotSpace_Fail (){
        //Arrange
        Date currentDate = Calendar.getInstance().getTime();
        when (validation.isValid("a")).thenReturn(true);
        when(validation.isLessThanMotorCycleLimit()).thenReturn(false);
        when (parkingSpaceRepository.getFreeSpace()).thenReturn(0);
        when (vehicleRepository.setMotorcycle(motorcycle, 0)).thenReturn(true);
        when (parkingSpaceOperations.occupySpace(1, currentDate)).thenReturn(true);
        //Act
        boolean result = vehicleOperations.registerMotorcycle(motorcycle).state;
        //Assert
        Assert.assertFalse(result);
    }

    @Test
    public void registerMotorcycle_ProblemWithSpace_ThereIsNotSpace_Fail (){
        //Arrange
        Date currentDate = Calendar.getInstance().getTime();
        when (validation.isValid("a")).thenReturn(true);
        when(validation.isLessThanMotorCycleLimit()).thenReturn(true);
        when (parkingSpaceRepository.getFreeSpace()).thenReturn(0);
        when (vehicleRepository.setMotorcycle(motorcycle, 0)).thenReturn(true);
        when (parkingSpaceOperations.occupySpace(1, currentDate)).thenReturn(false);
        //Act
        boolean result = vehicleOperations.registerMotorcycle(motorcycle).state;
        //Assert
        Assert.assertFalse(result);
    }

    @Test
    public void registerMotorcycle_ValidMotorcicle_FailInDataBase (){
        //Arrange
        Date currentDate = Calendar.getInstance().getTime();
        when (validation.isValid("E")).thenReturn(false);
        when(validation.isLessThanMotorCycleLimit()).thenReturn(false);
        when (parkingSpaceRepository.getFreeSpace()).thenReturn(0);
        when (vehicleRepository.setMotorcycle(motorcycle, 0)).thenReturn(false);
        when (parkingSpaceOperations.occupySpace(1, currentDate)).thenReturn(false);
        //Act
        boolean result = vehicleOperations.registerMotorcycle(motorcycle).state;
        //Assert
        Assert.assertFalse(result);
    }

    @Test
    public void registerCar_ValidCar_Success (){
        //Arrange
        Date currentDate = Calendar.getInstance().getTime();
        when(validation.isLessThanCarLimit()).thenReturn(true);
        when (parkingSpaceRepository.getFreeSpace()).thenReturn(0);
        when (vehicleRepository.setCar(car, 0)).thenReturn(true);
        when (parkingSpaceOperations.occupySpace(1, currentDate)).thenReturn(true);
        //Act
        boolean result = vehicleOperations.registerCar(car).state;
        //Assert
        Assert.assertTrue(result);
    }

    @Test
    public void registerCar_ValidCar_Fail (){
        //Arrange
        Date currentDate = Calendar.getInstance().getTime();
        when(validation.isLessThanCarLimit()).thenReturn(true);
        when (parkingSpaceRepository.getFreeSpace()).thenReturn(0);
        when (vehicleRepository.setCar(car, 0)).thenReturn(false);
        when (parkingSpaceOperations.occupySpace(1, currentDate)).thenReturn(true);
        //Act
        boolean result = vehicleOperations.registerCar(car).state;
        //Assert
        Assert.assertFalse(result);
    }

    @Test
    public void registerCar_EqualLimitAllowed_ThereIsNotSpace_Fail (){
        //Arrange
        Date currentDate = Calendar.getInstance().getTime();
        when (validation.isValid("a")).thenReturn(true);
        when(validation.isLessThanCarLimit()).thenReturn(false);
        when (parkingSpaceRepository.getFreeSpace()).thenReturn(0);
        when (vehicleRepository.setCar(car, 0)).thenReturn(true);
        when (parkingSpaceOperations.occupySpace(1, currentDate)).thenReturn(true);
        //Act
        boolean result = vehicleOperations.registerCar(car).state;
        //Assert
        Assert.assertFalse(result);
    }

    @Test
    public void registerCar_ValidCar_FailInDataBase (){
        //Arrange
        Date currentDate = Calendar.getInstance().getTime();
        when (validation.isValid("E")).thenReturn(false);
        when(validation.isLessThanCarLimit()).thenReturn(false);
        when (parkingSpaceRepository.getFreeSpace()).thenReturn(0);
        when (vehicleRepository.setCar(car, 0)).thenReturn(false);
        when (parkingSpaceOperations.occupySpace(1, currentDate)).thenReturn(false);
        //Act
        boolean result = vehicleOperations.registerCar(car).state;
        //Assert
        Assert.assertFalse(result);
    }

    @Test
    public void checkoutMotorcycle_WithMotorcycleRegister_Success (){
        //Arrange
        when (vehicleRepository.getMotorcycle(motorcycle.getPlate())).thenReturn(motorcycle);
        when(parkingSpaceOperations.getTimeMotorcycle(motorcycle.getPlate())).thenReturn(previosDate);
        when (billOperations.calculateTime(currentDate, currentDate)).thenReturn(minuts);
        when (billOperations.calculateCost(minuts, 100, 1)).thenReturn((long) 10);
        when(vehicleRepository.deleteMotorcycle(motorcycle.getPlate())).thenReturn(true);
        when (parkingSpaceOperations.freeUpSpace(motorcycle.getFkParkingSpace())).thenReturn(true);
        //Act
        boolean result = vehicleOperations.checkOutMotorcycle(motorcycle).state;
        //Assert
        Assert.assertTrue(result);
    }
    @Test
    public void checkoutMotorcycle_WithMotorcycleRegister_Fail (){
        //Arrange
        when (vehicleRepository.getMotorcycle(motorcycle.getPlate())).thenReturn(motorcycle);
        when(parkingSpaceOperations.getTimeMotorcycle(motorcycle.getPlate())).thenReturn(previosDate);
        when (billOperations.calculateTime(currentDate, currentDate)).thenReturn(minuts);
        when (billOperations.calculateCost(minuts, 100, 1)).thenReturn((long) 10);
        when(vehicleRepository.deleteMotorcycle(motorcycle.getPlate())).thenReturn(false);
        when (parkingSpaceOperations.freeUpSpace(motorcycle.getFkParkingSpace())).thenReturn(true);
        //Act
        boolean result = vehicleOperations.checkOutMotorcycle(motorcycle).state;
        //Assert
        Assert.assertFalse(result);
    }

    @Test
    public void checkoutMotorcycle_ProblemWithDeleteMotorcycleFromDatabase_False (){
        //Arrange
        when (vehicleRepository.getMotorcycle(motorcycle.getPlate())).thenReturn(motorcycle);
        when(parkingSpaceOperations.getTimeMotorcycle(motorcycle.getPlate())).thenReturn(previosDate);
        when (billOperations.calculateTime(currentDate, currentDate)).thenReturn(minuts);
        when (billOperations.calculateCost(minuts, motorcycle.getCylindrical(), 1)).thenReturn((long) 10);
        when(vehicleRepository.deleteMotorcycle(motorcycle.getPlate())).thenReturn(false);
        when (parkingSpaceOperations.freeUpSpace(motorcycle.getFkParkingSpace())).thenReturn(true);
        //Act
        boolean result = vehicleOperations.checkOutMotorcycle(motorcycle).state;
        //Assert
        Assert.assertFalse(result);
    }

    @Test
    public void checkoutCar_ProblemWithDeleteCarFromDatabase_False (){
        //Arrange
        when (vehicleRepository.getCar(car.getPlate())).thenReturn(car);
        when(parkingSpaceOperations.getTimeCar(car.getPlate())).thenReturn(previosDate);
        when (billOperations.calculateTime(currentDate, currentDate)).thenReturn(minuts);
        when (billOperations.calculateCost(minuts, 100, 1)).thenReturn((long) 10);
        when(vehicleRepository.deleteCar(car.getPlate())).thenReturn(false);
        when (parkingSpaceOperations.freeUpSpace(car.getFkParkingSpace())).thenReturn(true);
        //Act
        boolean result = vehicleOperations.checkoutCar(car).state;
        //Assert
        Assert.assertFalse(result);
    }

    @Test
    public void checkoutCar_DeleteFromDataBase_Success (){
        //Arrange
        when (vehicleRepository.getCar(car.getPlate())).thenReturn(car);
        when(parkingSpaceOperations.getTimeCar(car.getPlate())).thenReturn(previosDate);
        when (billOperations.calculateTime(currentDate, currentDate)).thenReturn(minuts);
        when (billOperations.calculateCost(minuts, 100, 1)).thenReturn((long) 10);
        when(vehicleRepository.deleteCar(car.getPlate())).thenReturn(true);
        when (parkingSpaceOperations.freeUpSpace(car.getFkParkingSpace())).thenReturn(true);
        boolean result = vehicleOperations.checkoutCar(car).state;
        Assert.assertTrue(result);
    }


}