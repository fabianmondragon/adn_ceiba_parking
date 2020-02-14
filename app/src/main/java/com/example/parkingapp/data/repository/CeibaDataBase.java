package com.example.parkingapp.data.repository;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.parkingapp.data.converters.ConvertersDate;
import com.example.parkingapp.data.database.entity.CarEntity;
import com.example.parkingapp.data.database.dao.CarDao;
import com.example.parkingapp.data.database.entity.CilindrajeRulesEntity;
import com.example.parkingapp.data.database.dao.CilindrajeRulesDao;
import com.example.parkingapp.data.database.dao.MotorCycleDao;
import com.example.parkingapp.data.database.entity.MotorcycleEntity;
import com.example.parkingapp.data.database.entity.ParkingEntity;
import com.example.parkingapp.data.database.dao.ParkingDao;
import com.example.parkingapp.data.database.entity.ParkingSpaceEntitiy;
import com.example.parkingapp.data.database.dao.ParkingSpaceDao;
import com.example.parkingapp.data.database.entity.PlateRulesEntity;
import com.example.parkingapp.data.database.dao.PlateRulesDao;
import com.example.parkingapp.data.database.entity.TariffEntity;
import com.example.parkingapp.data.database.dao.TariffDao;


@Database(entities = {CarEntity.class, CilindrajeRulesEntity.class, MotorcycleEntity.class, ParkingEntity.class, ParkingSpaceEntitiy.class, PlateRulesEntity.class, TariffEntity.class,}, version = CeibaDataBase.VERSION, exportSchema = false)
@TypeConverters({ConvertersDate.class})
public abstract class CeibaDataBase extends RoomDatabase {

    static final int VERSION = 1;

    public abstract CarDao carDao();

    public abstract MotorCycleDao motorCycleDao();

    public abstract ParkingDao parkingDao();

    public abstract TariffDao tariffDao();

    public abstract PlateRulesDao plateRulesDao();

    public abstract ParkingSpaceDao parkingSpaceDao();

    public abstract CilindrajeRulesDao cilindrajeRulesDao();

    private static volatile CeibaDataBase INSTANCE;


    public static CeibaDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (CeibaDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context,
                            CeibaDataBase.class, "parking_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            // If you want to keep data through app restarts,
            // comment out the following block

        }
    };


}
