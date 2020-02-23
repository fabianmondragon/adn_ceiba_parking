package com.example.parkingapp.di;

import com.example.parkingapp.data.repository.TariffRepositoryImpl;
import com.example.parkingapp.data.repository.VehicleRepositoryImpl;
import com.example.parkingapp.domain.repository.TariffRepository;

import dagger.Module;
import dagger.Provides;

@Module
class RepositoryModule {

    @Provides
    public VehicleRepositoryImpl provideVehicleRepository() {
        return new VehicleRepositoryImpl();
    }

    @Provides
    public TariffRepository tariffRepository() {
        return new TariffRepositoryImpl();
    }
}
