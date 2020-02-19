package com.example.parkingapp.data.repository;

import com.example.parkingapp.BaseApplication;
import com.example.parkingapp.data.database.entity.TariffEntity;
import com.example.parkingapp.domain.interfaces_repository.TariffRepository;

public class TariffRepositoryImpl implements TariffRepository {

    public TariffEntity getTariff() {
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        return db.tariffDao().getTariff();
    }
}
