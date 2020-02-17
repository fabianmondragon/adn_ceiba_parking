package com.example.parkingapp.domain.services;

import android.app.Application;
import android.content.Context;

import com.example.parkingapp.BaseApplication;
import com.example.parkingapp.data.repository.VehicleRepository;
import com.example.parkingapp.domain.model.Car;
import com.example.parkingapp.domain.model.Motorcycle;
import com.example.parkingapp.domain.model.Response;
import com.example.parkingapp.util.Constant;

import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import static com.example.parkingapp.util.Constant.SET_CAR;
import static com.example.parkingapp.util.Constant.SET_MOTORCYCLE;

public class VehicleOperations {

    @Inject
    Validation validation;
    @Inject
    ParkingSpaceOperations parkingSpaceOperations;
    @Inject
    DataBaseAdministration dataBaseAdministration;
    @Inject
    BillOperations billOperations;
    @Inject
    VehicleRepository vehicleRepository;
    @Inject
    Response response;
    private long numberMinuts;
    private int idSpaceParking;

    @Inject
    public VehicleOperations() {
        if (BaseApplication.getAppContext() != null){
            ((BaseApplication) (BaseApplication.getAppContext().getApplicationContext())).getAppComponent().inject(this);
        }
    }

    public VehicleOperations(int i) {
    }


    public Response fillDataBase() {
        return dataBaseAdministration.fillDataBase();
    }

    public void freeUpSpace() {
        dataBaseAdministration.freeUpDataBaseSpace();
    }

    public Response registerMotorCycle(Motorcycle motorcycle) {
        Date currentDate = Calendar.getInstance().getTime();
       response.typeTransaction = SET_MOTORCYCLE;
        if (validation.isValid(motorcycle.getPlate()) && validation.isLessThanMotorCycleLimit()) {
            idSpaceParking = parkingSpaceOperations.getFreeSpace();
            if (vehicleRepository.setMotorcycle(motorcycle, idSpaceParking)) {
                parkingSpaceOperations.occupySpace(idSpaceParking, currentDate);
                response.state = true;
                response.msg = Constant.REGISTER_SUCCESSFULL;
            } else {
                response.state = false;
                response.msg = Constant.REGISTER_UNSUCCEFULL;
            }
        } else {
            response.state = false;
            response.msg = Constant.REGISTER_UNSUCCEFULL;
        }
        return response;
    }

    public Response registerCar(Car car) {
        Date currentDate = Calendar.getInstance().getTime();
        response.typeTransaction = SET_CAR;
        if (validation.isLessThanCarLimit()) {
            idSpaceParking = parkingSpaceOperations.getFreeSpace();
            if (vehicleRepository.setCar(car, idSpaceParking)) {
                parkingSpaceOperations.occupySpace(idSpaceParking, currentDate);
                response.state = true;
                response.msg = Constant.REGISTER_SUCCESSFULL;
                response.typeTransaction = SET_CAR;
            } else {
                response.state = false;
                response.msg = Constant.REGISTER_UNSUCCEFULL;
            }
        } else {
            response.state = false;
            response.msg = Constant.REGISTER_SUCCESSFULL;
        }
        return response;
    }

    public Response checkoutCar(Car car) {
        car = vehicleRepository.getCar(car.getPlate());
        Date currentDate = Calendar.getInstance().getTime();
        Date previosDate = parkingSpaceOperations.getTimeCar(car.getPlate());
        numberMinuts = billOperations.calculateTime(currentDate, previosDate);
        response.cost = billOperations.calculateCost(numberMinuts, 0, Constant.IS_A_CAR);
        if (vehicleRepository.deleteCar(car.getPlate()) && parkingSpaceOperations.freeUpSpace(car.getFkParkingSpace())) {
            response.state = true;
            response.typeTransaction = Constant.CHECKOUT_CAR_MOTORCYCLE;
            response.msg = Constant.COSTO_TOTAL + ": $ " + response.cost;
        }
        return response;
    }

    public Response checkOutMotorcycle(Motorcycle motorcycle) {
        motorcycle = vehicleRepository.getMotorcycle(motorcycle.getPlate());
        Date currentDate = Calendar.getInstance().getTime();
        Date previosDate = parkingSpaceOperations.getTimeMotorcycle(motorcycle.getPlate());
        numberMinuts = billOperations.calculateTime(currentDate, previosDate);
        response.cost = billOperations.calculateCost(numberMinuts, motorcycle.getCylindrical(), Constant.IS_A_MOTO);
        if (vehicleRepository.deleteMotorcycle(motorcycle.getPlate()) && parkingSpaceOperations.freeUpSpace(motorcycle.getFkParkingSpace())) {
            response.state = true;
            response.typeTransaction = Constant.CHECKOUT_CAR_MOTORCYCLE;
            response.msg = Constant.COSTO_TOTAL + ": $ " + response.cost;
        }
        return response;
    }
}
