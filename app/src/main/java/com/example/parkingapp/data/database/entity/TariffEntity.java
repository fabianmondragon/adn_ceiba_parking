package com.example.parkingapp.data.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TariffEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "tarif_id")
    private int tariffId;

    @ColumnInfo(name = "car_hour_cost")
    private Double carHourCost;

    @ColumnInfo(name = "motorcycle_hour_cost")
    private Double motorcycleHourCost;

    @ColumnInfo(name = "car_day_cost")
    private Double carDayCost;

    @ColumnInfo(name = "motorcycle_day_cost")
    private Double motorcycleDayCost;

    @ColumnInfo(name = "moto_cylindrical_cost")
    private Double motorcycleCilindricalCost;

    public TariffEntity(Double carHourCost, Double motorcycleHourCost, Double carDayCost, Double motorcycleDayCost, Double motorcycleCilindricalCost) {
        this.carHourCost = carHourCost;
        this.motorcycleHourCost = motorcycleHourCost;
        this.carDayCost = carDayCost;
        this.motorcycleDayCost = motorcycleDayCost;
        this.motorcycleCilindricalCost = motorcycleCilindricalCost;
    }

    public int getTariffId() {
        return tariffId;
    }

    public void setTariffId(int tariffId) {
        this.tariffId = tariffId;
    }

    public Double getCarHourCost() {
        return carHourCost;
    }

    public Double getMotorcycleHourCost() {
        return motorcycleHourCost;
    }

    public Double getCarDayCost() {
        return carDayCost;
    }

    public Double getMotorcycleDayCost() {
        return motorcycleDayCost;
    }

    public Double getMotorcycleCilindricalCost() {
        return motorcycleCilindricalCost;
    }

}
