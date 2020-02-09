package com.example.parkingapp.conversions;


import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.parkingapp.data.CilindrajeRepository;
import com.example.parkingapp.data.ModelParking;
import com.example.parkingapp.data.ParkingRepository;
import com.example.parkingapp.data.SpaceParkingRepository;
import com.example.parkingapp.data.TariffRepository;
import com.example.parkingapp.data.VehicleRepository;
import com.example.parkingapp.data.database.Car;
import com.example.parkingapp.data.database.CilindrajeRules;
import com.example.parkingapp.data.database.Motorcycle;
import com.example.parkingapp.data.database.Parking;
import com.example.parkingapp.data.database.ParkingSpace;
import com.example.parkingapp.data.database.Tariff;
import com.example.parkingapp.domain.DomainVehicleOperations;
import com.example.parkingapp.domain.model.DomainCilindrajeRules;
import com.example.parkingapp.domain.model.DomainMotorcycle;
import com.example.parkingapp.domain.model.DomainParking;
import com.example.parkingapp.domain.model.DomainTariff;
import com.example.parkingapp.domain.model.DomainVehicle;
import com.example.parkingapp.presentation.CarPresentation;
import com.example.parkingapp.presentation.MotorcyclePresentation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConversionType {

    public static int IS_A_MOTO = 1;
    public static int IS_A_CAR = 2;
    private static final ConversionType instanceConversionType = new ConversionType();
    private Application application;
    private ParkingRepository parkingRepository;

    public static ConversionType getInstance(){
        return instanceConversionType;
    }

    public ConversionType() {

    }



    public void fromPresentationToDomain(String value, int cilindrajeMotoValue, int type){

    }


    public void fromRepositoryToDomain(){

    }

    public void setApplication(Application application) {
        this.application = application;
    }



    public void registerMotorcycleToRepository (MotorcyclePresentation motorcyclePresentation){

    }

    public void getParkingToDomainFromRepository(List<Parking> listparking, ParkingRepository parkingRepository) {

    }

    public List<DomainParking> getParkingFromDomainToRepository(ParkingRepository parkingRepository) {
        List <Parking> parkingList = parkingRepository.getParking();
        List <DomainParking> listDomainParking = new ArrayList<>();
        for (Parking item: parkingList){
            listDomainParking.add (new DomainParking(item.getNumberCar(), item.getNumberMoto()));
        }
        return listDomainParking;
    }

    public void regiterMotoFromVMToDomain(MotorcyclePresentation motorcyclePresentation, DomainVehicleOperations domainVehicleOperations) {
        com.example.parkingapp.domain.model.DomainVehicle domainVehicle = new com.example.parkingapp.domain.model.DomainVehicle(motorcyclePresentation.getPlate(), motorcyclePresentation.getCilindraje(), 1);
        domainVehicleOperations.registerVehicle(domainVehicle);
    }

    public void regiterCarFromVMToDomain(CarPresentation motorcyclePresentation, DomainVehicleOperations domainVehicleOperations) {
        com.example.parkingapp.domain.model.DomainVehicle domainVehicle = new com.example.parkingapp.domain.model.DomainVehicle(motorcyclePresentation.getPlate(), 2);
        domainVehicleOperations.registerVehicle(domainVehicle);
    }


    public boolean registerMotoFromDomainToRepository(DomainVehicle vehicle, VehicleRepository vehicleRepository, int space) {
        Motorcycle motorcycle = new Motorcycle (vehicle.getPlate(), vehicle.getCilindraje(), space);
        return vehicleRepository.setMotorcycle(motorcycle);
    }

    public boolean registerCarFromDomainToRepository(DomainVehicle vehicle, VehicleRepository vehicleRepository, int space) {
        Car car = new Car (vehicle.getPlate(), space);
        return vehicleRepository.setCar(car);
    }


    public void checkoutMotorCycleFromVMToDomain(MotorcyclePresentation motorcycle, DomainVehicleOperations domainVehicleOperations) {
        DomainVehicle domainVehicle = new DomainVehicle(motorcycle.getPlate(), 1);
        domainVehicleOperations.checkoutVehicle (domainVehicle);
    }

    public void checkoutCarFromVMToDomain(CarPresentation carPresentation, DomainVehicleOperations domainVehicleOperations) {
        DomainVehicle domainVehicle = new DomainVehicle(carPresentation.getPlate(), 2);
        domainVehicleOperations.checkoutVehicle (domainVehicle);
    }


    public Date getTimeFromDomainToRepository(DomainVehicle domainVehicle, SpaceParkingRepository spaceParkingRepository) {
        ParkingSpace parkingSpace = null; 
        if (domainVehicle.getType() == IS_A_CAR){
            parkingSpace = spaceParkingRepository.getTimeCar(domainVehicle.getPlate());
        }else if (domainVehicle.getType() == IS_A_MOTO){
            parkingSpace = spaceParkingRepository.getTime(domainVehicle.getPlate());
        }
         try {
             return parkingSpace.getStartOcupation();
         }catch (NullPointerException exception){
             return null;
         }
    }

    public DomainVehicle getMotoFromDomainToRepository(DomainVehicle domainVehicle, VehicleRepository vehicleRepository){
           Motorcycle motorcycle = vehicleRepository.getMotoCycle(domainVehicle.getPlate());
           domainVehicle.setPlate(motorcycle.getPlateID());
           domainVehicle.setCilindraje(motorcycle.getCilindraje());
           domainVehicle.setFk_space(motorcycle.getFkParkingSpace());
           return domainVehicle;
    }
    public DomainVehicle getCarFromDomainToRepository(DomainVehicle domainVehicle, VehicleRepository vehicleRepository){
        Car car = vehicleRepository.getCar(domainVehicle.getPlate());
        domainVehicle.setPlate(car.getPlateID());
        domainVehicle.setFk_space(car.getFkParkingSpace());
        return domainVehicle;
    }


    public DomainCilindrajeRules getRuleCilindrajeFromDomaitnToRespository(CilindrajeRepository cilindrajeRepository) {
        DomainCilindrajeRules domainCilindrajeRules;
        CilindrajeRules cilindrajeRules = cilindrajeRepository.getActiveCilindraje();
        domainCilindrajeRules = new DomainCilindrajeRules(cilindrajeRules.getCilindraje_moto());
        return domainCilindrajeRules;
    }

    public DomainTariff getTariffFromDomaintToRepository(TariffRepository tariffRepository) {
        DomainTariff domainTariff;
        Tariff tariff = tariffRepository.getTariff();
        domainTariff = new DomainTariff( tariff.getValueHorCar(), tariff.getValueHorMoto(), tariff.getValueDayCar(), tariff.getValueDayMoto(), tariff.getValueCilindrajeMoto() );
        return domainTariff;
    }
}
