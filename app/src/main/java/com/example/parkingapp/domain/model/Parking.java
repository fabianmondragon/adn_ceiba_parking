package com.example.parkingapp.domain.model;

public class Parking {

    private int numbersCars;
    private int numbersMotorcycle;

    public Parking(int numbersCars, int numbersMotorcycle) {
        this.numbersCars = numbersCars;
        this.numbersMotorcycle = numbersMotorcycle;
    }

    public int getNumbersCars() {
        return numbersCars;
    }

    public int getNumbersMotorcycle() {
        return numbersMotorcycle;
    }

}
