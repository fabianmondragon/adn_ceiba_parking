package com.example.parkingapp.domain.model;

public class DomainDetailParking {
    private long numberMinuts;
    private long cost;

    public DomainDetailParking(  long minuts) {
        this.numberMinuts = minuts;
    }

    public long getNumberMinuts() {
        return numberMinuts;
    }

    public void setNumberMinuts(long numberMinuts) {
        this.numberMinuts = numberMinuts;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }
}
