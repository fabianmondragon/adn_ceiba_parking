package com.example.parkingapp.domain;

import org.junit.Before;
import org.junit.Test;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class DomainValidationsParkingTest {
    DomainValidationsParking domainValidationsParking;

    @Before
    public void  config (){
        domainValidationsParking = new DomainValidationsParking();
    }

    @Test
    public void isValid_FieldWithRule_Test() {
        assertThat(true, is (equals(domainValidationsParking.isValid("A"))) );
    }
    @Test
    public void isValid_FieldWithEmptyField_Test() {
        assertThat(true, is (equals(domainValidationsParking.isValid(""))) );
    }

    /*
    *  public boolean isValid (String plateId){
        int day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        if (plateId.startsWith("A")){
            if (day == 1 || day ==2) {
                return true;
            }
            return false;
        }
        return true;
    }
    * */
}