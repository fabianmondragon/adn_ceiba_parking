package com.example.parkingapp.presentation.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.parkingapp.BaseApplication;
import com.example.parkingapp.domain.model.Car;
import com.example.parkingapp.domain.model.Motorcycle;
import com.example.parkingapp.domain.model.Response;
import com.example.parkingapp.domain.model.Validation;
import com.example.parkingapp.domain.services.VehicleOperations;
import com.example.parkingapp.util.Constant;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class ParkingViewModel extends AndroidViewModel {

    public MutableLiveData<String> motorcyclePlate = new MutableLiveData();
    public MutableLiveData<String> carPlate = new MutableLiveData();
    public MutableLiveData<String> motorcycleCilindraje = new MutableLiveData();
    public MutableLiveData<String> msg = new MutableLiveData<>();

    private Observable<Response> registrationObservable;
    private Observable<Response> dataBaseObserver;
    private Observable<Response> carObservable;
    private Observable<Response> motorcycleCheckOutObservable;
    private Observable<Response> carCheckoutObservable;

    @Inject
    VehicleOperations vehicleOperations;
    @Inject
    Validation validation;


    public ParkingViewModel(Application application) {
        super(application);
        ((BaseApplication) getApplication()).getAppComponent().inject(this);
    }

    public void fillDataBaseWithInfo() {
        dataBaseObserver = Observable.create(new ObservableOnSubscribe<Response>() {

            @Override
            public void subscribe(ObservableEmitter<Response> emitter) throws Exception {
                emitter.onNext(setDataBase());
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

    public Response registerMotorcycle() {
        final Motorcycle motorcycle = new Motorcycle(motorcyclePlate.getValue(), Integer.parseInt(motorcycleCilindraje.getValue()));
        return vehicleOperations.registerMotorCycle(motorcycle);
    }

    public void onClickRegisterMotorCycle() {
        if (validation.validateMotorcycleFields(motorcyclePlate.getValue(), motorcycleCilindraje.getValue())) {
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
    }

    public void onClickRegisterCar() {
        if (validation.validateFieldCar(carPlate.getValue())) {
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
        motorcycleCheckOutObservable = Observable.create(new ObservableOnSubscribe<Response>() {
            @Override
            public void subscribe(ObservableEmitter<Response> emitter) throws Exception {
                emitter.onNext(takeMotorcycleParking());
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());

        motorcycleCheckOutObservable.subscribe(new Observer<Response>() {

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

    public Response takeMotorcycleParking() {
        Motorcycle motorcycle = new Motorcycle(motorcyclePlate.getValue());
        return vehicleOperations.checkOutMotorcycle(motorcycle);
    }

    public Response takeCarParking() {
        Car car = new Car(carPlate.getValue());
        return vehicleOperations.checkoutCar(car);
    }

    public void onClickCheckOutCar() {
        carCheckoutObservable = Observable.create(new ObservableOnSubscribe<Response>() {
            @Override
            public void subscribe(ObservableEmitter<Response> emitter) throws Exception {
                emitter.onNext(takeCarParking());
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        carCheckoutObservable.subscribe(new Observer<Response>() {

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

    public Response setDataBase() {
        return vehicleOperations.fillDataBase();
    }

    public MutableLiveData<String> getMsg() {
        return msg;
    }
}