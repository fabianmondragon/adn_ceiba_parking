package com.example.parkingapp.di;

import com.example.parkingapp.repository.ParkingRepository;
import com.example.parkingapp.viewmodel.ParkingViewModel;

import javax.inject.Singleton;


import dagger.Module;
import dagger.Provides;

@Module
public class ViewModeModule {


    @Singleton
    @Provides
    ParkingViewModel parkingViewModel (ParkingRepository parkingRepository){return new ParkingViewModel(parkingRepository);}

}
