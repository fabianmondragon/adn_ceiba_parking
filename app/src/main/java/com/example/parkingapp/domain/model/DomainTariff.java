package com.example.parkingapp.domain.model;



public class DomainTariff {


    private Double valueHorCar;


    private Double valueHorMoto;


    private Double valueDayCar;


    private Double valueDayMoto;


    private Double valueCilindrajeMoto;

    public DomainTariff( Double valueHorCar, Double valueHorMoto, Double valueDayCar, Double valueDayMoto, Double valueCilindrajeMoto) {

        this.valueHorCar = valueHorCar;
        this.valueHorMoto = valueHorMoto;
        this.valueDayCar = valueDayCar;
        this.valueDayMoto = valueDayMoto;
        this.valueCilindrajeMoto = valueCilindrajeMoto;
    }
    public Double getValueHorCar() {
        return valueHorCar;
    }

    public void setValueHorCar(Double valueHorCar) {
        this.valueHorCar = valueHorCar;
    }

    public Double getValueHorMoto() {
        return valueHorMoto;
    }

    public void setValueHorMoto(Double valueHorMoto) {
        this.valueHorMoto = valueHorMoto;
    }

    public Double getValueDayCar() {
        return valueDayCar;
    }

    public void setValueDayCar(Double valueDayCar) {
        this.valueDayCar = valueDayCar;
    }

    public Double getValueDayMoto() {
        return valueDayMoto;
    }

    public void setValueDayMoto(Double valueDayMoto) {
        this.valueDayMoto = valueDayMoto;
    }

    public Double getValueCilindrajeMoto() {
        return valueCilindrajeMoto;
    }

    public void setValueCilindrajeMoto(Double valueCilindrajeMoto) {
        this.valueCilindrajeMoto = valueCilindrajeMoto;
    }
}
