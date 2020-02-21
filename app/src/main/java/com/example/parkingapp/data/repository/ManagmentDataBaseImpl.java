package com.example.parkingapp.data.repository;

import android.os.AsyncTask;

import com.example.parkingapp.BaseApplication;
import com.example.parkingapp.data.database.DataBaseAdministration;
import com.example.parkingapp.data.database.entity.CilindrajeRulesEntity;
import com.example.parkingapp.data.database.entity.ParkingEntity;
import com.example.parkingapp.data.database.entity.ParkingSpaceEntitiy;
import com.example.parkingapp.data.database.entity.PlateRulesEntity;
import com.example.parkingapp.data.database.entity.TariffEntity;


import java.util.List;

import javax.inject.Inject;

public class ManagmentDataBaseImpl {

    @Inject
    public ManagmentDataBaseImpl() {
        fillDataBase();
    }

    public void fillDataBase(   ) {
        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... voids) {
                DataBaseAdministration dataBaseAdministration = new DataBaseAdministration();
                final PlateRulesEntity plateRulesEntity = dataBaseAdministration.preparePlatRules();
                final CilindrajeRulesEntity cilindrajeRulesEntity = dataBaseAdministration.prepareCylindrical();
                final ParkingEntity parkingEntity =dataBaseAdministration.prepareParking();
                final List<ParkingSpaceEntitiy> parkingSpaceEntityList = dataBaseAdministration.prepareParkingSpace();
                final TariffEntity tariffEntity = dataBaseAdministration.prepareTariff();
                final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
                if (db.parkingDao().getAllParkinList().size() == 0) {
                    db.parkingDao().inserParking(parkingEntity);
                    db.parkingSpaceDao().insertParkingAll(parkingSpaceEntityList);
                    db.cilindrajeRulesDao().insertCilindrajeRules(cilindrajeRulesEntity);
                    db.tariffDao().insertTarif(tariffEntity);
                    db.plateRulesDao().insetPlateRulse(plateRulesEntity);
                }
                return null;
            } /*Your code(e.g. doInBackground )*/
        }.execute();
    }
}
