package com.example.parkingapp.data;

import com.example.parkingapp.data.database.ParkingSpace;
import com.example.parkingapp.domain.DomainManageDataBase;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertTrue;

public class SpaceParkingRepositoryTest {

    private SpaceParkingRepository spaceParkingRepository;
    private DomainManageDataBase domainManageDataBase;


    @Before
    public void config() {
        spaceParkingRepository = new SpaceParkingRepository();
        domainManageDataBase = new DomainManageDataBase();
        domainManageDataBase.fillDataBase();


    }

    @Test
    public void updateParkingSpaceDate() {
        Date date = Calendar.getInstance().getTime();
        spaceParkingRepository.updateParkingSpace(1, date);
        ParkingSpace parkingSpace = spaceParkingRepository.getOneParkingSpace(1);
        domainManageDataBase.freeSpaceDataBase();
        assertTrue(parkingSpace.getStartOcupation().getTime() == date.getTime());
    }

    @Test
    public void getFreeShould_return_one() {
        domainManageDataBase.freeSpaceDataBase();
        assertTrue(spaceParkingRepository.getFree() == 1);
    }

    @Test
    public void getFree_Should_return_uno() {
        domainManageDataBase.freeSpaceDataBase();
        domainManageDataBase.fillDataBase();
        int num = spaceParkingRepository.getFree();
        assertTrue(num == 1);
    }

    @Test
    public void getParkingSpace_Should_return_30() {
        SpaceParkingRepository spaceParkingRepository = new SpaceParkingRepository();
        DomainManageDataBase domainManageDataBase = new DomainManageDataBase();
        domainManageDataBase.fillDataBase();
        ;
        assertTrue(spaceParkingRepository.getParkingSpace().size() == 30);
    }

    @Test
    public void getOneParkingSpace_Should_return_first() {
        SpaceParkingRepository spaceParkingRepository = new SpaceParkingRepository();
        DomainManageDataBase domainManageDataBase = new DomainManageDataBase();
        domainManageDataBase.fillDataBase();

        assertTrue(spaceParkingRepository.getOneParkingSpace(1).isState() == false);
    }


}