package com.example.parkingapp.data.repository;

import com.example.parkingapp.BaseApplication;
import com.example.parkingapp.data.database.entity.CilindrajeRulesEntity;
import com.example.parkingapp.data.database.entity.ParkingEntity;
import com.example.parkingapp.data.database.entity.ParkingSpaceEntitiy;
import com.example.parkingapp.data.database.entity.PlateRulesEntity;
import com.example.parkingapp.data.database.entity.TariffEntity;
import com.example.parkingapp.domain.interfaces_repository.ManagmentDataBaseRepository;
import com.example.parkingapp.domain.model.Response;

import java.util.List;

import javax.inject.Inject;

public class ManagmentDataBaseImpl implements ManagmentDataBaseRepository {
    @Inject
    public ManagmentDataBaseImpl() {

    }

    public Response fillDataBase(final ParkingEntity parkingEntity, final List<ParkingSpaceEntitiy> parkingSpaceEntitiyList, final CilindrajeRulesEntity cilindrajeRulesEntity, final TariffEntity tariffEntity, final PlateRulesEntity plateRulesEntity) {
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        if (db.parkingDao().getAllParkinList().size() == 0) {
            db.parkingDao().inserParking(parkingEntity);
            db.parkingSpaceDao().insertParkingAll(parkingSpaceEntitiyList);
            db.cilindrajeRulesDao().insertCilindrajeRules(cilindrajeRulesEntity);
            db.tariffDao().insertTarif(tariffEntity);
            db.plateRulesDao().insetPlateRulse(plateRulesEntity);

        }
        Response response = new Response();
        response.state = true;
        return response;
    }

    public void freeUpSpace() {
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        db.parkingSpaceDao().setUpdateAllStateParking(false);
        db.carDao().deleteAll();
        db.motorCycleDao().deleteAll();
    }
}
