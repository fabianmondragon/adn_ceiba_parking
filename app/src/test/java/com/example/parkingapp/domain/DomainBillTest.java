package com.example.parkingapp.domain;


import com.example.parkingapp.domain.model.DomainCilindrajeRules;
import com.example.parkingapp.domain.model.DomainDetailParking;
import com.example.parkingapp.domain.model.DomainTariff;
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
    private DomainDetailParking domainDetailParking;
    private DomainBill domainBill;
    private DomainTariff domainTariff;
    private DomainCilindrajeRules domainCilindrajeRules;

    @Before
    public void config (){
        actual = new Date(2020, 2, 9, 3, 00, 0);
        saveData = new Date( 2020, 2, 8, 00, 00, 0);
        domainBill = new DomainBill();
        domainTariff = new DomainTariff(  1000.0, 500.0, 8000.0, 4000.0, 100.0);
        domainCilindrajeRules = new DomainCilindrajeRules(650, 1);
    }

    @Test
    public void calculateTime_validCaculedTime_Test() {
        long diffInMillies = Math.abs(actual.getTime() - saveData.getTime());
        long minuts = TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS);
        domainDetailParking = new DomainDetailParking(minuts);
        assertThat(domainDetailParking.getNumberMinuts(), is(equalTo((domainBill.calculateTime(actual, saveData)).getNumberMinuts())) );
    }
    @Test
    public void calculateTime_invalidCaculedTime_Test() {
        long diffInMillies = Math.abs(actual.getTime() - saveData.getTime());
        long minuts = TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MINUTES);
        domainDetailParking = new DomainDetailParking(minuts);
        assertNotEquals(domainDetailParking.getNumberMinuts(), domainBill.calculateTime(actual, saveData).getNumberMinuts());

    }
    @Test
    public void calculateCost_valid_motoCycleta() {
        actual = new Date(2020, 2, 9, 3, 00, 0);
        saveData = new Date( 2020, 2, 8, 00, 00, 0);
        domainBill = new DomainBill();
        domainTariff = new DomainTariff(  1000.0, 500.0, 8000.0, 4000.0, 100.0);
        domainCilindrajeRules = new DomainCilindrajeRules(650, 1);
        long diffInMillies = Math.abs(actual.getTime() - saveData.getTime());
        long minuts = TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS);
        domainDetailParking = new DomainDetailParking(minuts);
        long result = domainBill.calculateCost(domainDetailParking, domainTariff, domainCilindrajeRules, 100 );
        assertEquals(5500, result);
    }

    @Test
    public void calculateCost_valid_Car() {
        actual = new Date(2020, 2, 9, 3, 00, 0);
        saveData = new Date( 2020, 2, 8, 00, 00, 0);
        domainBill = new DomainBill();
        domainTariff = new DomainTariff(  1000.0, 500.0, 8000.0, 4000.0, 100.0);
        domainCilindrajeRules = null;
        long diffInMillies = Math.abs(actual.getTime() - saveData.getTime());
        long minuts = TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS);
        domainDetailParking = new DomainDetailParking(minuts);
        long result = domainBill.calculateCost(domainDetailParking, domainTariff, domainCilindrajeRules, 100 );
        assertEquals(11000, result);
    }
}