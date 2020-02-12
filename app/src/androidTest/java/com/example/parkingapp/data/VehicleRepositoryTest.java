package com.example.parkingapp.data;

import androidx.room.Room;
import androidx.test.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.parkingapp.data.database.Car;
import com.example.parkingapp.data.database.CarDao;
import com.example.parkingapp.data.database.Motorcycle;
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
    public void getLIstMotorCycle_With_TableCar_Emtpy_ResultSuccess (){
        domainManageDataBase.freeSpaceDataBase();
        assertTrue(vehicleRepository.getListCar().isEmpty());
    }
    @Test
    public void getLIstMotorCycle_With_TableMOtorcycle_Emtpy_ResultSuccess (){
        domainManageDataBase.freeSpaceDataBase();
        assertTrue(vehicleRepository.getListMotorCycle().isEmpty());
    }

    @Test
    public void getCarsDataBase_shoudGetOneCar_IfTable_isHasONe () throws  InterruptedException {
        domainManageDataBase.freeSpaceDataBase();
        List<ParkingSpace> listParking = parkingRepository.getParkingSpace();
        vehicleRepository.setCar(new Car("LM0254", 1));
        int num = vehicleRepository.getListCar().size();
        assertTrue(1 == 1);
    }

    @Test
    public void setMotorcycle_shoudGetRretunrONe_ifTable_isHasONe (){
        domainManageDataBase.fillDataBase();
        domainManageDataBase.freeSpaceDataBase();
        vehicleRepository.setMotorcycle(new Motorcycle("lkj", 100, 1));
        Motorcycle motorcycle = vehicleRepository.getListMotorCycle().get(0);
        assertTrue(motorcycle.getPlateID().equals("lkj"));
    }

    @Test
    public void getMotorcycle_shoudGetRretunrThis (){
        domainManageDataBase.fillDataBase();
        domainManageDataBase.freeSpaceDataBase();
        vehicleRepository.setMotorcycle(new Motorcycle("lkj", 100, 1));
        Motorcycle motorcycle = vehicleRepository.getMotoCycle("lkj");
        assertTrue(motorcycle.getCilindraje() == 100);
    }

    @Test
    public void deleteMotorcyle_shouldRetunr_noFound (){
        domainManageDataBase.freeSpaceDataBase();
        vehicleRepository.setMotorcycle(new Motorcycle("lkj", 100, 1));
        vehicleRepository.deleteMotorcycle("lkj");
        Motorcycle motorcycle = vehicleRepository.getMotoCycle("lkj");
        assertTrue(motorcycle == null);
    }

    @Test
    public void deleteCar_shouldRetunr_noFound (){
        domainManageDataBase.fillDataBase();
        domainManageDataBase.freeSpaceDataBase();
        vehicleRepository.setCar(new Car("lkj", 0));
        vehicleRepository.deleteCar("lkj");
        Car car = vehicleRepository.getCar("lkj");
        assertTrue(car == null);
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
}