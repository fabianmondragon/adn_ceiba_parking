package com.example.parkingapp.presentation;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.example.parkingapp.TransactionResponse;
import com.example.parkingapp.TransactionResponseViewMode;
import com.example.parkingapp.conversions.ConversionType;
import com.example.parkingapp.data.ParkingRepository;
import com.example.parkingapp.data.RequestListener;
import com.example.parkingapp.data.RespondData;
import com.example.parkingapp.data.database.Motorcycle;
import com.example.parkingapp.data.database.Parking;
import com.example.parkingapp.domain.DomainManageDataBase;
import com.example.parkingapp.domain.DomainVehicleOperations;
import com.example.parkingapp.presentation.MotorcyclePresentation;
import com.example.parkingapp.util.Constant;

import java.util.List;


public class ParkingViewModel extends AndroidViewModel implements RequestListener {

    private ConversionType conversionType;
    private DomainManageDataBase domainManageDataBase;
    private ParkingRepository parkingRepository;
    public MutableLiveData<String> motoPlate = new MutableLiveData();
    public MutableLiveData<String> carPlate = new MutableLiveData();
   public MutableLiveData<String> motoCilindraje = new MutableLiveData();
    private RequestListener listener;
    private DomainVehicleOperations domainVehicleOperations;

    MutableLiveData<String> msg = new MutableLiveData<>();

    public ParkingViewModel(Application application) {
        super(application);
        domainVehicleOperations = new DomainVehicleOperations();
        domainVehicleOperations.setRegisterListener (this);
        parkingRepository = new ParkingRepository();
        conversionType = ConversionType.getInstance();
        domainManageDataBase = new DomainManageDataBase();
    }

    public void onClickRegisterMotorCycle () {
        MotorcyclePresentation motorcyclePresentation = new MotorcyclePresentation(motoPlate.getValue(), Integer.parseInt(motoCilindraje.getValue() ));
        conversionType.regiterMotoFromVMToDomain(motorcyclePresentation, domainVehicleOperations);
    }

    public void onClickRegisterCar()
    {
        CarPresentation carPresentation = new CarPresentation(carPlate.getValue());
        conversionType.regiterCarFromVMToDomain(carPresentation, domainVehicleOperations);

    }


    public void onClickBillMotorCycle ()
    {
        CarPresentation carPresentation = new CarPresentation(carPlate.getValue());
    }


    public void onClickBillCar ()
    {
        //parkingRepository.getCar();
    }



    public void fillDataBase() {
       domainManageDataBase.fillDataBase();
    }


    @Override
    public void respond(TransactionResponse repondTransaction) {
        msg.setValue(repondTransaction.getMsg());
        switch ( repondTransaction.getTransactionId()){
            case Constant.SET_CAR:

                break;
            case Constant.SET_MOTORCYCLE:

                break;
        }
    }


    public MutableLiveData<String> getMsg() {
        return msg;
    }
}