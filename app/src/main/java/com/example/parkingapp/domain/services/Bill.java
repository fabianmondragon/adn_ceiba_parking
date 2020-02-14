package com.example.parkingapp.domain.services;

import com.example.parkingapp.domain.model.CylindricalRules;
import com.example.parkingapp.domain.model.lParkingDetail;
import com.example.parkingapp.domain.model.Tariff;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Bill {

    private lParkingDetail lParkingDetail;
    private long hours;
    private long days;
    private long cost;

    lParkingDetail calculateTime(Date dateActual, Date date) {

        long diffInMillies = Math.abs(dateActual.getTime() - date.getTime());
        long minuts = TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS);
        return lParkingDetail = new lParkingDetail(minuts);
    }

    public Long calculateCost(lParkingDetail lParkingDetail, Tariff tariff, CylindricalRules cilindrajeRules, int cilindraje) {
        long horaAux = 0;
        if (lParkingDetail.getNumberMinuts() > 0) {
            hours = (lParkingDetail.getNumberMinuts() / 60);
            days = (hours / 24);
            hours = hours - (days * 24);
            if (horaAux > 9) {
                days = days + 1;
                hours = 0;
            }
            if (cilindrajeRules != null) {
                if (cilindraje > 650)
                    cost = (long) ((days * tariff.getValueDayMoto() + (hours * tariff.getValueHorMoto()) + tariff.getValueCilindrajeMoto()));
                else
                    cost = (long) ((days * tariff.getValueDayMoto() + (hours * tariff.getValueHorMoto())));
            } else {
                cost = (long) ((days * tariff.getValueDayCar() + (hours * tariff.getValueHorCar())));
            }
        }
        return cost;
    }
}
