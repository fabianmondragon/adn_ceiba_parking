package com.example.parkingapp.domain.operations;

import com.example.parkingapp.domain.model.Tariff;

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


public class BillOperationsTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @InjectMocks
    BillOperations billOperations;
    @Mock CylindricalRulesOperations cylindricalRulesOperations;
    @Mock TariffOperations tariffOperations;
    @Mock Tariff tariff;

    @Before
    public void config (){
        tariff = new Tariff(1000.0, 500.0, 8000.0, 4000.0, 2000.0);
    }

    @Test
    public void calculateTime_TwoHoursDifference_Success (){
        //Arrange
        Date currentDate = Calendar.getInstance().getTime();
        Date dateMinusTwoHours = new Date();
        Long minusTwoHours = currentDate.getTime() - (60000L * 120L);
        dateMinusTwoHours.setTime(minusTwoHours);
        //Act
        long result = billOperations.calculateTime(currentDate, dateMinusTwoHours);
        long hours = result/60;
        //Assert
        Assert.assertEquals(2, hours );
    }

    @Test
    public void calculateTime_TreeHoursDifference_Success (){
        //Arrange
        Date currentDate = Calendar.getInstance().getTime();
        Date dateLessThanTwoHours = new Date();
        Long minusThreeHours = currentDate.getTime() - (60000L * 180L);
        dateLessThanTwoHours.setTime(minusThreeHours);
        //Act
        long result = billOperations.calculateTime(currentDate, dateLessThanTwoHours);
        long hours = result/60;
        //Assert
        Assert.assertEquals(3, hours);


    }

    @Test
    public void calculateCost_TwoHoursMotorcycleCylindrical100_1000(){
        //Arrange
        Date currentDate = Calendar.getInstance().getTime();
        Date dateMinusTwoHours = new Date();
        Long minusTwoHours = currentDate.getTime() - (60000L * 120L);
        dateMinusTwoHours.setTime(minusTwoHours);
        when (tariffOperations.getTariff()).thenReturn(tariff);
        //Act
        long cost = billOperations.calculateCost(120L, 100, 1);
        //Assert
        Assert.assertEquals(1000L, cost);
    }

    @Test
    public void calculateCost_OneDayAndThreeHoursMotorcycleCylindrical100_Success(){
        //Arrange
        long numberMinuts = 27*60;
        when (tariffOperations.getTariff()).thenReturn(tariff);
        //Act
        long cost = billOperations.calculateCost(numberMinuts, 100, 1);
        //Assert
        Assert.assertEquals(5500L, cost);
    }

    @Test
    public void calculateCost_TenHoursMotorcycle650CC_Success(){
        //Arrange
        long numberMinuts = 10*60;
        when (tariffOperations.getTariff()).thenReturn(tariff);
        //Act
        long cost = billOperations.calculateCost(numberMinuts, 650, 1);
        //Assert
        Assert.assertEquals(6000L, cost );
    }

    @Test
    public void calculateCost_OneDayAndThreeHoursCar_Success(){
        //Arrange
        long numberMinuts = 27*60;
        when (tariffOperations.getTariff()).thenReturn(tariff);
        //Act
        long cost = billOperations.calculateCost(numberMinuts, 100, 2);
        //Assert
        Assert.assertEquals( 11000L, cost);
    }


}