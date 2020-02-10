package com.example.parkingapp.domain;

import com.example.parkingapp.domain.model.DomainCilindrajeRules;
import com.example.parkingapp.domain.model.DomainDetailParking;
import com.example.parkingapp.domain.model.DomainTariff;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DomainBill {

    private DomainDetailParking domainDetailParking;
    private long hours;
    private long days;
    private long cost;

    DomainDetailParking calculateTime(Date dateActual, Date date) {

        long diffInMillies = Math.abs(dateActual.getTime() - date.getTime());
        long minuts = TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS);
        return domainDetailParking = new DomainDetailParking(minuts);
    }

    public Long calculateCost(DomainDetailParking domainDetailParking, DomainTariff domainTariff, DomainCilindrajeRules cilindrajeRules, int cilindraje) {
        long horaAux = 0;
        if (domainDetailParking.getNumberMinuts() > 0) {
            hours = (domainDetailParking.getNumberMinuts() / 60);
            days = (hours / 24);
            hours = hours - (days * 24);
            if (horaAux > 9) {
                days = days + 1;
                hours = 0;
            }
            if (cilindrajeRules != null) {
                if (cilindraje > 650)
                    cost = (long) ((days * domainTariff.getValueDayMoto() + (hours * domainTariff.getValueHorMoto()) + domainTariff.getValueCilindrajeMoto()));
                else
                    cost = (long) ((days * domainTariff.getValueDayMoto() + (hours * domainTariff.getValueHorMoto())));
            } else {
                cost = (long) ((days * domainTariff.getValueDayCar() + (hours * domainTariff.getValueHorCar())));
            }
        }
        return cost;
    }
}
