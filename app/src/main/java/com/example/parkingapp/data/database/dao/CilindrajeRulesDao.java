package com.example.parkingapp.data.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.parkingapp.data.database.entity.CilindrajeRulesEntity;

import java.util.List;

@Dao
public interface CilindrajeRulesDao {

    @Query("SELECT * FROM cilindraje_rules")
    List<CilindrajeRulesEntity> getAll();

    @Insert
    void insertCilindrajeRules(CilindrajeRulesEntity cilindrajeRulesEntity);

    @Query("SELECT * FROM cilindraje_rules WHERE cilindraje_rules.state = 1")
    CilindrajeRulesEntity getActivo();

}
