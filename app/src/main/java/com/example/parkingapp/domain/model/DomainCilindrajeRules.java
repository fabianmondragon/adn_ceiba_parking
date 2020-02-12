package com.example.parkingapp.domain.model;

public class DomainCilindrajeRules {

    private int cilindraje_moto;
    private int state;

    public DomainCilindrajeRules(int cilindraje_moto, int state) {
        this.cilindraje_moto = cilindraje_moto;
        this.state = state;
    }

    public DomainCilindrajeRules(int cilindraje_moto) {
        this.cilindraje_moto = cilindraje_moto;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getCilindrage() {
        return cilindraje_moto;
    }

}
