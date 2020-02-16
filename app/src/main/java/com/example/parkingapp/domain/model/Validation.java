package com.example.parkingapp.domain.model;

public class Validation {

    public boolean validateFieldCar(String carPlate) {
        if (carPlate.equals(""))
            return false;
        return true;
    }

    public boolean validateMotorcycleFields(String carPlate, String cilindraje) {
        if (carPlate.equals(""))
            return false;
        if (cilindraje.equals(""))
            return false;
        return true;
    }
}
