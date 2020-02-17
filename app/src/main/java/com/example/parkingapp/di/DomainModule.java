package com.example.parkingapp.di;

import com.example.parkingapp.domain.model.Response;
import com.example.parkingapp.domain.model.Validation;
import com.example.parkingapp.domain.services.BillOperations;
import com.example.parkingapp.domain.services.CylindricalRulesOperations;
import com.example.parkingapp.domain.services.DataBaseAdministration;
import com.example.parkingapp.domain.services.ParkingSpaceOperations;
import com.example.parkingapp.domain.services.TariffOperations;
import com.example.parkingapp.domain.services.VehicleOperations;

import dagger.Module;
import dagger.Provides;

@Module
public class DomainModule {

    @Provides
    TariffOperations getInstanceTariffOperations() {
        return new TariffOperations();
    }

    @Provides
    public CylindricalRulesOperations getInstanceCylindricalRulesOperations() {
        return new CylindricalRulesOperations();
    }

    @Provides
    public BillOperations getInstanceBillOperations() {
        return new BillOperations();
    }

    @Provides
    public DataBaseAdministration getInstanceDataBaseAdministration() {
        return new DataBaseAdministration();
    }

    @Provides
    public ParkingSpaceOperations getInstanceParkingSpaceOperations() {
        return new ParkingSpaceOperations();
    }

    @Provides
    public Validation getInstanceValidation() {
        return new Validation();
    }

    @Provides
    public VehicleOperations getInstanceVehicleOperations() {
        return new VehicleOperations();
    }

    @Provides
    public Response getInstanceResponse() {
        return new Response();
    }


}
