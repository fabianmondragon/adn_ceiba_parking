package com.example.parkingapp.di;

import com.example.parkingapp.domain.services.BillOperations;
import com.example.parkingapp.domain.services.VehicleOperations;
import com.example.parkingapp.presentation.view.MainActivity;
import com.example.parkingapp.presentation.viewmodel.ParkingViewModel;

import java.text.Bidi;

import dagger.Component;

@Component (modules = {DomainModule.class, AppModule.class})
public interface ApplicationComponent {

    void inject (MainActivity mainActivity);
    void inject (ParkingViewModel parkingViewModel);
    void inject (VehicleOperations vehicleOperations);
    void inject (BillOperations billOperations);


}
