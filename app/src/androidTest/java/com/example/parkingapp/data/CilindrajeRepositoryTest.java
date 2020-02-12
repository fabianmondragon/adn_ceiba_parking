package com.example.parkingapp.data;

import com.example.parkingapp.data.database.CilindrajeRules;
import com.example.parkingapp.domain.DomainManageDataBase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CilindrajeRepositoryTest {
    DomainManageDataBase domainManageDataBase;
    CilindrajeRepository cilindrajeRepository;

    @Before
    public void config() {
        domainManageDataBase = new DomainManageDataBase();
        cilindrajeRepository = new CilindrajeRepository();
        domainManageDataBase.fillDataBase();
    }

    @Test
    public void getActiviteCilindraje_shouldreturn_theActive() {
        CilindrajeRules cilindrajeRules = cilindrajeRepository.getActiveCilindraje();
        Assert.assertTrue(cilindrajeRules.getState() == 1);

    }

}