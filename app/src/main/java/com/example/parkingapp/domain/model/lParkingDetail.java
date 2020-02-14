package com.example.parkingapp.domain.model;

public class lParkingDetail {
    private long numberMinuts;
    private long cost;

    public lParkingDetail(long minuts) {
        this.numberMinuts = minuts;
    }

    public long getNumberMinuts() {
        return numberMinuts;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public long getCost() {
        return cost;
    }
}
