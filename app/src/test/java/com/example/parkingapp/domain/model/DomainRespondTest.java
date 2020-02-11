package com.example.parkingapp.domain.model;

import net.bytebuddy.build.ToStringPlugin;

import org.junit.Test;

import static org.junit.Assert.*;

public class DomainRespondTest {

    @Test
    public void validate_GettersAndSetter (){
        DomainRespond domainRespond = new DomainRespond();
        domainRespond.setTipeTransaction(1);
        domainRespond.setMsg("success");
        domainRespond.setState(true);
        assertTrue(domainRespond.getTipeTransaction() ==1);
        assertTrue(domainRespond.isState() ==true);
    }

}