package com.example.parkingapp.domain.services;

import com.example.parkingapp.data.database.entity.TariffEntity;
import com.example.parkingapp.data.repository.TariffRepository;
import com.example.parkingapp.data.repository.TariffRepositoryImpl;
import com.example.parkingapp.domain.model.Tariff;

public class TariffOperations {
    TariffRepository tariffRepository;
    Tariff tariff;
    TariffEntity tariffEntity;

    public TariffOperations() {
        this.tariffRepository = new TariffRepositoryImpl();
    }

    public Tariff getTariff (){
        tariffEntity = tariffRepository.getTariff();
        tariff = new Tariff(tariffEntity.getValueHorCar(), tariffEntity.getValueHorMoto(), tariffEntity.getValueDayCar(),tariffEntity.getValueDayMoto(), tariffEntity.getValueCilindrajeMoto());
        return tariff;
    }
}
