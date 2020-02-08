package com.example.parkingapp.domain.model;

public class DomainMotorcycle extends DomainVehicle {

    private int cilindraje;


    public DomainMotorcycle(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public DomainMotorcycle(String plate, int type, int cilindraje) {
        super(plate, type, cilindraje);
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }
}
