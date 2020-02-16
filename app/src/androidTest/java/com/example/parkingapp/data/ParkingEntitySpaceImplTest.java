package com.example.parkingapp.data;

import com.example.parkingapp.data.database.entity.ParkingSpaceEntitiy;
import com.example.parkingapp.data.repository.ParkingSpaceRepositoryImpl;
import com.example.parkingapp.domain.services.DataBaseAdministration;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertTrue;

public class ParkingEntitySpaceImplTest {

    private ParkingSpaceRepositoryImpl parkingSpaceImpl;
    private DataBaseAdministration dataBaseAdministration;


    @Before
    public void config() {
        parkingSpaceImpl = new ParkingSpaceRepositoryImpl();
        dataBaseAdministration = new DataBaseAdministration();
        dataBaseAdministration.fillDataBase();


    }

    @Test
    public void updateParkingSpaceDate() {
        Date date = Calendar.getInstance().getTime();
        parkingSpaceImpl.updateParkingSpace(1, date);
        ParkingSpaceEntitiy parkingSpaceEntitiy = parkingSpaceImpl.getOneParkingSpace(1);
        dataBaseAdministration.freeSpaceDataBase();
        assertTrue(parkingSpaceEntitiy.getStartOcupation().getTime() == date.getTime());
    }

    @Test
    public void getFreeShould_return_one() {
        dataBaseAdministration.freeSpaceDataBase();
        assertTrue(parkingSpaceImpl.getFree() == 1);
    }

    @Test
    public void getFree_Should_return_uno() {
        dataBaseAdministration.freeSpaceDataBase();
        dataBaseAdministration.fillDataBase();
        int num = parkingSpaceImpl.getFree();
        assertTrue(num == 1);
    }

    @Test
    public void getParkingSpace_Should_return_30() {
        ParkingSpaceRepositoryImpl parkingSpaceImpl = new ParkingSpaceRepositoryImpl();
        DataBaseAdministration dataBaseAdministration = new DataBaseAdministration();
        dataBaseAdministration.fillDataBase();
        ;
        assertTrue(parkingSpaceImpl.getParkingSpace().size() == 30);
    }

    @Test
    public void getOneParkingSpace_Should_return_first() {
        ParkingSpaceRepositoryImpl parkingSpaceImpl = new ParkingSpaceRepositoryImpl();
        DataBaseAdministration dataBaseAdministration = new DataBaseAdministration();
        dataBaseAdministration.fillDataBase();

        assertTrue(parkingSpaceImpl.getOneParkingSpace(1).isState() == false);
    }


}