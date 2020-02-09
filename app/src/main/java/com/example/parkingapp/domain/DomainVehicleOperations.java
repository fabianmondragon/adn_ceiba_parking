package com.example.parkingapp.domain;

import android.os.AsyncTask;

import com.example.parkingapp.BaseApplication;
import com.example.parkingapp.TransactionResponse;
import com.example.parkingapp.data.CilindrajeRepository;
import com.example.parkingapp.data.ParkingRepository;
import com.example.parkingapp.data.RegisterRepository;
import com.example.parkingapp.data.RequestListener;
import com.example.parkingapp.data.RespondData;
import com.example.parkingapp.data.SpaceParkingRepository;
import com.example.parkingapp.data.TariffRepository;
import com.example.parkingapp.data.VehicleRepository;
import com.example.parkingapp.data.database.CilindrajeRules;
import com.example.parkingapp.data.database.Motorcycle;
import com.example.parkingapp.data.database.Parking;
import com.example.parkingapp.data.database.Tariff;
import com.example.parkingapp.domain.model.DomainCilindrajeRules;
import com.example.parkingapp.domain.model.DomainDetailParking;
import com.example.parkingapp.domain.model.DomainParking;
import com.example.parkingapp.domain.model.DomainRespond;
import com.example.parkingapp.domain.model.DomainTariff;
import com.example.parkingapp.domain.model.DomainVehicle;
import com.example.parkingapp.conversions.ConversionType;
import com.example.parkingapp.util.CalendarParking;
import com.example.parkingapp.util.Constant;


import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.example.parkingapp.util.Constant.SET_CAR;
import static com.example.parkingapp.util.Constant.SET_MOTORCYCLE;
import static com.example.parkingapp.util.Constant.SET_MOTORCYCLE_NO_AUTORIZED;

public class DomainVehicleOperations implements Register, RequestListener {

    private TariffRepository tariffRepository;
    private RegisterRepository registerRepository;
    private VehicleRepository vehicleRepository;
    private SpaceParkingRepository spaceParkingRepository;
    private CilindrajeRepository cilindrajeRepository;
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
        cilindrajeRepository = new CilindrajeRepository();
        tariffRepository = new TariffRepository();
    }

    @Override
    public void registerVehicle(final com.example.parkingapp.domain.model.DomainVehicle vehicle) {


        new AsyncTask<Void, Void, DomainRespond>() {
            @Override
            protected DomainRespond doInBackground(Void... voids) {
                DomainRespond domainRespond = new DomainRespond();
                DomainParking domainParking;
                TransactionResponse transactionResponse;
                CalendarParking calendarParking = new CalendarParking();
                Date date = calendarParking.getDateToday();
                int parkingSpaceFree =-1;
                int size;
                DomainValidationsParking domainValidationsParking = new DomainValidationsParking();


                if (domainValidationsParking.isValid(vehicle.getPlate()))
                {
                    domainParking = conversionType.getParkingFromDomainToRepository(parkingRepository).get(0);
                    if (vehicle.getType() == IS_A_MOTORCYCLE) {
                        size = vehicleRepository.getListMotorCycle().size();
                        if (size < domainParking.getNumMotorcycle()) {
                            parkingSpaceFree = spaceParkingRepository.getFree();
                            if (conversionType.registerMotoFromDomainToRepository(vehicle, vehicleRepository, parkingSpaceFree) == true) {
                                spaceParkingRepository.updateParkingSpace(parkingSpaceFree, date);
                                domainRespond.setMsg(Constant.REGISTER_SUCCESSFULL);
                                domainRespond.setState(true);
                                domainRespond.setTipeTransaction(Constant.SET_MOTORCYCLE);
                            } else {
                                domainRespond.setState(false);
                                domainRespond.setMsg(Constant.REGISTER_UNSUCCEFULL);
                                domainRespond.setTipeTransaction(Constant.SET_MOTORCYCLE);
                            }
                        }
                    } else if (vehicle.getType() == IS_A_CAR) {
                        size = vehicleRepository.getListCar().size();
                        if (size < domainParking.getNumCars()) {
                            parkingSpaceFree = spaceParkingRepository.getFree();
                            if (conversionType.registerCarFromDomainToRepository(vehicle, vehicleRepository, parkingSpaceFree) == true) {
                                spaceParkingRepository.updateParkingSpace(parkingSpaceFree, date);
                                domainRespond.setMsg(Constant.REGISTER_SUCCESSFULL);
                                domainRespond.setState(true);
                                domainRespond.setTipeTransaction(Constant.SET_CAR);
                            } else {
                                domainRespond.setState(false);
                                domainRespond.setMsg(Constant.REGISTER_UNSUCCEFULL);
                                domainRespond.setTipeTransaction(Constant.SET_CAR);
                            }
                        }
                    }
                }else
                {
                    domainRespond.setState(false);
                    domainRespond.setMsg(Constant.NO_AUTORIZED);
                    domainRespond.setTipeTransaction(SET_MOTORCYCLE_NO_AUTORIZED);
                }
                return  domainRespond;
            }

            @Override
            protected void onPostExecute(DomainRespond respond) {
                super.onPostExecute(respond);
                if (respond.isState()) {
                    if (respond.getTipeTransaction() == SET_CAR || respond.getTipeTransaction() == SET_MOTORCYCLE) {
                        requestListener.respond(new TransactionResponse(true, Constant.SET_MOTORCYCLE, Constant.REGISTER_SUCCESSFULL));
                    }
                } else if (respond.getTipeTransaction() == SET_CAR || respond.getTipeTransaction() == SET_MOTORCYCLE )
                {
                        requestListener.respond(new TransactionResponse(true, Constant.SET_MOTORCYCLE, Constant.REGISTER_SUCCESSFULL));
                }else if (respond.getTipeTransaction() == SET_MOTORCYCLE_NO_AUTORIZED){
                    requestListener.respond(new TransactionResponse(true, SET_MOTORCYCLE_NO_AUTORIZED, Constant.NO_AUTORIZED));
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

    public void checkoutVehicle(final DomainVehicle domainVehicle) {
        new AsyncTask<Void, Void, Long>() {
            DomainVehicle domainVehicleCost;
            DomainCilindrajeRules cilindrajeRules;
            DomainTariff domainTariff;
            Long cost;

            DomainBill domainBill = new DomainBill();
            @Override
            protected Long doInBackground(Void... voids) {
                Date date = conversionType.getTimeFromDomainToRepository (domainVehicle, spaceParkingRepository);
                if (date == null){
                    return Long.valueOf(-1);
                }
                Date dateActual = Calendar.getInstance().getTime();
                DomainDetailParking domainDetailParking = domainBill.calculateTime(dateActual, date);
                domainTariff = conversionType.getTariffFromDomaintToRepository(tariffRepository);
                if (IS_A_MOTORCYCLE == domainVehicle.getType()){
                    domainVehicleCost = conversionType.getMotoFromDomainToRepository(domainVehicle, vehicleRepository);
                    cilindrajeRules = conversionType.getRuleCilindrajeFromDomaitnToRespository(cilindrajeRepository);
                    cost = domainBill.calculateCost (domainDetailParking, domainTariff,cilindrajeRules, domainVehicleCost.getCilindraje());
                    domainDetailParking.setCost(cost);
                    vehicleRepository.deleteMotorcycle (domainVehicleCost.getPlate());

                }else if (IS_A_CAR == domainVehicle.getType()){
                    domainVehicleCost = conversionType.getCarFromDomainToRepository(domainVehicle, vehicleRepository);
                    cost = domainBill.calculateCost (domainDetailParking, domainTariff,cilindrajeRules, domainVehicleCost.getCilindraje());
                    vehicleRepository.deleteCar (domainVehicleCost.getPlate());
                    domainDetailParking.setCost(cost);
                }
                spaceParkingRepository.freeSpace (domainVehicleCost.getFk_space());
                return cost;
            }
            @Override
            protected void onPostExecute(Long respond) {
                if (respond != -1){
                    requestListener.respond(new TransactionResponse(true, Constant.SET_MOTORCYCLE, Constant.COSTO_TOTAL + " " + cost, cost));
                }
                else{
                    requestListener.respond(new TransactionResponse(false, Constant.SET_MOTORCYCLE, Constant.REGISTER_UNSUCCEFULL ));
                }

            }

        }.execute();
    }


}
