package com.example.parkingapp.data.database;

import com.example.parkingapp.data.database.entity.TariffEntity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TariffEntityTest {
    TariffEntity tariffEntity;

    @Before
    public void config() {
        tariffEntity = new TariffEntity(1000.0, 500.0, 8000.0, 5000.0, 2000.0);
    }

    @Test
    public void verify_SetAngGet_TafiffId() {
        tariffEntity.setTariffId(10);
        assertTrue(tariffEntity.getTariffId() == 10);
    }

    @Test
    public void verify_SetAndGet_getValueHorCar() {
        assertTrue(tariffEntity.getValueHorCar() == 1000.0);
    }

    @Test
    public void verify_SetAndGet_getValueHorMoto() {
        assertTrue(tariffEntity.getValueHorMoto() == 500.0);
    }

    @Test
    public void verify_SetAndGet_getValueDayCar() {
        assertTrue(tariffEntity.getValueDayCar() == 8000.0);
    }

    @Test
    public void verify_SetAndGet_getValueDayMotor() {
        assertTrue(tariffEntity.getValueDayMoto() == 5000.0);
    }

    @Test
    public void verify_SetAndGet_getValueCilindrajeMOto() {
        assertTrue(tariffEntity.getValueCilindrajeMoto() == 2000.0);
    }

}