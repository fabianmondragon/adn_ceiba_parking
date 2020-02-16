package com.example.parkingapp.domain.model;

public class Motorcycle {

    private String plate;
    private int cilindraje;
    private int fkParkingSpace;

    public Motorcycle(String plate, int cilindraje, int fkParkingSpace) {
        this.plate = plate;
        this.cilindraje = cilindraje;
        this.fkParkingSpace = fkParkingSpace;
    }

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

    public int getFkParkingSpace() {
        return fkParkingSpace;
    }

    public void setFkParkingSpace(int fkParkingSpace) {
        this.fkParkingSpace = fkParkingSpace;
    }
}
