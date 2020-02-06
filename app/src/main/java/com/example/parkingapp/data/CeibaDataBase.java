package com.example.parkingapp.data;


import android.content.Context;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.databinding.adapters.Converters;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;



import com.example.parkingapp.data.converters.ConvertersDate;
import com.example.parkingapp.data.database.Car;
import com.example.parkingapp.data.database.CarCopia;
import com.example.parkingapp.data.database.CarCopiaDao;
import com.example.parkingapp.data.database.CarDao;
import com.example.parkingapp.data.database.CilindrajeRules;
import com.example.parkingapp.data.database.CilindrajeRulesDao;
import com.example.parkingapp.data.database.MotorCycleDao;
import com.example.parkingapp.data.database.Motorcycle;
import com.example.parkingapp.data.database.Parking;
import com.example.parkingapp.data.database.ParkingDao;
import com.example.parkingapp.data.database.ParkingSpace;
import com.example.parkingapp.data.database.ParkingSpaceDao;
import com.example.parkingapp.data.database.PlateRules;
import com.example.parkingapp.data.database.PlateRulesDao;
import com.example.parkingapp.data.database.Tariff;
import com.example.parkingapp.data.database.TariffDao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.time.chrono.ThaiBuddhistChronology.INSTANCE;


@Database(  entities = {CarCopia.class, Car.class, CilindrajeRules.class, Motorcycle.class, Parking.class, ParkingSpace.class, PlateRules.class, Tariff.class, }, version = CeibaDataBase.VERSION)
@TypeConverters({ConvertersDate.class})
public abstract class CeibaDataBase extends RoomDatabase {

    static final int VERSION = 1;

    public abstract CarDao carDao();

    public abstract CarCopiaDao carDaoCopia();

    public abstract MotorCycleDao motorCycleDao();

    public abstract ParkingDao parkingDao();

    public abstract TariffDao tariffDao();

    public abstract PlateRulesDao plateRulesDao();

    public abstract ParkingSpaceDao parkingSpaceDao();

    public abstract CilindrajeRulesDao cilindrajeRulesDao();


    private static volatile CeibaDataBase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);


    static CeibaDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (CeibaDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            CeibaDataBase.class, "parking_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Override the onOpen method to populate the database.
     * For this sample, we clear the database every time it is created or opened.
     *
     * If you want to populate the database only when the database is created for the 1st time,
     * override RoomDatabase.Callback()#onCreate
     */
    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);

            // If you want to keep data through app restarts,
            // comment out the following block

        }
    };




}
