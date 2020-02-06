package com.example.parkingapp.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.parkingapp.data.ParkingRepository;
import com.example.parkingapp.data.database.Car;
import com.example.parkingapp.data.database.CarCopia;
import com.example.parkingapp.data.database.Motorcycle;
import com.example.parkingapp.data.database.Parking;

import java.util.List;


public class ParkingViewModel extends AndroidViewModel {

    private ParkingRepository parkingRepository;
    public MutableLiveData<String> plateMoto = new MutableLiveData();
    public MutableLiveData<String> plateCar = new MutableLiveData();
    public MutableLiveData<String> cilindrajeMoto = new MutableLiveData();

    public ParkingViewModel(Application application) {
        super(application);
        parkingRepository = new ParkingRepository(application);
        this.parkingRepository = parkingRepository;
        parkingRepository.fillDataBase();
    }

    public void onClickRegister (){
        Car car = new Car(plateCar.toString());
        parkingRepository.registerCar(car);
    }
    public void onClickRegisterMotorCycle (){
        parkingRepository.registerMotorcycle(plateMoto.getValue(), cilindrajeMoto.getValue());

    }
    public void onClickBillMotorCycle ()
    {

    }
    public void onClickRegisterCar()
    {

    }
    public void onClickBillCar ()
    {
        //parkingRepository.getCar();
    }

    public LiveData<List<CarCopia>> getCarCopiaList (){
        return parkingRepository.getCarCopia();
    }

    public LiveData<List<Parking>> getParkingAll (){
        return parkingRepository.getParking();
    }
    public LiveData<List<Motorcycle>> getMotorcicleAll (){
        return parkingRepository.getMotorcycleAll();
    }




}