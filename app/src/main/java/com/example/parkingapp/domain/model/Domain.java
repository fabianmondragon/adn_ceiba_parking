package com.example.parkingapp.domain.model;

public class Domain {
    protected String plate;
    private int type;
    private int cilindraje;
    private int fkSpace;

    public Domain(String plate, int type) {
        this.plate = plate;
        this.type = type;
    }

    public Domain(String plate, int cilindraje, int type) {
        this.plate = plate;
        this.type = type;
        this.cilindraje = cilindraje;
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

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public int getFkSpace() {
        return fkSpace;
    }

    public void setFsetFkSpace(int fk_space) {
        this.fkSpace = fk_space;
    }
}
