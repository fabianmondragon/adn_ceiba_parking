package com.example.parkingapp.data.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "plate_rule")
public class PlateRules {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo (name = "plate_rules_id")
    int plateRulesId;

    @ColumnInfo (name = "letter_plate_rule")
    String letter_plate_rule;

    @ColumnInfo (name ="state")
    Boolean state;

    public PlateRules( String letter_plate_rule, Boolean state) {
        this.plateRulesId = plateRulesId;
        this.letter_plate_rule = letter_plate_rule;
        this.state = state;
    }

    public int getPlateRulesId() {
        return plateRulesId;
    }

    public void setPlateRulesId(int plateRulesId) {
        this.plateRulesId = plateRulesId;
    }

    public String getLetter_plate_rule() {
        return letter_plate_rule;
    }

    public void setLetter_plate_rule(String letter_plate_rule) {
        this.letter_plate_rule = letter_plate_rule;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}
