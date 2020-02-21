package com.example.parkingapp.domain.model;


public class Tariff {

    private Double carHourCost;
    private Double motorcycleHourCost;
    private Double carDayCost;
    private Double motorcycleDayCost;
    private Double motorcycleCylindrical;

    public Tariff(Double carHourCost, Double motorcycleHourCost, Double carDayCost, Double motorcycleDayCost, Double motorcycleCylindrical) {
        this.carHourCost = carHourCost;
        this.motorcycleHourCost = motorcycleHourCost;
        this.carDayCost = carDayCost;
        this.motorcycleDayCost = motorcycleDayCost;
        this.motorcycleCylindrical = motorcycleCylindrical;
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

    public Double getMotorcycleCylindrical() {
        return motorcycleCylindrical;
    }

    public void setCarHourCost(Double carHourCost) {
        this.carHourCost = carHourCost;
    }

    public void setMotorcycleHourCost(Double motorcycleHourCost) {
        this.motorcycleHourCost = motorcycleHourCost;
    }

    public void setCarDayCost(Double carDayCost) {
        this.carDayCost = carDayCost;
    }

    public void setMotorcycleDayCost(Double motorcycleDayCost) {
        this.motorcycleDayCost = motorcycleDayCost;
    }

    public void setMotorcycleCylindrical(Double motorcycleCylindrical) {
        this.motorcycleCylindrical = motorcycleCylindrical;
    }
}
