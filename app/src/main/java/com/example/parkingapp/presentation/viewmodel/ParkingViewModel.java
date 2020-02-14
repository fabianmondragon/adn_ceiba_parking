package com.example.parkingapp.presentation.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.parkingapp.TransactionResponse;
import com.example.parkingapp.conversions.ConversionType;
import com.example.parkingapp.data.repository.RequestListener;
import com.example.parkingapp.domain.model.Car;
import com.example.parkingapp.domain.model.Motorcycle;
import com.example.parkingapp.domain.model.Validation;
import com.example.parkingapp.domain.services.VehicleOperations;
import com.example.parkingapp.util.Constant;


public class ParkingViewModel extends AndroidViewModel implements RequestListener {

    private ConversionType conversionType;
    private VehicleOperations vehicleOperations;

    public MutableLiveData<String> motoPlate = new MutableLiveData();
    public MutableLiveData<String> carPlate = new MutableLiveData();
    public MutableLiveData<String> motoCilindraje = new MutableLiveData();
    private RequestListener listener;
    private Validation validationPresentation;

    MutableLiveData<String> msg = new MutableLiveData<>();

    public ParkingViewModel(Application application) {
        super(application);
        vehicleOperations = new VehicleOperations();
        vehicleOperations.setRegisterListener(this);
        conversionType = ConversionType.getInstance();
        validationPresentation = new Validation();
    }

    public void onClickRegisterMotorCycle() {
        if (validationPresentation.validateFieldMotorcycle(motoPlate.getValue(), motoCilindraje.getValue())) {
            Motorcycle motorcycle = new Motorcycle(motoPlate.getValue(), Integer.parseInt(motoCilindraje.getValue()));
            vehicleOperations.registerMotorCycle(motorcycle);
        } else {
            msg.setValue(Constant.INCOMPLETED_INFORMATION);
        }
    }

    public void onClickRegisterCar() {
        if (validationPresentation.validateFieldCar(carPlate.getValue())) {
            Car car = new Car(carPlate.getValue());
            vehicleOperations.registerCar(car);
        } else {
            msg.setValue(Constant.INCOMPLETED_INFORMATION);
        }
    }

    public void onClickCheckOutMotorCycle() {
        Motorcycle motorcycle = new Motorcycle(motoPlate.getValue());
        vehicleOperations.checkOutMotorcycle(motorcycle);
    }

    public void onClickCheckOutCar() {
        Car car = new Car(carPlate.getValue());
        vehicleOperations.checkoutCar(car);
    }

    public void fillDataBase() {
        vehicleOperations.fillDataBase();
    }


    @Override
    public void respond(TransactionResponse repondTransaction) {

        switch (repondTransaction.getTransactionId()) {
            case Constant.SET_CAR:
                msg.setValue(repondTransaction.getMsg());
                break;
            case Constant.SET_MOTORCYCLE:
                msg.setValue(repondTransaction.getMsg());
                break;
            case Constant.SET_COST:
                msg.setValue("" + repondTransaction.getCost());
                break;
            case Constant.SET_MOTORCYCLE_NO_AUTORIZED:
                msg.setValue(repondTransaction.getMsg());
                break;
        }
    }

    public MutableLiveData<String> getMsg() {
        return msg;
    }
}