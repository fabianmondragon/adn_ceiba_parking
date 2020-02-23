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
        return !carPlate.equals("");
    }

    public boolean validateMotorcycleFields(String carPlate, String cylindrical) {
        if (carPlate == null || cylindrical == null)
            return false;
        boolean emptyPlate = !carPlate.equals("");
        if (emptyPlate){
            return !cylindrical.equals("");
        }
        return false;
    }
}
