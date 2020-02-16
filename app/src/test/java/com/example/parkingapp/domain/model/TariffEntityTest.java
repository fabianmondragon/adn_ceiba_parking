package com.example.parkingapp.domain.model;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TariffEntityTest {
    @Test
    public void validate_ConstructWithParams_Tariff() {
        Tariff tariff = new Tariff(100.0, 500.0, 8000.0, 7000.0, 2000.0);
        assertTrue(tariff.getMotorcycleCylindrical() == 2000);
        assertTrue(tariff.getCarDayCost() == 8000);
        assertTrue(tariff.getMotorcycleDayCost() == 7000);
        assertTrue(tariff.getCarHourCost() == 100);
        assertTrue(tariff.getMotorcycleHourCost() == 500);

    }

}