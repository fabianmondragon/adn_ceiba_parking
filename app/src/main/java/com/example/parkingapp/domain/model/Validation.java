package com.example.parkingapp.domain.model;

import javax.inject.Inject;

public class Validation {

    @Inject
    public Validation() {
        //Solo se utilizar para Dagger
    }

    public boolean validateFieldCar(String carPlate) {
        if (carPlate == null)
            return false;
        if (carPlate.equals(""))
            return false;
        return true;
    }

    public boolean validateMotorcycleFields(String carPlate, String cilindraje) {
        if (carPlate == null || cilindraje == null)
            return false;
        if (carPlate.equals(""))
            return false;
        if (cilindraje.equals(""))
            return false;
        return true;
    }
}
