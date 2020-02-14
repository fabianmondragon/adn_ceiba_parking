package com.example.parkingapp.data;

import com.example.parkingapp.data.database.entity.CilindrajeRulesEntity;
import com.example.parkingapp.data.repository.CilindrajeImpl;
import com.example.parkingapp.domain.services.DataBaseAdministration;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CilindrajeImplTest {
    DataBaseAdministration dataBaseAdministration;
    CilindrajeImpl cilindrajeImpl;

    @Before
    public void config() {
        dataBaseAdministration = new DataBaseAdministration();
        cilindrajeImpl = new CilindrajeImpl();
        dataBaseAdministration.fillDataBase();
    }

    @Test
    public void getActiviteCilindraje_shouldreturn_theActive() {
        CilindrajeRulesEntity cilindrajeRulesEntity = cilindrajeImpl.getActiveCilindraje();
        Assert.assertTrue(cilindrajeRulesEntity.getState() == 1);

    }

}