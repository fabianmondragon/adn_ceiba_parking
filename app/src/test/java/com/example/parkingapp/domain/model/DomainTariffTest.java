package com.example.parkingapp.domain.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class DomainTariffTest {
    @Test
    public void validate_ConstructWithParams_Tariff (){
        DomainTariff domainTariff = new DomainTariff( 100.0, 500.0, 8000.0, 7000.0, 2000.0);
        assertTrue(domainTariff.getValueCilindrajeMoto()==2000);
        assertTrue(domainTariff.getValueDayCar()==8000);
        assertTrue(domainTariff.getValueDayMoto()==7000);
        assertTrue(domainTariff.getValueHorCar()==100);
        assertTrue(domainTariff.getValueHorMoto()==500);

    }

}