package com.example.parkingapp.domain.model;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DomainRespondTest {

    @Test
    public void validate_GettersAndSetter() {
        DomainRespond domainRespond = new DomainRespond();
        domainRespond.setTipeTransaction(1);
        domainRespond.setMsg("success");
        domainRespond.setState(true);
        assertTrue(domainRespond.getTipeTransaction() == 1);
        assertTrue(domainRespond.isState() == true);
    }

}