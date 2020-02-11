package com.example.parkingapp.presentation;

public class ValidationPresentation {

    public boolean validateFieldCar (String carPlate) {
        if (carPlate == null || carPlate.equals(""))
            return false;
        return true;
    }

    public boolean validateFieldMotorcycle (String carPlate, String cilindraje) {
        if (carPlate == null || carPlate.equals(""))
            return false;
        if (cilindraje == null || cilindraje.equals(""))
            return false;
        return true;
    }
}
