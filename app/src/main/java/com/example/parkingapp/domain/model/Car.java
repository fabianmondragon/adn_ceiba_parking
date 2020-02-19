package com.example.parkingapp.domain.model;

public class Car {


    public Car() {
        //Se utiliza para el mapeo de Entity a Dominio
    }

    private String plate;
    private int fkParkingSpace;

    public Car(String plate) {
        this.plate = plate;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getFkParkingSpace() {
        return fkParkingSpace;
    }

    public void setFkParkingSpace(int fkParkingSpace) {
        this.fkParkingSpace = fkParkingSpace;
    }

}
