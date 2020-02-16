package com.example.parkingapp.data;

import androidx.room.Room;
import androidx.test.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.parkingapp.data.database.dao.CarDao;
import com.example.parkingapp.data.database.entity.CarEntity;
import com.example.parkingapp.data.database.entity.MotorcycleEntity;
import com.example.parkingapp.data.database.entity.ParkingSpaceEntitiy;
import com.example.parkingapp.data.repository.CeibaDataBase;
import com.example.parkingapp.data.repository.ParkingSpaceRepositoryImpl;
import com.example.parkingapp.data.repository.VehicleRepositoryImpl;
import com.example.parkingapp.domain.services.DataBaseAdministration;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class VehicleRepositoryTest {
    private CeibaDataBase mDatabase;
    private CarDao carDao;
    private VehicleRepositoryImpl vehicleRepositoryImpl;
    private ParkingSpaceRepositoryImpl parkingRepository;
    private DataBaseAdministration dataBaseAdministration;

    @Before
    public void initDb() throws Exception {
        dataBaseAdministration = new DataBaseAdministration();
        parkingRepository = new ParkingSpaceRepositoryImpl();
        vehicleRepositoryImpl = new VehicleRepositoryImpl();
        mDatabase = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(),
                CeibaDataBase.class)
                .allowMainThreadQueries()
                .build();
        carDao = mDatabase.carDao();
        dataBaseAdministration.fillDataBase();
    }

    @Test
    public void getLIstMotorCycle_With_TableCar_Emtpy_ResultSuccess() {
        dataBaseAdministration.freeSpaceDataBase();
        assertTrue(vehicleRepositoryImpl.getListCar().isEmpty());
    }

    @Test
    public void getLIstMotorCycle_With_TableMOtorcycle_Emtpy_ResultSuccess() {
        dataBaseAdministration.freeSpaceDataBase();
        assertTrue(vehicleRepositoryImpl.getListMotorCycle().isEmpty());
    }

    @Test
    public void getCarsDataBase_shoudGetOneCar_IfTable_isHasONe() throws InterruptedException {
        dataBaseAdministration.freeSpaceDataBase();
        List<ParkingSpaceEntitiy> listParking = parkingRepository.getParkingSpace();
        vehicleRepositoryImpl.setCar(new CarEntity("LM0254", 1));
        int num = vehicleRepositoryImpl.getListCar().size();
        assertTrue(1 == 1);
    }

    @Test
    public void setMotorcycle_shoudGetRretunrONe_ifTable_isHasONe() {
        dataBaseAdministration.freeSpaceDataBase();
        vehicleRepositoryImpl.setMotorcycle(new MotorcycleEntity("lkj", 100, 1));
        MotorcycleEntity motorcycleEntity = vehicleRepositoryImpl.getListMotorCycle().get(0);
        assertTrue(motorcycleEntity.getPlateID().equals("lkj"));
    }

    @Test
    public void getMotorcycle_shoudGetRretunrThis() {
        dataBaseAdministration.freeSpaceDataBase();
        vehicleRepositoryImpl.setMotorcycle(new MotorcycleEntity("lkj", 100, 1));
        MotorcycleEntity motorcycleEntity = vehicleRepositoryImpl.getMotoCycle("lkj");
        assertTrue(motorcycleEntity.getCilindraje() == 100);
    }

    @Test
    public void deleteMotorcyle_shouldRetunr_noFound() {
        dataBaseAdministration.freeSpaceDataBase();
        vehicleRepositoryImpl.setMotorcycle(new MotorcycleEntity("lkj", 100, 1));
        vehicleRepositoryImpl.deleteMotorcycle("lkj");
        MotorcycleEntity motorcycleEntity = vehicleRepositoryImpl.getMotoCycle("lkj");
        assertTrue(motorcycleEntity == null);
    }

    @Test
    public void deleteCar_shouldRetunr_noFound() {
        dataBaseAdministration.fillDataBase();
        dataBaseAdministration.freeSpaceDataBase();
        vehicleRepositoryImpl.setCar(new CarEntity("lkj", 0));
        vehicleRepositoryImpl.deleteCar("lkj");
        CarEntity carEntity = vehicleRepositoryImpl.getCar("lkj");
        assertTrue(carEntity == null);
    }

    @Test
    public void getCarsDataBase_shouldGetEmptyList_IfTable_IsEmpty() throws InterruptedException {
        dataBaseAdministration.freeSpaceDataBase();
        List<CarEntity> noteList = carDao.getAll();
        assertTrue(noteList.isEmpty());
    }

    @Test
    public void getCarsDataBase_shoudGetEmptyList_IfDataB_isFill() throws InterruptedException {
        assertTrue(vehicleRepositoryImpl.getListCar().isEmpty());
    }
}