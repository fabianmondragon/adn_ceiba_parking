package com.example.parkingapp.data;

import com.example.parkingapp.BaseApplication;
import com.example.parkingapp.data.database.Tariff;

public class TariffRepository {

    public Tariff getTariff() {
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        return db.tariffDao().getTariff();
    }
}
