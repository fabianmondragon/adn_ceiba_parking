package com.example.parkingapp.data.database;

import org.junit.Test;

import static org.junit.Assert.*;

public class CilindrajeRulesTest {

    @Test
    public void validate_Construct_CilindrajeRules_getSTate (){
        CilindrajeRules cilindrajeRules = new CilindrajeRules(500, 0);
        assertTrue(cilindrajeRules.getState() == 0);
    }

    @Test
    public void validate_Construct_CilindrajeRules_getCilindraje (){
        CilindrajeRules cilindrajeRules = new CilindrajeRules(500, 0);
        assertTrue(cilindrajeRules.getCilindraje_moto() == 500);

    }

    @Test
    public void validate_Construct_CilindrajeRules_setCilindraje (){
        CilindrajeRules cilindrajeRules = new CilindrajeRules(500, 0);
        cilindrajeRules.setCilindraje_moto(700);
        assertTrue(cilindrajeRules.getCilindraje_moto() == 700);
    }


    @Test
    public void validate_Construct_CilindrajeRules_setState (){
        CilindrajeRules cilindrajeRules = new CilindrajeRules(500, 0);
        cilindrajeRules.setState(1);
        assertTrue(cilindrajeRules.getState() == 1);
    }

}