package com.example.parkingapp.domain.services;

import android.content.Context;

import com.example.parkingapp.BaseApplication;
import com.example.parkingapp.domain.model.CylindricalRules;
import com.example.parkingapp.domain.model.Tariff;
import com.example.parkingapp.util.Constant;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

public class BillOperations {

    @Inject
    CylindricalRulesOperations cylindricalRulesOperations;
    @Inject
    TariffOperations tariffOperations;

    CylindricalRules cylindricalRules;
    Tariff tariff;
    private long hours;
    private long days;
    private long cost;

    @Inject
    public BillOperations() {
        ((BaseApplication)(BaseApplication.getAppContext().getApplicationContext())).getAppComponent().inject(this);
    }

    long calculateTime(Date dateActual, Date date) {
        long diffInMillies = Math.abs(dateActual.getTime() - date.getTime());
        long minuts = TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS);
        return minuts;
    }

    public Long calculateCost(Long numberMinuts, int cilindraje, int type) {
        long horaAux = 0;
        cylindricalRules = cylindricalRulesOperations.getRules();
        tariff = tariffOperations.getTariff();

        if (numberMinuts > 0) {
            hours = (numberMinuts / 60);
            days = (hours / 24);
            hours = hours - (days * 24);
            if (horaAux > 9) {
                days = days + 1;
                hours = 0;
            }
            if (type == Constant.IS_A_MOTO) {
                if (cilindraje > 650)
                    cost = (long) ((days * tariff.getMotorcycleDayCost() + (hours * tariff.getMotorcycleHourCost()) + tariff.getMotorcycleCylindrical()));
                else
                    cost = (long) ((days * tariff.getMotorcycleDayCost() + (hours * tariff.getMotorcycleHourCost())));
            } else {
                cost = (long) ((days * tariff.getCarDayCost() + (hours * tariff.getCarHourCost())));
            }
        }
        return cost;
    }
}
