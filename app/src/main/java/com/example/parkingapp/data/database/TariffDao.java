package com.example.parkingapp.data.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TariffDao {
    @Query("SELECT * FROM Tariff")
    List<Tariff> getAll();

    @Insert
    void insertTarif(Tariff tariff);

    @Query("SELECT * FROM Tariff LIMIT 1")
    public Tariff getTariff();
}
