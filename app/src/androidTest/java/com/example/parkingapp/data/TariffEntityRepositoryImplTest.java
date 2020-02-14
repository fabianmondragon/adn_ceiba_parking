package com.example.parkingapp.data;

import com.example.parkingapp.data.database.entity.TariffEntity;
import com.example.parkingapp.data.repository.TariffRepositoryImpl;
import com.example.parkingapp.domain.services.DataBaseAdministration;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TariffEntityRepositoryImplTest {

    @Test
    public void getTariff_shouldreturnONE() {
        DataBaseAdministration dataBaseAdministration = new DataBaseAdministration();
        dataBaseAdministration.fillDataBase();
        TariffRepositoryImpl tariff = new TariffRepositoryImpl();
        TariffEntity tariffEntity1 = tariff.getTariff();
        assertTrue(tariffEntity1 != null);

    }

}