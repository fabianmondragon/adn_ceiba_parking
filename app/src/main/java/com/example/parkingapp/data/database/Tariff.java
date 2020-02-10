package com.example.parkingapp.data.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Tariff {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "tarif_id")
    private int tariffId;

    @ColumnInfo(name = "value_hour_car")
    private Double valueHorCar;

    @ColumnInfo(name = "value_hour_moto")
    private Double valueHorMoto;

    @ColumnInfo(name = "value_day_car")
    private Double valueDayCar;

    @ColumnInfo(name = "value_day_moto")
    private Double valueDayMoto;

    @ColumnInfo(name = "value_cilindraje_moto")
    private Double valueCilindrajeMoto;

    public Tariff(Double valueHorCar, Double valueHorMoto, Double valueDayCar, Double valueDayMoto, Double valueCilindrajeMoto) {
        this.valueHorCar = valueHorCar;
        this.valueHorMoto = valueHorMoto;
        this.valueDayCar = valueDayCar;
        this.valueDayMoto = valueDayMoto;
    }

    public int getTariffId() {
        return tariffId;
    }

    public void setTariffId(int tariffId) {
        this.tariffId = tariffId;
    }

    public Double getValueHorCar() {
        return valueHorCar;
    }

    public Double getValueHorMoto() {
        return valueHorMoto;
    }

    public Double getValueDayCar() {
        return valueDayCar;
    }

    public Double getValueDayMoto() {
        return valueDayMoto;
    }

    public Double getValueCilindrajeMoto() {
        return valueCilindrajeMoto;
    }

}
