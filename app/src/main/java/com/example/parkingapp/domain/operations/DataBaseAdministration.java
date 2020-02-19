package com.example.parkingapp.domain.operations;

import android.util.Log;

import com.example.parkingapp.BaseApplication;
import com.example.parkingapp.data.database.entity.CilindrajeRulesEntity;
import com.example.parkingapp.data.database.entity.ParkingEntity;
import com.example.parkingapp.data.database.entity.ParkingSpaceEntitiy;
import com.example.parkingapp.data.database.entity.PlateRulesEntity;
import com.example.parkingapp.data.database.entity.TariffEntity;
import com.example.parkingapp.domain.interfaces_repository.ManagmentDataBaseRepository;
import com.example.parkingapp.domain.model.Response;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class DataBaseAdministration {

    private static final String TAG = DataBaseAdministration.class.getName();

    @Inject
    ManagmentDataBaseRepository managmentDataBaseRepository;

    @Inject
    public DataBaseAdministration() {
        ((BaseApplication)(BaseApplication.getAppContext().getApplicationContext())).getAppComponent().inject(this);
    }

    public Response fillDataBase() {
        final ParkingEntity parkingEntity = new ParkingEntity(20, 10);
        final CilindrajeRulesEntity cilindrajeRulesEntity = new CilindrajeRulesEntity(150, 1);
        final List<ParkingSpaceEntitiy> parkingSpaceEntityList = new ArrayList();
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        parkingSpaceEntityList.add(new ParkingSpaceEntitiy(false, null, 0));
        final TariffEntity tariffEntity = new TariffEntity(1000.0, 500.0, 8000.0, 4000.0, 2000.0);
        final PlateRulesEntity plateRulesEntity = new PlateRulesEntity("b", true);
        try {
            return managmentDataBaseRepository.fillDataBase(parkingEntity, parkingSpaceEntityList, cilindrajeRulesEntity, tariffEntity, plateRulesEntity);
        }catch (NullPointerException e){
            Log.e(TAG, e.getMessage());
        }
        return null;
    }


    public void freeUpDataBaseSpace() {
        managmentDataBaseRepository.freeUpSpace();
    }
}
