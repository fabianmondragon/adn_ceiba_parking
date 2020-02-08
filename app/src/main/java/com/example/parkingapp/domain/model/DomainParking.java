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

    public void setNumCars(int numCars) {
        this.numCars = numCars;
    }

    public int getNumMotorcycle() {
        return numMotorcycle;
    }

    public void setNumMotorcycle(int numMotorcycle) {
        this.numMotorcycle = numMotorcycle;
    }
}
