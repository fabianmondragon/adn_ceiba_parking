package com.example.parkingapp.domain.model;


public class Tariff {

    private Double valueHorCar;
    private Double valueHorMoto;
    private Double valueDayCar;
    private Double valueDayMoto;
    private Double valueCilindrajeMoto;

    public Tariff(Double valueHorCar, Double valueHorMoto, Double valueDayCar, Double valueDayMoto, Double valueCilindrajeMoto) {
        this.valueHorCar = valueHorCar;
        this.valueHorMoto = valueHorMoto;
        this.valueDayCar = valueDayCar;
        this.valueDayMoto = valueDayMoto;
        this.valueCilindrajeMoto = valueCilindrajeMoto;
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
