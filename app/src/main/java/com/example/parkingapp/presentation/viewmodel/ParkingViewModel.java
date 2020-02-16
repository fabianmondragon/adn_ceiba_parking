package com.example.parkingapp.presentation.viewmodel;

import android.app.Application;
import android.widget.Switch;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.parkingapp.TransactionResponse;
import com.example.parkingapp.conversions.ConversionType;
import com.example.parkingapp.data.repository.RequestListener;
import com.example.parkingapp.domain.model.Car;
import com.example.parkingapp.domain.model.Motorcycle;
import com.example.parkingapp.domain.model.Response;
import com.example.parkingapp.domain.model.Validation;
import com.example.parkingapp.domain.services.VehicleOperations;
import com.example.parkingapp.util.Constant;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class ParkingViewModel extends AndroidViewModel implements RequestListener {

    private ConversionType conversionType;
    private VehicleOperations vehicleOperations;
    Observable<Response> registrationObservable;
    Observable<Response> dataBaseObserver;
    Observable<Response> carObservable;
    Observable<Response> checkoutMotorcycle;
    Observable<Response> checkoutCar;

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

    public void fillDataBaseWithInfo() {
        dataBaseObserver = Observable.create(new ObservableOnSubscribe<Response>() {

            @Override
            public void subscribe(ObservableEmitter<Response> emitter) throws Exception {
                emitter.onNext(setDataBAse());
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());

        dataBaseObserver.subscribe(new Observer<Response>() {

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Response response) {
                if (response.state == true) {
                    msg.setValue(Constant.SUCCESSFULL_LOAD_DATA_BASE);
                } else {
                    msg.setValue(Constant.REGISTER_UNSUCCEFULL);
                }
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError!");
            }

            @Override
            public void onComplete() {
                System.out.println("Complete!");
            }
        });

    }

    public Response setDataBAse() {
        return vehicleOperations.fillDataBase();
    }

    public Response registerMotorcycle() {
        final Motorcycle motorcycle = new Motorcycle(motoPlate.getValue(), Integer.parseInt(motoCilindraje.getValue()));
        return vehicleOperations.registerMotorCycle(motorcycle);
        //return response;
    }

    public void onClickRegisterMotorCycle() {
        if (validationPresentation.validateFieldMotorcycle(motoPlate.getValue(), motoCilindraje.getValue())) {
            registrationObservable = Observable.create(new ObservableOnSubscribe<Response>() {
                @Override
                public void subscribe(ObservableEmitter<Response> emitter) throws Exception {
                    emitter.onNext(registerMotorcycle());
                }
            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            registrationObservable.subscribe(new Observer<Response>() {

                @Override
                public void onSubscribe(Disposable d) {

                }

                @Override
                public void onNext(Response response) {
                    typeTransaction(response);
                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onComplete() {

                }
            });
        } else {

            msg.setValue(Constant.INCOMPLETED_INFORMATION);

        }
    }

    public void typeTransaction(Response response) {
        msg.setValue(response.msg);
        /*switch (response.typeTransaction){
            case Constant.SET_CAR:
                break;
            case Constant.SET_MOTORCYCLE:
                break;

            case Constant.SET_COST:
                break;

            case Constant.SET_MOTORCYCLE_NO_AUTORIZED:
                break;

            case Constant.CHECKOUT_CAR_MOTORCYCLE:
                break;
        }*/

        /*if (response.typeTransaction == Constant.SET_MOTORCYCLE) {
            if (response.state == true) {
                msg.setValue(response.msg);
            } else {
                msg.setValue(response.msg);
            }
        } else if (response.typeTransaction == Constant.SET_CAR) {
            if (response.state == true) {
                msg.setValue(response.msg);
            }
        } else {
            msg.setValue(response.msg);
        }*/
    }

    public void onClickRegisterCar() {
        if (validationPresentation.validateFieldCar(carPlate.getValue())) {
            carObservable = Observable.create(new ObservableOnSubscribe<Response>() {
                @Override
                public void subscribe(ObservableEmitter<Response> emitter) throws Exception {
                    emitter.onNext(registerCar());
                }
            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            carObservable.subscribe(new Observer<Response>() {

                @Override
                public void onSubscribe(Disposable d) {

                }

                @Override
                public void onNext(Response response) {
                    typeTransaction(response);
                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onComplete() {

                }
            });

        } else {
            msg.setValue(Constant.INCOMPLETED_INFORMATION);
        }
    }

    public Response registerCar() {
        Car car = new Car(carPlate.getValue());
        return vehicleOperations.registerCar(car);
    }

    public void onClickCheckOutMotorCycle() {
        checkoutMotorcycle = Observable.create(new ObservableOnSubscribe<Response>() {
            @Override
            public void subscribe(ObservableEmitter<Response> emitter) throws Exception {
                emitter.onNext(takeMotorcycleParking());
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        checkoutMotorcycle.subscribe(new Observer<Response>() {

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Response response) {
                typeTransaction(response);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });


    }

    public Response takeMotorcycleParking (){
        Motorcycle motorcycle = new Motorcycle(motoPlate.getValue());
        return vehicleOperations.checkOutMotorcycle(motorcycle);
    }

    public Response takeCarParking (){
        Car car = new Car(carPlate.getValue());
        return vehicleOperations.checkoutCar(car);
    }

    public void onClickCheckOutCar() {
        checkoutCar = Observable.create(new ObservableOnSubscribe<Response>() {
            @Override
            public void subscribe(ObservableEmitter<Response> emitter) throws Exception {
                emitter.onNext(takeCarParking());
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        checkoutCar.subscribe(new Observer<Response>() {

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Response response) {
                typeTransaction(response);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });


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