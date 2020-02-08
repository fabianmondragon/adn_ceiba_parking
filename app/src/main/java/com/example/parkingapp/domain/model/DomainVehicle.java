package com.example.parkingapp.domain.model;

public class DomainVehicle {
    protected String plate;
    private int type;
    private int cilindraje;

    public DomainVehicle() {
    }

    public DomainVehicle(String plate, int type) {
        this.plate = plate;
        this.type = type;
    }

    public DomainVehicle(String plate, int cilindraje, int type) {
        this.plate = plate;
        this.type = type;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }
}
