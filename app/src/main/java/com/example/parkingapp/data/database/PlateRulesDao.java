package com.example.parkingapp.data.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PlateRulesDao {

    @Query("SELECT * FROM plate_rule WHERE plate_rule.state = 1")
    List<PlateRules> getPlateRuleActive();

    @Insert
    void insetPlateRulse(PlateRules plateRules);
}
