package com.example.parkingapp.domain;

import com.example.parkingapp.domain.services.Validation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ValidationTest {
    Validation validation;

    @Before
    public void config() {
        validation = new Validation();
    }

    @Test
    public void isValid_FieldWithRule_Test() {
        Boolean b = validation.isValid("A");
        Assert.assertEquals(true, validation.isValid("A"));

    }

    @Test
    public void isValid_FieldWithEmptyField_Test() {
        Assert.assertEquals(true, validation.isValid("A"));
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