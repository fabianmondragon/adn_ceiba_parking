package com.example.parkingapp.presentation;

public class ValidationPresentation {

    public boolean validateFieldCar (String carPlate) {
        if (carPlate == null) return false;
        if (carPlate == "") return false;
        return true;
    }

    public boolean validateFieldMotorcycle (String carPlate, String cilindraje) {
        if (carPlate == null) return false;
        if (carPlate == "") return false;
        if (cilindraje == null) return false;
        if (cilindraje == "") return false;

        return true;
    }
}
