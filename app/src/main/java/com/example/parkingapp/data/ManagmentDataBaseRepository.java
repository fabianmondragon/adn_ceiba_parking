package com.example.parkingapp.data;

import android.os.AsyncTask;

import com.example.parkingapp.BaseApplication;
import com.example.parkingapp.data.database.CilindrajeRules;
import com.example.parkingapp.data.database.Parking;
import com.example.parkingapp.data.database.ParkingSpace;
import com.example.parkingapp.data.database.PlateRules;
import com.example.parkingapp.data.database.Tariff;

import java.util.List;

public class ManagmentDataBaseRepository {

    public ManagmentDataBaseRepository() {

    }

    public void fillDataBase(final Parking parking, final List<ParkingSpace> parkingSpaceList, final CilindrajeRules cilindrajeRules, final Tariff tariff, final PlateRules plateRules) {
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                if (db.parkingDao().getAllParkinList().size() == 0) {
                    db.parkingDao().inserParking(parking);
                    db.parkingSpaceDao().insertParkingAll(parkingSpaceList);
                    db.cilindrajeRulesDao().insertCilindrajeRules(cilindrajeRules);
                    db.tariffDao().insertTarif(tariff);
                    db.plateRulesDao().insetPlateRulse(plateRules);

                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
            }
        }.execute();
    }

    public void freeUpSpace() {
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                db.parkingSpaceDao().setUpdateAllStateParking(false);
                db.carDao().deleteAll();
                db.motorCycleDao().deleteAll();
                return null;
            }
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
            }
        }.execute();

    }
}
