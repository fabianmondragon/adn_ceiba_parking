package com.example.parkingapp.data.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "plate_rule")
public class PlateRulesEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "plate_rules_id")
    int plateRulesId;

    @ColumnInfo(name = "letterPlateRules")
    String letterPlateRules;

    @ColumnInfo(name = "state")
    Boolean state;

    public PlateRulesEntity(String letterPlateRules, Boolean state) {
        this.plateRulesId = plateRulesId;
        this.letterPlateRules = letterPlateRules;
        this.state = state;
    }

    public int getPlateRulesId() {
        return plateRulesId;
    }

    public void setPlateRulesId(int plateRulesId) {
        this.plateRulesId = plateRulesId;
    }

    public String getLetterPlateRules() {
        return letterPlateRules;
    }

    public void setLetterPlateRules(String letterPlateRules) {
        this.letterPlateRules = letterPlateRules;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}
