package com.example.parkingapp.data.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "cilindraje_rules")
public class CilindrajeRulesEntity {

    @NotNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "cilindraje_rules_id")
    private int cylindricalRulesId;

    @ColumnInfo(name = "cylindricalMotorcycleta")
    private int cylindricalMotorcycleta;

    @ColumnInfo(name = "state")
    private int state;

    public CilindrajeRulesEntity(int cylindricalMotorcycleta, int state) {
        this.cylindricalMotorcycleta = cylindricalMotorcycleta;
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getCylindricalRulesId() {
        return cylindricalRulesId;
    }

    public void setCylindricalRulesId(int cylindricalRulesId) {
        this.cylindricalRulesId = cylindricalRulesId;
    }

    public int getCylindricalMotorcycleta() {
        return cylindricalMotorcycleta;
    }

    public void setCylindricalMotorcycleta(int cylindricalMotorcycleta) {
        this.cylindricalMotorcycleta = cylindricalMotorcycleta;
    }
}
