package com.example.parkingapp.data;

import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import androidx.room.Index;
import androidx.room.Room;
import com.example.parkingapp.BaseApplication;
import com.example.parkingapp.data.database.Car;
import com.example.parkingapp.data.database.CarCopia;
import com.example.parkingapp.data.database.CilindrajeRules;
import com.example.parkingapp.data.database.Motorcycle;
import com.example.parkingapp.data.database.Parking;
import com.example.parkingapp.data.database.ParkingSpace;
import com.example.parkingapp.data.database.PlateRules;
import com.example.parkingapp.data.database.Tariff;
import java.util.ArrayList;
import java.util.List;

public class ParkingRepository {

    LiveData<List<CarCopia>> listCarCopia;
    LiveData<List<Parking>> listPaking;
    LiveData<List<Motorcycle>> listMotorCycle;
    Application application;

    public ParkingRepository(Application application) {
        CeibaDataBase db = CeibaDataBase.getDatabase(application);
        listCarCopia = db.carDaoCopia().getAll();
        listPaking = db.parkingDao().getAll();
        listMotorCycle = db.motorCycleDao().getAll();
        this.application = application;
    }

    public void registerCar (final Car car){
        CeibaDataBase db = CeibaDataBase.getDatabase(application);
    }

    public void registerMotorcycle(String plateMoto, String cilindraje) {
        final Motorcycle motorcycle = new Motorcycle(plateMoto, Integer.parseInt(cilindraje));
        final CeibaDataBase db = CeibaDataBase.getDatabase(application);
        db.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                List<ParkingSpace>parkingSpaceList= db.parkingSpaceDao().getAll();
                for (ParkingSpace item: parkingSpaceList){
                    if (item.isState()== false){
                        motorcycle.setFkParkingSpace(item.getParkingSpaceId());
                        db.parkingSpaceDao().setUpdateStateParking(true, item.getParkingSpaceId());
                        break;
                    }
                }
                db.motorCycleDao().insertMotorcycle(motorcycle);
            }
        });
    }

    public void  fillDataBase (){
        final Parking parking = new Parking(20,10);
        final CilindrajeRules cilindrajeRules = new CilindrajeRules(150, 1);
        final List<ParkingSpace> parkingSpaceList = new ArrayList() {{
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
            add(new ParkingSpace(false, null, 0));
        }};

        final Tariff tariff = new Tariff(1000.0, 500.0, 8000.0,4000.0);
        final PlateRules plateRules = new PlateRules("b", true );

        final CeibaDataBase db = CeibaDataBase.getDatabase(application);
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                if (db.parkingDao().getAllParkinList().size()==0) {
                    db.parkingDao().inserParking(parking);
                    db.parkingSpaceDao().insertParkingAll(parkingSpaceList);
                    db.cilindrajeRulesDao().insertCilindrajeRules(cilindrajeRules);
                    db.tariffDao().insertTarif(tariff);
                    db.plateRulesDao().insetPlateRulse(plateRules);

                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
            }
        }.execute();

    }

    public void registerCarCopia(final CarCopia carCopia) {
        final CeibaDataBase db = CeibaDataBase.getDatabase(application);

        db.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                db.carDaoCopia().insertCarCopia(carCopia);
            }
        });
    }

    public LiveData<List<CarCopia>> getCarCopia(){
        return listCarCopia;
    }

    public LiveData<List<Parking>> getParking() {
        return listPaking;
    }

    public LiveData<List<Motorcycle>> getMotorcycleAll() {
        return listMotorCycle;
    }
}
