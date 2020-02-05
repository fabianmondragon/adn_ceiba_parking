package com.example.parkingapp.data.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity (tableName = "cilindraje_rules")
public class CilindrajeRules {

    @NotNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "cilindraje_rules_id")
    private int cilindraje_rulesId;

    @ColumnInfo(name = "cilindraje_moto")
    private int cilindraje_moto;

    @ColumnInfo (name = "state")
    private int state;

    public CilindrajeRules(int cilindraje_moto, int state) {
        this.cilindraje_moto = cilindraje_moto;
        this.state = state;
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
