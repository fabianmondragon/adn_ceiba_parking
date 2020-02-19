package com.example.parkingapp.domain.operations;

import com.example.parkingapp.BaseApplication;
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

    @Inject
    public BillOperations() {
        ((BaseApplication)(BaseApplication.getAppContext().getApplicationContext())).getAppComponent().inject(this);
    }

    public long calculateTime(Date dateActual, Date date) {
        long diffInMillies = Math.abs(dateActual.getTime() - date.getTime());
        return TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }

    public Long calculateCost(Long numberMinuts, int cilindraje, int type) {
        long horaAux = 0;
        long hours;
        long cost=0;
        long days;
        Tariff tariff = tariffOperations.getTariff();
        if (numberMinuts > 0) {
            hours = (numberMinuts / 60);
            days = (hours / 24);
            hours = hours - (days * 24);
            if (horaAux > 9) {
                days = days + 1;
                hours = 0;
            }
            if (type == Constant.IS_A_MOTORCYCLE) {
                if (cilindraje > 650)

                    cost = (long) ((days * tariff.getMotorcycleDayCost()) + (hours * tariff.getMotorcycleHourCost()) + tariff.getMotorcycleCylindrical());
                else
                    cost = (long) ((days * tariff.getMotorcycleDayCost()) + (hours * tariff.getMotorcycleHourCost()));
            } else {
                cost = (long) ((days * tariff.getCarDayCost()) + (hours * tariff.getCarHourCost()));
            }
        }
        return cost;
    }
}
