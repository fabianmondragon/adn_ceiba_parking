package com.example.parkingapp.domain.model;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TariffEntityTest {
    @Test
    public void validate_ConstructWithParams_Tariff() {
        Tariff tariff = new Tariff(100.0, 500.0, 8000.0, 7000.0, 2000.0);
        assertTrue(tariff.getValueCilindrajeMoto() == 2000);
        assertTrue(tariff.getValueDayCar() == 8000);
        assertTrue(tariff.getValueDayMoto() == 7000);
        assertTrue(tariff.getValueHorCar() == 100);
        assertTrue(tariff.getValueHorMoto() == 500);

    }

}