package com.example.parkingapp.domain.model;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DomainCilindrajeRulesTest {

    @Test
    public void validate_Construct_WithParams() {
        DomainCilindrajeRules domainCilindrajeRules = new DomainCilindrajeRules(100, 1);
        assertTrue(domainCilindrajeRules.getState() == 1);
        assertTrue(domainCilindrajeRules.getState() == 1);

    }

    @Test
    public void validate_Construct_Secondary_WithParams() {
        DomainCilindrajeRules domainCilindrajeRules = new DomainCilindrajeRules(100);
        assertTrue(domainCilindrajeRules.getCilindrage() == 100);
    }

}