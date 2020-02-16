package com.example.parkingapp.domain.services;

import com.example.parkingapp.data.repository.VehicleRepository;
import com.example.parkingapp.data.repository.VehicleRepositoryImpl;
import com.example.parkingapp.domain.model.Car;
import com.example.parkingapp.domain.model.CylindricalRules;
import com.example.parkingapp.domain.model.Motorcycle;
import com.example.parkingapp.domain.model.Response;
import com.example.parkingapp.domain.model.Tariff;
import com.example.parkingapp.util.Constant;

import java.util.Calendar;
import java.util.Date;

import static com.example.parkingapp.util.Constant.SET_CAR;
import static com.example.parkingapp.util.Constant.SET_MOTORCYCLE;

public class VehicleOperations {

    private ParkingSpaceOperations parkingSpaceOperations;
    private Validation validation;
    private DataBaseAdministration dataBaseAdministration;
    private VehicleRepository vehicleRepository;
    private BillOperations billOperations;
    private CilindrajeRulesOperations cilindrajeRulesOperations;
    private CylindricalRules cilindricalRules;
    private TariffOperations tariffOperations;
    private Tariff tariff;
    private Long numberMinuts;
    private int idSpaceParking;

    public VehicleOperations() {
        validation = new Validation();
        vehicleRepository = new VehicleRepositoryImpl();
        dataBaseAdministration = new DataBaseAdministration();
        vehicleRepository = new VehicleRepositoryImpl();
        parkingSpaceOperations = new ParkingSpaceOperations();
        billOperations = new BillOperations();
        cilindrajeRulesOperations = new CilindrajeRulesOperations();
        tariffOperations = new TariffOperations();
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
        tariff = tariffOperations.getTariff();
        response.cost = billOperations.calculateCost(numberMinuts, tariff, null, 0);
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
        tariff = tariffOperations.getTariff();
        cilindricalRules = cilindrajeRulesOperations.getRules();
        response.cost = billOperations.calculateCost(numberMinuts, tariff, cilindricalRules, motorcycle.getCylindrical());
        if (vehicleRepository.deleteMotorcycle(motorcycle.getPlate()) == true && parkingSpaceOperations.freeUpSpace(motorcycle.getFkParkingSpace()) == true) {
            response.state = true;
            response.typeTransaction = Constant.CHECKOUT_CAR_MOTORCYCLE;
            response.msg = Constant.COSTO_TOTAL + ": $ " + response.cost;
        }
        return response;
    }
}
