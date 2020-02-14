package com.example.parkingapp.domain.model;

public class Motorcycle {

    private String plate;
    private int cilindraje;

    public Motorcycle(String plate, int cilindraje) {
        this.plate = plate;
        this.cilindraje = cilindraje;
    }

    public Motorcycle(String plate) {
        this.plate = plate;
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
