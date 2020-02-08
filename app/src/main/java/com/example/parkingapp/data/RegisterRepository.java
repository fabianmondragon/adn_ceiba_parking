package com.example.parkingapp.data;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.example.parkingapp.BaseApplication;
import com.example.parkingapp.conversions.ConvesionsRequest;
import com.example.parkingapp.data.database.Motorcycle;
import com.example.parkingapp.data.database.ParkingSpace;

import java.util.List;

public class RegisterRepository  {

    private CeibaDataBase cb;
    private ModelParking modelParking;
    private Context application;
    private MutableLiveData<ConvesionsRequest> convesionsRequestMutableLiveData;

    private RequestListener requestListener;

    private static RegisterRepository instanceRegisterRepository;

    public static RegisterRepository getInstanceRegisterRepository() {
        if (instanceRegisterRepository == null)
        {
            instanceRegisterRepository = new RegisterRepository(BaseApplication.getAppContext());
        }
        return instanceRegisterRepository;
    }

    public RegisterRepository(Context context) {
        this.application = application;
    }

    public void registerMotorcycleta(String plateMoto, int cilindraje) {
        /*
        final Motorcycle motorcycle = new Motorcycle(plateMoto, cilindraje);
        final CeibaDataBase db = CeibaDataBase.getDatabase(application);

        db.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                List<ParkingSpace> parkingSpaceList= db.parkingSpaceDao().getAll();
                for (ParkingSpace item: parkingSpaceList){
                    if (item.isState()== false){
                        motorcycle.setFkParkingSpace(item.getParkingSpaceId());
                        db.parkingSpaceDao().setUpdateStateParking(true, item.getParkingSpaceId());
                        break;
                    }
                }
                db.motorCycleDao().insertMotorcycle(motorcycle);
                requestListener.respond(true);
                //convesionsRequestMutableLiveData.setValue(new ConvesionsRequest(1, "Cambio"));
            }
        });*/
    }

    public MutableLiveData<ConvesionsRequest> getRequest() {
        if (convesionsRequestMutableLiveData == null) {
            convesionsRequestMutableLiveData = new MutableLiveData<ConvesionsRequest>();
        }
        return convesionsRequestMutableLiveData;
    }

    public void getAllMotorCycle() {
       /* final CeibaDataBase db = CeibaDataBase.getDatabase(application);
        db.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                List<Motorcycle> motorcycleList= db.motorCycleDao().getAllMotorcycle();
                requestListener.respondMotorcycle(motorcycleList);
            }
        });



        TaskDataBase mytask = new TaskDataBase();
        mytask.execute();

        db.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                 db.motorCycleDao().getAll();
            }

        });*/
    }



    public void setRegisterListener(RequestListener registerListenerasdf) {
        this.requestListener = registerListenerasdf;
    }
}
