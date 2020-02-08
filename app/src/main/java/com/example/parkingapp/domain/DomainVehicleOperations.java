package com.example.parkingapp.domain;

import android.os.AsyncTask;

import com.example.parkingapp.BaseApplication;
import com.example.parkingapp.TransactionResponse;
import com.example.parkingapp.data.ParkingRepository;
import com.example.parkingapp.data.RegisterRepository;
import com.example.parkingapp.data.RequestListener;
import com.example.parkingapp.data.RespondData;
import com.example.parkingapp.data.SpaceParkingRepository;
import com.example.parkingapp.data.VehicleRepository;
import com.example.parkingapp.data.database.Motorcycle;
import com.example.parkingapp.data.database.Parking;
import com.example.parkingapp.domain.model.DomainParking;
import com.example.parkingapp.domain.model.DomainVehicle;
import com.example.parkingapp.conversions.ConversionType;
import com.example.parkingapp.util.Constant;

import java.util.List;

public class DomainVehicleOperations implements Register, RequestListener {

    private RegisterRepository registerRepository;
    private VehicleRepository vehicleRepository;
    private SpaceParkingRepository spaceParkingRepository;
    private ParkingRepository parkingRepository;
    private ConversionType conversionType;
    private RequestListener requestListener;

    final static int IS_A_MOTORCYCLE = 1;
    final static int IS_A_CAR = 2;


    public DomainVehicleOperations() {
        conversionType = ConversionType.getInstance();
        vehicleRepository = new VehicleRepository();
        parkingRepository = new ParkingRepository();
        spaceParkingRepository = new SpaceParkingRepository();
    }

    @Override
    public void registerVehicle(final com.example.parkingapp.domain.model.DomainVehicle vehicle) {
        new AsyncTask<Void, Void, Boolean>() {
            @Override
            protected Boolean doInBackground(Void... voids) {
                DomainParking domainParking;
                TransactionResponse transactionResponse;
                int parkingSpaceFree =-1;
                int size;
                domainParking =conversionType.getParkingFromDomainToRepository ( parkingRepository).get(0);
                if (vehicle.getType() ==IS_A_MOTORCYCLE ){
                    size = vehicleRepository.getListMotorCycle().size();
                    if ( size < domainParking.getNumMotorcycle()  ){
                        parkingSpaceFree = spaceParkingRepository.getFree ();

                        if ( conversionType.registerMotoFromDomainToRepository (vehicle, vehicleRepository, parkingSpaceFree) == true)
                        {
                            spaceParkingRepository.updateParkingSpace(parkingSpaceFree);
                           return true;
                        }else{
                           return false;
                        }
                    }
                    else{
                        return false;
                    }
                }else if (vehicle.getType() ==IS_A_CAR ){
                    size = vehicleRepository.getListCar().size();
                    if ( size < domainParking.getNumCars()  ){
                        parkingSpaceFree = spaceParkingRepository.getFree ();
                        if ( conversionType.registerCarFromDomainToRepository (vehicle, vehicleRepository, parkingSpaceFree) == true)
                        {
                            spaceParkingRepository.updateParkingSpace(parkingSpaceFree);
                            return true;
                        }else{
                            return false;
                        }
                    }
                    else{
                        return false;
                    }
                }
                return  false;
            }

            @Override
            protected void onPostExecute(Boolean respond) {
                super.onPostExecute(respond);
                if (respond == true){
                    requestListener.respond(new TransactionResponse(true, Constant.SET_MOTORCYCLE, Constant.REGISTER_SUCCESSFULL));
                }else {
                    requestListener.respond(new TransactionResponse(false, Constant.SET_MOTORCYCLE, Constant.REGISTER_UNSUCCEFULL));
                }

            }
        }.execute();

    }



    public void setRegisterListener(RequestListener registerListener) {
        this.requestListener = registerListener;

    }

    @Override
    public void respond(TransactionResponse repondTransaction) {

    }
}
