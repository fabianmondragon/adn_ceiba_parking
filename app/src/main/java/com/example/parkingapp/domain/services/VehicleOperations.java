package com.example.parkingapp.domain.services;

import com.example.parkingapp.BaseApplication;
import com.example.parkingapp.data.repository.VehicleRepository;
import com.example.parkingapp.data.repository.VehicleRepositoryImpl;
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

    private int idSpaceParking;
    @Inject Validation validation;
    @Inject ParkingSpaceOperations parkingSpaceOperations;
    @Inject DataBaseAdministration dataBaseAdministration;
    @Inject BillOperations billOperations;
    long numberMinuts;
    private VehicleRepository vehicleRepository;

    @Inject
    public VehicleOperations() {
        BaseApplication.appComponent.inject(this);
        vehicleRepository = new VehicleRepositoryImpl();
    }

    public Response fillDataBase() {
        return dataBaseAdministration.fillDataBase();
    }

    public void freeUpSpace() {
        dataBaseAdministration.freeUpDataBaseSpace();
    }

    public Response registerMotorCycle(Motorcycle motorcycle) {
        Response response = new Response();
        Date currentDate = Calendar.getInstance().getTime();
        response.typeTransaction = SET_MOTORCYCLE;
        if (validation.isValid(motorcycle.getPlate()) == true || validation.isLessThanMotorCycleLimit()) {
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
        Response response = new Response();
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
        Response response = new Response();
        car = vehicleRepository.getCar(car.getPlate());
        Date currentDate = Calendar.getInstance().getTime();
        Date previosDate = parkingSpaceOperations.getTimeCar(car.getPlate());
        numberMinuts = billOperations.calculateTime(currentDate, previosDate);
        response.cost = billOperations.calculateCost(numberMinuts, 0, Constant.IS_A_CAR);
        if (vehicleRepository.deleteCar(car.getPlate()) == true && parkingSpaceOperations.freeUpSpace(car.getFkParkingSpace()) == true) {
            response.state = true;
            response.typeTransaction = Constant.CHECKOUT_CAR_MOTORCYCLE;
            response.msg = Constant.COSTO_TOTAL + ": $ " + response.cost;
        }
        return response;
    }

    public Response checkOutMotorcycle(Motorcycle motorcycle) {
        Response response = new Response();
        motorcycle = vehicleRepository.getMotorcycle(motorcycle.getPlate());
        Date currentDate = Calendar.getInstance().getTime();
        Date previosDate = parkingSpaceOperations.getTimeMotorcycle(motorcycle.getPlate());
        numberMinuts = billOperations.calculateTime(currentDate, previosDate);
        response.cost = billOperations.calculateCost(numberMinuts, motorcycle.getCylindrical(), Constant.IS_A_MOTO);
        if (vehicleRepository.deleteMotorcycle(motorcycle.getPlate()) == true && parkingSpaceOperations.freeUpSpace(motorcycle.getFkParkingSpace()) == true) {
            response.state = true;
            response.typeTransaction = Constant.CHECKOUT_CAR_MOTORCYCLE;
            response.msg = Constant.COSTO_TOTAL + ": $ " + response.cost;
        }
        return response;
    }
}
