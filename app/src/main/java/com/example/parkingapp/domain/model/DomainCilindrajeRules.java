package com.example.parkingapp.domain.model;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

public class DomainCilindrajeRules {

    private int cilindraje_rulesId;

    private int cilindraje_moto;

    private int state;

    public DomainCilindrajeRules(int cilindraje_moto, int state) {
        this.cilindraje_moto = cilindraje_moto;
        this.state = state;
    }
    public DomainCilindrajeRules (int cilindraje_moto){
        this.cilindraje_moto = cilindraje_moto;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getCilindraje_rulesId() {
        return cilindraje_rulesId;
    }

    public void setCilindraje_rulesId(int cilindraje_rulesId) {
        this.cilindraje_rulesId = cilindraje_rulesId;
    }

    public int getCilindraje_moto() {
        return cilindraje_moto;
    }

    public void setCilindraje_moto(int cilindraje_moto) {
        this.cilindraje_moto = cilindraje_moto;
    }
}
