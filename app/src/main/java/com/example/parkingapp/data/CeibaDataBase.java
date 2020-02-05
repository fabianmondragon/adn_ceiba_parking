package com.example.parkingapp.data;


import androidx.databinding.adapters.Converters;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.parkingapp.data.converters.ConvertersDate;
import com.example.parkingapp.data.database.Car;
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


@Database(  entities = { Car.class, CilindrajeRules.class, Motorcycle.class, Parking.class, ParkingSpace.class, PlateRules.class, Tariff.class, }, version = CeibaDataBase.VERSION)
@TypeConverters({ConvertersDate.class})
public abstract class CeibaDataBase extends RoomDatabase {

    static final int VERSION = 1;

    public abstract CarDao carDao ();
    public abstract MotorCycleDao motorCycleDao();
    public abstract ParkingDao parkingDao();
    public abstract TariffDao tariffDao();
    public abstract PlateRulesDao plateRulesDao();
    public abstract ParkingSpaceDao parkingSpaceDao();
    public abstract CilindrajeRulesDao cilindrajeRulesDao();





}
