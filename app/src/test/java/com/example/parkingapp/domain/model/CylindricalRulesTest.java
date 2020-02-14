package com.example.parkingapp.domain.model;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CylindricalRulesTest {

    @Test
    public void validate_Construct_WithParams() {
        CylindricalRules cylindricalRules = new CylindricalRules(100, 1);
        assertTrue(cylindricalRules.getState() == 1);
        assertTrue(cylindricalRules.getState() == 1);

    }

    @Test
    public void validate_Construct_Secondary_WithParams() {
        CylindricalRules cylindricalRules = new CylindricalRules(100);
        assertTrue(cylindricalRules.getCilindrage() == 100);
    }

}