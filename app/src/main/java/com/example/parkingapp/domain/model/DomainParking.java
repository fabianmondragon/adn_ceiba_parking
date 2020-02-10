package com.example.parkingapp.domain.model;

public class DomainParking {

    private int numCars;
    private int numMotorcycle;

    public DomainParking(int numCars, int numMotorcycle) {
        this.numCars = numCars;
        this.numMotorcycle = numMotorcycle;
    }

    public int getNumCars() {
        return numCars;
    }

    public int getNumMotorcycle() {
        return numMotorcycle;
    }

}
