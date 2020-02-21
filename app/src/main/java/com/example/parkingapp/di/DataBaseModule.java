package com.example.parkingapp.di;

import com.example.parkingapp.data.repository.CylindricalImpl;
import com.example.parkingapp.domain.repository.CylindricalRepository;
import com.example.parkingapp.data.repository.ManagmentDataBaseImpl;
import com.example.parkingapp.data.repository.ParkingImpl;
import com.example.parkingapp.domain.repository.ParkingRepository;
import com.example.parkingapp.domain.repository.ParkingSpaceRepository;
import com.example.parkingapp.data.repository.ParkingSpaceRepositoryImpl;
import com.example.parkingapp.domain.repository.TariffRepository;
import com.example.parkingapp.data.repository.TariffRepositoryImpl;
import com.example.parkingapp.domain.repository.VehicleRepository;
import com.example.parkingapp.data.repository.VehicleRepositoryImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class DataBaseModule {

    @Provides
    VehicleRepository productRepository() {
        return new VehicleRepositoryImpl();
    }

    @Provides
    ParkingRepository parkingRepository() {
        return new ParkingImpl();
    }

    @Provides
    TariffRepository tariffRepository() {
        return new TariffRepositoryImpl();
    }

    @Provides
    ParkingSpaceRepository parkingSpaceRepository() {
        return new ParkingSpaceRepositoryImpl();
    }

    @Provides
    CylindricalRepository ciylindricalRepository() {
        return new CylindricalImpl();
    }


}
