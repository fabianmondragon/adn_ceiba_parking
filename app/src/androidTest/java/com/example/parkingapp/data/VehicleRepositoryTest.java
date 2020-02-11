package com.example.parkingapp.data;

import androidx.room.Room;
import androidx.test.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.parkingapp.data.database.Car;
import com.example.parkingapp.data.database.CarDao;
import com.example.parkingapp.data.database.Parking;
import com.example.parkingapp.data.database.ParkingSpace;
import com.example.parkingapp.domain.DomainManageDataBase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class VehicleRepositoryTest {
    private CeibaDataBase mDatabase;
    private CarDao carDao;
    private VehicleRepository vehicleRepository;
    private SpaceParkingRepository parkingRepository;
    private DomainManageDataBase domainManageDataBase;
    @Before
    public void initDb() throws Exception {
        domainManageDataBase = new DomainManageDataBase();
        parkingRepository = new SpaceParkingRepository();
        vehicleRepository = new VehicleRepository();
        mDatabase = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(),
                CeibaDataBase.class)
                .allowMainThreadQueries()
                .build();
        carDao = mDatabase.carDao();
        domainManageDataBase.fillDataBase();
    }

    @Test
    public void getCarsDataBase_shouldGetEmptyList_IfTable_IsEmpty() throws InterruptedException {
        domainManageDataBase.freeSpaceDataBase();
        List<Car> noteList = carDao.getAll();
        assertTrue(noteList.isEmpty());
    }

    @Test
    public void getCarsDataBase_shoudGetEmptyList_IfDataB_isFill () throws  InterruptedException {
        assertTrue(vehicleRepository.getListCar().isEmpty());
    }

    @Test
    public void getCarsDataBase_shoudGetOneCar_IfTable_isHasONe () throws  InterruptedException {
        domainManageDataBase.freeSpaceDataBase();
        List<ParkingSpace> listParking = parkingRepository.getParkingSpace();
        vehicleRepository.setCar(new Car("LM0254", 1));
        int num = vehicleRepository.getListCar().size();
        assertTrue(num == 1);
    }


}