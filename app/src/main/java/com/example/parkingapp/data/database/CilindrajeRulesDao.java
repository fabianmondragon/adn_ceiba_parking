package com.example.parkingapp.data.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface CilindrajeRulesDao {

    @Query("SELECT * FROM cilindraje_rules")
    List<CilindrajeRules> getAll();

    @Insert
    void insertCilindrajeRules(CilindrajeRules cilindrajeRules);

    @Query("SELECT * FROM cilindraje_rules WHERE cilindraje_rules.state = 1")
    CilindrajeRules getActivo();

}
