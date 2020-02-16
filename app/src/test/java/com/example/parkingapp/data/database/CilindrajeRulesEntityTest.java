package com.example.parkingapp.data.database;

import com.example.parkingapp.data.database.entity.CilindrajeRulesEntity;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CilindrajeRulesEntityTest {

    @Test
    public void validate_Construct_CilindrajeRules_getSTate() {
        CilindrajeRulesEntity cilindrajeRulesEntity = new CilindrajeRulesEntity(500, 0);
        assertTrue(cilindrajeRulesEntity.getState() == 0);
    }

    @Test
    public void validate_Construct_CilindrajeRules_getCilindraje() {
        CilindrajeRulesEntity cilindrajeRulesEntity = new CilindrajeRulesEntity(500, 0);
        assertTrue(cilindrajeRulesEntity.getCylindricalMotorcycleta() == 500);

    }

    @Test
    public void validate_Construct_CilindrajeRules_setCilindraje() {
        CilindrajeRulesEntity cilindrajeRulesEntity = new CilindrajeRulesEntity(500, 0);
        cilindrajeRulesEntity.setCylindricalMotorcycleta(700);
        assertTrue(cilindrajeRulesEntity.getCylindricalMotorcycleta() == 700);
    }


    @Test
    public void validate_Construct_CilindrajeRules_setState() {
        CilindrajeRulesEntity cilindrajeRulesEntity = new CilindrajeRulesEntity(500, 0);
        cilindrajeRulesEntity.setState(1);
        assertTrue(cilindrajeRulesEntity.getState() == 1);
    }

}