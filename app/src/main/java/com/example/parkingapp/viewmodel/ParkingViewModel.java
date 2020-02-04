package com.example.parkingapp.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.parkingapp.repository.ParkingRepository;

import javax.inject.Inject;



public class ParkingViewModel extends ViewModel {

    @Inject
    public ParkingViewModel(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    private ParkingRepository parkingRepository;
    public MutableLiveData<String> plateMoto = new MutableLiveData();
    public MutableLiveData<String> plateCar = new MutableLiveData();
    public MutableLiveData<String> cilindrajeMoto = new MutableLiveData();

    public void onClickRegister (){
        //Car car = new Car(plateCar.toString());
        //parkingRepository.registerCar(car);
    }
    public void onClickRegisterMotorCycle (){
        //Motorcycle motorcycle =new Motorcycle(plateMoto.toString());
        //parkingRepository.registerMotorcycle(motorcycle);

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




}