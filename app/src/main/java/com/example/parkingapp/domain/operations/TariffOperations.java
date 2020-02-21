package com.example.parkingapp.domain.operations;

import com.example.parkingapp.BaseApplication;
import com.example.parkingapp.data.database.entity.TariffEntity;
import com.example.parkingapp.domain.repository.TariffRepository;
import com.example.parkingapp.domain.model.Tariff;

import javax.inject.Inject;

public class TariffOperations {

    @Inject
    TariffRepository tariffRepository;

    Tariff tariff;
    TariffEntity tariffEntity;



    @Inject
    public TariffOperations() {
        if (BaseApplication.getAppContext() != null){
            ((BaseApplication) (BaseApplication.getAppContext().getApplicationContext())).getAppComponent().inject(this);
        }
    }

    public Tariff getTariff() {
        tariffEntity = tariffRepository.getTariff();
        tariff = new Tariff(tariffEntity.getCarHourCost(), tariffEntity.getMotorcycleHourCost(), tariffEntity.getCarDayCost(), tariffEntity.getMotorcycleDayCost(), tariffEntity.getMotorcycleCilindricalCost());
        return tariff;
    }
}
