package com.example.parkingapp.domain.services;

import android.os.AsyncTask;

import com.example.parkingapp.TransactionResponse;
import com.example.parkingapp.conversions.ConversionType;
import com.example.parkingapp.data.repository.CilindrajeImpl;
import com.example.parkingapp.data.repository.CilindrajeRepository;
import com.example.parkingapp.data.repository.ParkingImpl;
import com.example.parkingapp.data.repository.ParkingRepository;
import com.example.parkingapp.data.repository.RequestListener;
import com.example.parkingapp.data.repository.ParkingSpaceImpl;
import com.example.parkingapp.data.repository.TariffRepository;
import com.example.parkingapp.data.repository.TariffRepositoryImpl;
import com.example.parkingapp.data.repository.VehicleRepository;
import com.example.parkingapp.data.repository.VehicleRepositoryImpl;
import com.example.parkingapp.domain.Register;
import com.example.parkingapp.domain.model.Car;
import com.example.parkingapp.domain.model.Domain;
import com.example.parkingapp.domain.model.CylindricalRules;
import com.example.parkingapp.domain.model.Motorcycle;
import com.example.parkingapp.domain.model.lParkingDetail;
import com.example.parkingapp.domain.model.Parking;
import com.example.parkingapp.domain.model.DomainRespond;
import com.example.parkingapp.domain.model.Tariff;
import com.example.parkingapp.util.Constant;

import java.util.Calendar;
import java.util.Date;

import static com.example.parkingapp.util.Constant.SET_CAR;
import static com.example.parkingapp.util.Constant.SET_MOTORCYCLE;
import static com.example.parkingapp.util.Constant.SET_MOTORCYCLE_NO_AUTORIZED;

public class VehicleOperations implements Register, RequestListener {

    private DataBaseAdministration dataBaseAdministration;
    private TariffRepository tariffRepository;
    private ParkingRepository parkingRepository;
    private VehicleRepository vehicleRepository;
    private CilindrajeRepository cilindrajeRepository;

    private ConversionType conversionType;
    private RequestListener requestListener;
    final private static int IS_A_MOTORCYCLE = 1;
    final private static int IS_A_CAR = 2;

    public VehicleOperations() {

        tariffRepository = new TariffRepositoryImpl();
        parkingRepository = new ParkingImpl();
        vehicleRepository = new VehicleRepositoryImpl();
        cilindrajeRepository = new CilindrajeImpl();
        dataBaseAdministration = new DataBaseAdministration();
        conversionType = ConversionType.getInstance();
        vehicleRepository = new VehicleRepositoryImpl();
       /* parkingImpl = new ParkingImpl();
        parkingSpaceImpl = new ParkingSpaceImpl();
        cilindrajeImpl = new CilindrajeImpl();
        tariffRepositoryImpl = new TariffRepositoryImpl();*/
    }

    public void fillDataBase (){
        dataBaseAdministration.fillDataBase();
    }

    public void freeUpSpace (){
        dataBaseAdministration.freeUpDataBaseSpace();
    }

    @Override
    public void registerVehicle(final Domain vehicle) {


        /*
        new AsyncTask<Void, Void, DomainRespond>() {
            @Override
            protected DomainRespond doInBackground(Void... voids) {
                DomainRespond domainRespond = new DomainRespond();
                ParkingEntity parking;
                TransactionResponse transactionResponse;
                Date date = Calendar.getInstance().getTime();
                int parkingSpaceFree = -1;
                int size;
                Validation validation = new Validation();
                if (validation.isValid(vehicle.getPlate())) {
                    parking = conversionType.getParkingFromDomainToRepository(parkingImpl).get(0);
                    if (vehicle.getType() == IS_A_MOTORCYCLE) {
                        size = vehicleRepositoryImpl.getListMotorCycle().size();
                        if (size < parking.getNumMotorcycle()) {
                            parkingSpaceFree = parkingSpaceImpl.getFree();
                            if (conversionType.registerMotoFromDomainToRepository(vehicle, vehicleRepositoryImpl, parkingSpaceFree) == true) {
                                parkingSpaceImpl.updateParkingSpace(parkingSpaceFree, date);
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
                        size = vehicleRepositoryImpl.getListCar().size();
                        if (size < parking.getNumCars()) {
                            parkingSpaceFree = parkingSpaceImpl.getFree();
                            if (conversionType.registerCarFromDomainToRepository(vehicle, vehicleRepositoryImpl, parkingSpaceFree) == true) {
                                parkingSpaceImpl.updateParkingSpace(parkingSpaceFree, date);
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
                } else {
                    domainRespond.setState(false);
                    domainRespond.setMsg(Constant.NO_AUTORIZED);
                    domainRespond.setTipeTransaction(SET_MOTORCYCLE_NO_AUTORIZED);
                }
                return domainRespond;
            }

            @Override
            protected void onPostExecute(DomainRespond respond) {
                super.onPostExecute(respond);
                if (respond.isState()) {
                    if (respond.getTipeTransaction() == SET_CAR || respond.getTipeTransaction() == SET_MOTORCYCLE) {
                        requestListener.respond(new TransactionResponse(true, Constant.SET_MOTORCYCLE, Constant.REGISTER_SUCCESSFULL));
                    }
                } else if (respond.getTipeTransaction() == SET_CAR || respond.getTipeTransaction() == SET_MOTORCYCLE) {
                    requestListener.respond(new TransactionResponse(false, Constant.SET_MOTORCYCLE, Constant.REGISTER_UNSUCCEFULL));
                } else if (respond.getTipeTransaction() == SET_MOTORCYCLE_NO_AUTORIZED) {
                    requestListener.respond(new TransactionResponse(false, SET_MOTORCYCLE_NO_AUTORIZED, Constant.NO_AUTORIZED));
                }
            }
        }.execute();*/
    }


    public void setRegisterListener(RequestListener registerListener) {
        this.requestListener = registerListener;
    }

    @Override
    public void respond(TransactionResponse repondTransaction) {
    }

    public void checkoutVehicle(final Domain domain) {
        /*new AsyncTask<Void, Void, Long>() {
            Domain domainCost;
            CylindricalRules cilindrajeRules;
            TariffEntity tariff;
            Long cost;
            Bill bill = new Bill();

            @Override
            protected Long doInBackground(Void... voids) {
                Date date = conversionType.getTimeFromDomainToRepository(domain, parkingSpaceImpl);
                if (date == null) {
                    return Long.valueOf(-1);
                }
                Date dateActual = Calendar.getInstance().getTime();
                lParkingDetail lParkingDetail = bill.calculateTime(dateActual, date);
                tariff = conversionType.getTariffFromDomaintToRepository(tariffRepositoryImpl);
                if (IS_A_MOTORCYCLE == domain.getType()) {
                    domainCost = conversionType.getMotoFromDomainToRepository(domain, vehicleRepositoryImpl);
                    cilindrajeRules = conversionType.getRuleCilindrajeFromDomaitnToRespository(cilindrajeImpl);
                    cost = bill.calculateCost(lParkingDetail, tariff, cilindrajeRules, domainCost.getCilindraje());
                    lParkingDetail.setCost(cost);
                    vehicleRepositoryImpl.deleteMotorcycle(domainCost.getPlate());

                } else if (IS_A_CAR == domain.getType()) {
                    domainCost = conversionType.getCarFromDomainToRepository(domain, vehicleRepositoryImpl);
                    cost = bill.calculateCost(lParkingDetail, tariff, cilindrajeRules, domainCost.getCilindraje());
                    vehicleRepositoryImpl.deleteCar(domainCost.getPlate());
                    lParkingDetail.setCost(cost);
                }
                parkingSpaceImpl.freeSpace(domainCost.getFkSpace());
                return cost;
            }

            @Override
            protected void onPostExecute(Long respond) {
                if (respond != -1) {
                    requestListener.respond(new TransactionResponse(true, Constant.SET_MOTORCYCLE, Constant.COSTO_TOTAL + " " + cost, cost));
                } else {
                    requestListener.respond(new TransactionResponse(false, Constant.SET_MOTORCYCLE, Constant.REGISTER_UNSUCCEFULL));
                }

            }

        }.execute();*/
    }


    public void registerMotorCycle(Motorcycle motorcycle) {
        vehicleRepository.setMotorcycle(motorcycle, 1);
    }

    public void registerCar(Car car) {
        vehicleRepository.setCar(car, 1);
    }

    public void checkoutCar(Car car) {
        vehicleRepository.deleteCar(car.getPlate());
    }


    public void checkOutMotorcycle(Motorcycle motorcycle) {
        vehicleRepository.deleteMotorcycle(motorcycle.getPlate());
    }
}
