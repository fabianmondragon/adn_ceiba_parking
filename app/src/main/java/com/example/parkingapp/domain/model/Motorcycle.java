package com.example.parkingapp.domain.model;

public class Motorcycle {

    private String plate;
    private int cylindrical;
    private int fkParkingSpace;

    public Motorcycle(String plate, int cylindrical, int fkParkingSpace) {
        this.plate = plate;
        this.cylindrical = cylindrical;
        this.fkParkingSpace = fkParkingSpace;
    }

    public Motorcycle(String plate, int cylindrical) {
        this.plate = plate;
        this.cylindrical = cylindrical;
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

    public int getCylindrical() {
        return cylindrical;
    }

    public void setCylindrical(int cylindrical) {
        this.cylindrical = cylindrical;
    }

    public int getFkParkingSpace() {
        return fkParkingSpace;
    }

    public void setFkParkingSpace(int fkParkingSpace) {
        this.fkParkingSpace = fkParkingSpace;
    }
}
