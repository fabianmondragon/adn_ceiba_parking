package com.example.parkingapp.domain;


import com.example.parkingapp.domain.model.CylindricalRules;
import com.example.parkingapp.domain.model.lParkingDetail;
import com.example.parkingapp.domain.model.Tariff;
import com.example.parkingapp.domain.services.Bill;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;


public class DomainBillTest {

    private Date actual;
    private Date saveData;
    private lParkingDetail lParkingDetail;
    private Bill bill;
    private Tariff tariff;
    private CylindricalRules cylindricalRules;

    @Before
    public void config() {
        actual = new Date(2020, 2, 9, 3, 00, 0);
        saveData = new Date(2020, 2, 8, 00, 00, 0);
        bill = new Bill();
        tariff = new Tariff(1000.0, 500.0, 8000.0, 4000.0, 100.0);
        cylindricalRules = new CylindricalRules(650, 1);
    }

    @Test
    public void calculateTime_validCaculedTime_Test() {
        long diffInMillies = Math.abs(actual.getTime() - saveData.getTime());
        long minuts = TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS);
        lParkingDetail = new lParkingDetail(minuts);
        assertThat(lParkingDetail.getNumberMinuts(), is(equalTo((bill.calculateTime(actual, saveData)).getNumberMinuts())));
    }

    @Test
    public void calculateTime_invalidCaculedTime_Test() {
        long diffInMillies = Math.abs(actual.getTime() - saveData.getTime());
        long minuts = TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MINUTES);
        lParkingDetail = new lParkingDetail(minuts);
        assertNotEquals(lParkingDetail.getNumberMinuts(), bill.calculateTime(actual, saveData).getNumberMinuts());

    }

    @Test
    public void calculateCost_valid_motoCycleta() {
        actual = new Date(2020, 2, 9, 3, 00, 0);
        saveData = new Date(2020, 2, 8, 00, 00, 0);
        bill = new Bill();
        tariff = new Tariff(1000.0, 500.0, 8000.0, 4000.0, 100.0);
        cylindricalRules = new CylindricalRules(650, 1);
        long diffInMillies = Math.abs(actual.getTime() - saveData.getTime());
        long minuts = TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS);
        lParkingDetail = new lParkingDetail(minuts);
        long result = bill.calculateCost(lParkingDetail, tariff, cylindricalRules, 100);
        assertEquals(5500, result);
    }

    @Test
    public void calculateCost_valid_Car() {
        actual = new Date(2020, 2, 9, 3, 00, 0);
        saveData = new Date(2020, 2, 8, 00, 00, 0);
        bill = new Bill();
        tariff = new Tariff(1000.0, 500.0, 8000.0, 4000.0, 100.0);
        cylindricalRules = null;
        long diffInMillies = Math.abs(actual.getTime() - saveData.getTime());
        long minuts = TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS);
        lParkingDetail = new lParkingDetail(minuts);
        long result = bill.calculateCost(lParkingDetail, tariff, cylindricalRules, 100);
        assertEquals(11000, result);
    }
}