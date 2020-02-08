package com.example.parkingapp.presentation;

public class MotorcyclePresentation {

    private String plate;
    private int cilindraje;

    public MotorcyclePresentation(String plate, int cilindraje) {
        this.plate = plate;
        this.cilindraje = cilindraje;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }
}
