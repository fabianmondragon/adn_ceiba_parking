package com.example.parkingapp.conversions;

import com.example.parkingapp.data.database.entity.CarEntity;
import com.example.parkingapp.data.database.entity.MotorcycleEntity;
import com.example.parkingapp.data.database.entity.ParkingEntity;
import com.example.parkingapp.data.database.entity.ParkingSpaceEntitiy;
import com.example.parkingapp.data.database.entity.TariffEntity;
import com.example.parkingapp.data.repository.CilindrajeImpl;
import com.example.parkingapp.data.repository.ParkingImpl;
import com.example.parkingapp.data.repository.ParkingSpaceImpl;
import com.example.parkingapp.data.repository.TariffRepositoryImpl;
import com.example.parkingapp.data.repository.VehicleRepositoryImpl;
import com.example.parkingapp.data.database.entity.CilindrajeRulesEntity;
import com.example.parkingapp.domain.model.Domain;
import com.example.parkingapp.domain.services.VehicleOperations;
import com.example.parkingapp.domain.model.CylindricalRules;
import com.example.parkingapp.domain.model.Parking;
import com.example.parkingapp.domain.model.Tariff;
import com.example.parkingapp.domain.model.Car;
import com.example.parkingapp.domain.model.Motorcycle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.CheckForNull;

public class ConversionType {

    public static final int IS_A_MOTO = 1;
    public static final int IS_A_CAR = 2;
    private static final ConversionType instanceConversionType = new ConversionType();

    public static ConversionType getInstance() {
        return instanceConversionType;
    }

    public List<Parking> getParkingFromDomainToRepository(ParkingImpl parkingImpl) {
        List<ParkingEntity> parkingEntityList = parkingImpl.getParking();
        List<Parking> listParking = new ArrayList<>();
        for (ParkingEntity item : parkingEntityList) {
            listParking.add(new Parking(item.getNumberCar(), item.getNumberMoto()));
        }
        return listParking;
    }

    public void regiterMotoFromVMToDomain(Motorcycle motorcyclePresentation, VehicleOperations vehicleOperations) {
        Domain domain = new Domain(motorcyclePresentation.getPlate(), motorcyclePresentation.getCilindraje(), 1);
        vehicleOperations.registerVehicle(domain);
    }

    public void regiterCarFromVMToDomain(Car motorcyclePresentation, VehicleOperations vehicleOperations) {
        Domain domain = new Domain(motorcyclePresentation.getPlate(), 2);
        vehicleOperations.registerVehicle(domain);
    }


    public boolean registerMotoFromDomainToRepository(Domain vehicle, VehicleRepositoryImpl vehicleRepositoryImpl, int space) {
        MotorcycleEntity motorcycleEntity = new MotorcycleEntity(vehicle.getPlate(), vehicle.getCilindraje(), space);
        return vehicleRepositoryImpl.setMotorcycle(motorcycleEntity);
    }

    public boolean registerCarFromDomainToRepository(Domain vehicle, VehicleRepositoryImpl vehicleRepositoryImpl, int space) {
        CarEntity carEntity = new CarEntity(vehicle.getPlate(), space);
        return vehicleRepositoryImpl.setCar(carEntity);
    }


    public void checkoutMotorCycleFromVMToDomain(Motorcycle motorcycle, VehicleOperations vehicleOperations) {
        Domain domain = new Domain(motorcycle.getPlate(), 1);
        vehicleOperations.checkoutVehicle(domain);
    }

    public void checkoutCarFromVMToDomain(Car carPresentation, VehicleOperations vehicleOperations) {
        Domain domain = new Domain(carPresentation.getPlate(), 2);
        vehicleOperations.checkoutVehicle(domain);
    }


    @CheckForNull
    public Date getTimeFromDomainToRepository(Domain domain, ParkingSpaceImpl parkingSpaceImpl) {
        ParkingSpaceEntitiy parkingSpaceEntitiy = null;
        if (domain.getType() == IS_A_CAR) {
           // parkingSpaceEntitiy = parkingSpaceImpl.getTimeCar(domain.getPlate());
        } else {
           // parkingSpaceEntitiy = parkingSpaceImpl.getTime(domain.getPlate());
        }
        try {
            if (parkingSpaceEntitiy != null) {
                if (parkingSpaceEntitiy.getStartOcupation() != null) {
                    return parkingSpaceEntitiy.getStartOcupation();
                }
            }
            return null;
        } catch (NullPointerException exception) {
            return null;
        }
    }

    public Domain getMotoFromDomainToRepository(Domain domain, VehicleRepositoryImpl vehicleRepositoryImpl) {
        MotorcycleEntity motorcycleEntity = vehicleRepositoryImpl.getMotoCycle(domain.getPlate());
        domain.setPlate(motorcycleEntity.getPlateID());
        domain.setCilindraje(motorcycleEntity.getCilindraje());
        domain.setFsetFkSpace(motorcycleEntity.getFkParkingSpace());
        return domain;
    }

    public Domain getCarFromDomainToRepository(Domain domain, VehicleRepositoryImpl vehicleRepositoryImpl) {
        CarEntity carEntity = vehicleRepositoryImpl.getCar(domain.getPlate());
        domain.setPlate(carEntity.getPlateID());
        domain.setFsetFkSpace(carEntity.getFkParkingSpace());
        return domain;
    }

    public CylindricalRules getRuleCilindrajeFromDomaitnToRespository(CilindrajeImpl cilindrajeImpl) {
        CylindricalRules cylindricalRules;
        CilindrajeRulesEntity cilindrajeRulesEntity = cilindrajeImpl.getActiveCilindraje();
        cylindricalRules = new CylindricalRules(cilindrajeRulesEntity.getCilindraje_moto());
        return cylindricalRules;
    }

    public Tariff getTariffFromDomaintToRepository(TariffRepositoryImpl tariffRepositoryImpl) {
        Tariff domainTariff;
        TariffEntity tariffEntity = tariffRepositoryImpl.getTariff();
        domainTariff = new Tariff(tariffEntity.getValueHorCar(), tariffEntity.getValueHorMoto(), tariffEntity.getValueDayCar(), tariffEntity.getValueDayMoto(), tariffEntity.getValueCilindrajeMoto());
        return domainTariff;
    }
}
