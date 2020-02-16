package com.example.parkingapp.data.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.parkingapp.data.database.entity.TariffEntity;

import java.util.List;

@Dao
public interface TariffDao {
    @Query("SELECT * FROM tariffentity")
    List<TariffEntity> getAll();

    @Insert
    void insertTarif(TariffEntity tariffEntity);

    @Query("SELECT * FROM TariffEntity LIMIT 1")
    public TariffEntity getTariff();
}
