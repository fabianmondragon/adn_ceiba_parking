package com.example.parkingapp.di;

import com.example.parkingapp.data.repository.VehicleRepositoryImpl;

import dagger.Module;
import dagger.Provides;

@Module
class RepositoryModule {

    @Provides
    public VehicleRepositoryImpl provideVehiculoRepository() {
        return new VehicleRepositoryImpl();
    }
}
