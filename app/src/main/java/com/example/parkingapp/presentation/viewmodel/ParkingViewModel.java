package com.example.parkingapp.presentation.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.parkingapp.BaseApplication;
import com.example.parkingapp.domain.model.Car;
import com.example.parkingapp.domain.model.Motorcycle;
import com.example.parkingapp.domain.model.Response;
import com.example.parkingapp.domain.model.Validation;
import com.example.parkingapp.domain.services.VehicleOperations;
import com.example.parkingapp.presentation.Constant;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class ParkingViewModel extends AndroidViewModel {

    private static final String TAG = ParkingViewModel.class.getName();

    public MutableLiveData<String> motorcyclePlate = new MutableLiveData();
    public MutableLiveData<String> carPlate = new MutableLiveData();
    public MutableLiveData<String> motorcycleCylindrical = new MutableLiveData();
    public MutableLiveData<String> message = new MutableLiveData<>();

    private Observable<Response> registrationObservable;
    private Observable<Response> carObservable;
    private Observable<Response> motorcycleCheckOutObservable;
    private Observable<Response> carCheckoutObservable;

    @Inject
    VehicleOperations vehicleOperations;
    @Inject
    Validation validation;

    Response response;


    public ParkingViewModel(Application application) {
        super(application);
        ((BaseApplication) getApplication()).getAppComponent().inject(this);
        response = new Response();
        response.state=false;
        response.msg = Constant.INCOMPLETE_INFORMATION;
    }


    public Response registerMotorcycle() {
        final Motorcycle motorcycle = new Motorcycle(motorcyclePlate.getValue(), Integer.parseInt(motorcycleCylindrical.getValue()));
        return vehicleOperations.registerMotorcycle(motorcycle);
    }

    public void onClickRegisterMotorCycle() {
        if (validation.validateMotorcycleFields(motorcyclePlate.getValue(), motorcycleCylindrical.getValue())) {
            registrationObservable = Observable.create(new ObservableOnSubscribe<Response>() {
                @Override
                public void subscribe(ObservableEmitter<Response> emitter) throws Exception {
                    emitter.onNext(registerMotorcycle());
                }
            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());

            registrationObservable.subscribe(new Observer<Response>() {

                @Override
                public void onSubscribe(Disposable d) {
                    // no se requiere debido a que solo requerimos conocer el momento de la respuesta
                }

                @Override
                public void onNext(Response response) {
                    typeTransaction(response);
                }

                @Override
                public void onError(Throwable e) {
                    Log.e(TAG, e.getMessage());
                    message.setValue(Constant.GENERAL_ERROR);
                }

                @Override
                public void onComplete() {
                    // No se requiere el manejo de este metodo, solo se requiere conocer la respuesta

                }
            });
        } else {
            message.setValue(Constant.INCOMPLETE_INFORMATION);
        }
    }

    public void typeTransaction(Response response) {
        message.setValue(response.msg);
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
                    // no se requiere debido a que solo requerimos conocer el momento de la respuesta
                }

                @Override
                public void onNext(Response response) {
                    typeTransaction(response);
                }

                @Override
                public void onError(Throwable e) {
                    Log.e(TAG, e.getMessage());
                    message.setValue(Constant.GENERAL_ERROR);
                }

                @Override
                public void onComplete() {
                    // No se requiere el manejo de este metodo, solo se requiere conocer la respuesta
                }
            });
        } else {
            message.setValue(Constant.INCOMPLETE_INFORMATION);
        }
    }

    public Response registerCar() {
        if (!carPlate.getValue().equals(""))
        {
            Car car = new Car(carPlate.getValue());
            return vehicleOperations.registerCar(car);
        }
        message.setValue(Constant.INCOMPLETE_INFORMATION);
        response.msg = Constant.INCOMPLETE_INFORMATION;
        response.state = false;
        return response;
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
                // no se requiere debido a que solo requerimos conocer el momento de la respuesta
            }

            @Override
            public void onNext(Response response) {
                typeTransaction(response);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, e.getMessage());
                message.setValue(Constant.GENERAL_ERROR);
            }

            @Override
            public void onComplete() {
                // No se requiere el manejo de este metodo, solo se requiere conocer la respuesta
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
                // no se requiere debido a que solo requerimos conocer el momento de la respuesta
            }

            @Override
            public void onNext(Response response) {
                typeTransaction(response);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, e.getMessage());
                message.setValue(Constant.GENERAL_ERROR);
            }

            @Override
            public void onComplete() {
                // No se requiere el manejo de este metodo, solo se requiere conocer la respuesta
            }
        });
    }

    public MutableLiveData<String> getMsg() {
        return message;
    }
}