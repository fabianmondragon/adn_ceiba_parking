package com.example.parkingapp.domain.model;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DomainRespondTest {

    @Test
    public void validate_GettersAndSetter() {
        DomainRespond domainRespond = new DomainRespond();
        domainRespond.setTransactionType(1);
        domainRespond.setMsg("success");
        domainRespond.setState(true);
        assertTrue(domainRespond.getTransactionType() == 1);
        assertTrue(domainRespond.isState() == true);
    }

}