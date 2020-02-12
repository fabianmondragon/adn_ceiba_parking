package com.example.parkingapp.data.database;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TariffTest {
    Tariff tariff;

    @Before
    public void config (){
        tariff = new Tariff(1000.0, 500.0, 8000.0, 5000.0, 2000.0);
    }

    @Test
    public void verify_SetAngGet_TafiffId(){
        tariff.setTariffId(10);
        assertTrue (tariff.getTariffId() == 10);
    }

    @Test
    public void verify_SetAndGet_getValueHorCar(){
        assertTrue (tariff.getValueHorCar() == 1000.0);
    }

    @Test
    public void verify_SetAndGet_getValueHorMoto(){
        assertTrue (tariff.getValueHorMoto() == 500.0);
    }

    @Test
    public void verify_SetAndGet_getValueDayCar(){
        assertTrue (tariff.getValueDayCar() == 8000.0);
    }

    @Test
    public void verify_SetAndGet_getValueDayMotor(){
        assertTrue (tariff.getValueDayMoto() == 5000.0);
    }

    @Test
    public void verify_SetAndGet_getValueCilindrajeMOto(){
        assertTrue (tariff.getValueCilindrajeMoto() == 2000.0);
    }

}