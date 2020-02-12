package com.example.parkingapp.data;

import com.example.parkingapp.data.database.Tariff;
import com.example.parkingapp.domain.DomainManageDataBase;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TariffRepositoryTest {

    @Test
    public void getTariff_shouldreturnONE() {
        DomainManageDataBase domainManageDataBase = new DomainManageDataBase();
        domainManageDataBase.fillDataBase();
        TariffRepository tariff = new TariffRepository();
        Tariff tariff1 = tariff.getTariff();
        assertTrue(tariff1 != null);

    }

}