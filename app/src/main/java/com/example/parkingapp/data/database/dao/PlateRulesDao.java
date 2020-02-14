package com.example.parkingapp.data.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.parkingapp.data.database.entity.PlateRulesEntity;

import java.util.List;

@Dao
public interface PlateRulesDao {

    @Query("SELECT * FROM PlateRulesEntity WHERE PlateRulesEntity.state = 1")
    List<PlateRulesEntity> getPlateRuleActive();

    @Insert
    void insetPlateRulse(PlateRulesEntity plateRulesEntity);
}
