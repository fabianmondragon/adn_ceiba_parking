package com.example.parkingapp.data;

import com.example.parkingapp.data.database.entity.ParkingEntity;
import com.example.parkingapp.data.repository.ParkingImpl;
import com.example.parkingapp.domain.services.DataBaseAdministration;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class ParkingEntityImplTest {

    ParkingImpl parkingImpl;
    DataBaseAdministration dataBaseAdministration;

    @Before
    public void config() {
        parkingImpl = new ParkingImpl();
        dataBaseAdministration = new DataBaseAdministration();
    }

    @Test
    public void getParking_getAllParkingLinst_ShouldRetunr_oneParking() {
        dataBaseAdministration.fillDataBase();
        List<ParkingEntity> parkingEntityList = parkingImpl.getParking();
        assertTrue(parkingEntityList.size() == 1);

    }

}