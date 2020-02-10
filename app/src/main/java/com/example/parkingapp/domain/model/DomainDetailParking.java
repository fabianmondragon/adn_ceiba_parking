package com.example.parkingapp.domain.model;

public class DomainDetailParking {
    private long numberMinuts;
    private long cost;

    public DomainDetailParking(long minuts) {
        this.numberMinuts = minuts;
    }

    public long getNumberMinuts() {
        return numberMinuts;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }
}
