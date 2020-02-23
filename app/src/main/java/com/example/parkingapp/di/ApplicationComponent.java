package com.example.parkingapp.di;

import com.example.parkingapp.data.database.DataBaseAdministration;
import com.example.parkingapp.domain.operations.BillOperations;
import com.example.parkingapp.domain.operations.CylindricalRulesOperations;
import com.example.parkingapp.domain.operations.ParkingSpaceOperations;
import com.example.parkingapp.domain.operations.TariffOperations;
import com.example.parkingapp.domain.operations.Validation;
import com.example.parkingapp.domain.repository.VehicleRepository;
import com.example.parkingapp.domain.services.VehicleOperations;
import com.example.parkingapp.presentation.view.MainActivity;
import com.example.parkingapp.presentation.viewmodel.ParkingViewModel;

import dagger.Component;

@Component(modules = {DomainModule.class, AppModule.class, DataBaseModule.class})
public interface ApplicationComponent {

    void inject(MainActivity mainActivity);

    void inject(ParkingViewModel parkingViewModel);

    void inject(VehicleOperations vehicleOperations);

    void inject(BillOperations billOperations);

    void inject (DataBaseAdministration dataBaseAdministration);

    void inject (ParkingSpaceOperations parkingSpaceOperations);

    void inject (CylindricalRulesOperations cylindricalRulesOperations);

    void inject (TariffOperations tariffOperations);

    VehicleRepository vehicleRepository();

    Validation validation ();

    BillOperations billOperations();

    TariffOperations tariffOperations();




}
