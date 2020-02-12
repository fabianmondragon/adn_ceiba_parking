package com.example.parkingapp.data;

import com.example.parkingapp.data.database.Parking;
import com.example.parkingapp.domain.DomainManageDataBase;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ParkingRepositoryTest {

    ParkingRepository parkingRepository;
    DomainManageDataBase domainManageDataBase;
    @Before
    public void config(){
        parkingRepository = new ParkingRepository();
        domainManageDataBase = new DomainManageDataBase();
    }

    @Test
    public void getParking_getAllParkingLinst_ShouldRetunr_oneParking(){
        domainManageDataBase.fillDataBase();
        List<Parking> parkingList =parkingRepository.getParking();
        assertTrue(parkingList.size() == 1);

    }

}