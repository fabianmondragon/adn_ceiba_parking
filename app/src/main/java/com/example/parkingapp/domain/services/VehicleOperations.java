package com.example.parkingapp.domain.services;

import android.util.Log;

import com.example.parkingapp.BaseApplication;
import com.example.parkingapp.data.repository.ManagmentDataBaseImpl;
import com.example.parkingapp.domain.ConstantDomain;
import com.example.parkingapp.domain.exceptions.ConstantException;
import com.example.parkingapp.domain.exceptions.ParkingException;
import com.example.parkingapp.domain.repository.VehicleRepository;
import com.example.parkingapp.domain.model.Car;
import com.example.parkingapp.domain.model.Motorcycle;
import com.example.parkingapp.domain.model.Response;
import com.example.parkingapp.domain.operations.BillOperations;
import com.example.parkingapp.data.database.DataBaseAdministration;
import com.example.parkingapp.domain.operations.ParkingSpaceOperations;
import com.example.parkingapp.domain.operations.Validation;
import com.example.parkingapp.presentation.Constant;

import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import static com.example.parkingapp.domain.ConstantDomain.SET_CAR;
import static com.example.parkingapp.domain.ConstantDomain.SET_MOTORCYCLE;

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
    private long numberMinutes;
    private int idSpaceParking;

    @Inject
    public VehicleOperations() {
        if (BaseApplication.getAppContext() != null){
            ((BaseApplication) (BaseApplication.getAppContext().getApplicationContext())).getAppComponent().inject(this);
            ManagmentDataBaseImpl managmentDataBase = new ManagmentDataBaseImpl();
        }
    }


    public Response registerMotorcycle(Motorcycle motorcycle)  {
        Date currentDate = Calendar.getInstance().getTime();
        boolean resultOcupySpace;
        response.typeTransaction = SET_MOTORCYCLE;
        try {
            if (validation.isValid(motorcycle.getPlate()) && validation.isLessThanMotorCycleLimit()) {
                idSpaceParking = parkingSpaceOperations.getFreeSpace();
                if (idSpaceParking == -1){
                    throw new ParkingException(ConstantException.GENERAL_ERROR);
                }
                if (motorcycle.getPlate().equals("")){
                    throw new ParkingException(ConstantException.PLATE_ERROR);
                }
                if (vehicleRepository.setMotorcycle(motorcycle, idSpaceParking)) {
                    parkingSpaceOperations.occupySpace(idSpaceParking, currentDate);
                    response.state = true;
                    response.msg = ConstantDomain.SUCESSFUL_REGISTRATION;
                } else {
                    response.state = false;
                    response.msg = ConstantDomain.UNSUCESSFUL_REGISTRATION;
                }
            } else {
                response.state = false;
                response.msg = ConstantDomain.UNSUCESSFUL_REGISTRATION;
            }
        }catch (ParkingException parkingException){
            response.msg = parkingException.getMessage();
            response.state = false;
        }catch (NullPointerException e){
            response.msg = ConstantException.GENERAL_ERROR;
            response.state = false;
        }
        return response;
    }

    public Response registerCar(Car car)  {
        Date currentDate = Calendar.getInstance().getTime();
        response.typeTransaction = SET_CAR;
        try {
            if (validation.isLessThanCarLimit()) {
                idSpaceParking = parkingSpaceOperations.getFreeSpace();
                if (idSpaceParking == -1){
                    throw new ParkingException(ConstantException.GENERAL_ERROR);
                }
                if (car.getPlate().equals("")){
                    throw new ParkingException(ConstantException.PLATE_ERROR);
                }
                if (vehicleRepository.setCar(car, idSpaceParking)) {
                    parkingSpaceOperations.occupySpace(idSpaceParking, currentDate);
                    response.msg = ConstantDomain.SUCESSFUL_REGISTRATION;
                    response.state = true;
                } else {
                    response.state = false;
                    response.msg = ConstantDomain.UNSUCESSFUL_REGISTRATION;
                }
            } else {
                response.state = false;
                response.msg = ConstantDomain.SUCESSFUL_REGISTRATION;
            }
        } catch (ParkingException parkingException){
            response.msg = parkingException.getMessage();
            response.state = false;
        }catch (NullPointerException e){
            response.msg = ConstantException.GENERAL_ERROR;
            response.state = false;
        }
        return response;
    }

    public Response checkoutCar(Car car) {
        try {
            response.typeTransaction = ConstantDomain.CHECKOUT_CAR_MOTORCYCLE;
            car = vehicleRepository.getCar(car.getPlate());
            if (car == null) {
                response.state = false;
                response.msg = ConstantDomain.VEHICLE_NO_IS_REGISTER;
                return response;
            }
            Date currentDate = Calendar.getInstance().getTime();
            Date previousDate = parkingSpaceOperations.getTimeCar(car.getPlate());
            numberMinutes = billOperations.calculateTime(currentDate, previousDate);
            if (numberMinutes < 0 ){
                throw new ParkingException(ConstantException.MINUTS_ERROR);
            }
            response.cost = billOperations.calculateCost(numberMinutes, 0, ConstantDomain.IS_A_CAR);
            if (response.cost < 0){
                throw new ParkingException(ConstantException.COST_ERROR);
            }
            if (vehicleRepository.deleteCar(car.getPlate()) && parkingSpaceOperations.freeUpSpace(car.getFkParkingSpace())) {
                response.state = true;
                response.typeTransaction = ConstantDomain.CHECKOUT_CAR_MOTORCYCLE;
                response.msg = ConstantDomain.TOTAL_COST + ": $ " + response.cost;
                return response;
            }
            response.state = false;
        }catch (ParkingException parkingException){
            response.state = false;
            response.msg =  parkingException.getMessage();
        }
        catch (NullPointerException e){
            response.state = false;
            response.msg =  ConstantException.GENERAL_ERROR;
        }
        return response;
    }

    public Response checkOutMotorcycle(Motorcycle motorcycle) {
        try {
            motorcycle = vehicleRepository.getMotorcycle(motorcycle.getPlate());
            if (motorcycle== null){
                response.state = false;
                response.msg = ConstantDomain.VEHICLE_NO_IS_REGISTER;
                return  response;
            }
            Date currentDate = Calendar.getInstance().getTime();
            Date previousDate = parkingSpaceOperations.getTimeMotorcycle(motorcycle.getPlate());
            numberMinutes = billOperations.calculateTime(currentDate, previousDate);
            if (numberMinutes < 0 ){
                throw new ParkingException(ConstantException.MINUTS_ERROR);
            }
            response.cost = billOperations.calculateCost(numberMinutes, motorcycle.getCylindrical(), ConstantDomain.IS_A_MOTORCYCLE);
            if (response.cost < 0){
                throw new ParkingException(ConstantException.COST_ERROR);
            }
            if (vehicleRepository.deleteMotorcycle(motorcycle.getPlate()) && parkingSpaceOperations.freeUpSpace(motorcycle.getFkParkingSpace())) {
                response.state = true;
                response.typeTransaction = ConstantDomain.CHECKOUT_CAR_MOTORCYCLE;
                response.msg = ConstantDomain.TOTAL_COST + ": $ " + response.cost;
                return response;
            }
            response.state = false;
            response.typeTransaction = ConstantDomain.CHECKOUT_CAR_MOTORCYCLE;
        } catch (ParkingException parkingException){
            response.state = false;
            response.msg =  parkingException.getMessage();
        }catch (Exception e){
            response.state = false;
            response.msg =  ConstantException.GENERAL_ERROR;
        }
        return response;
    }
}
