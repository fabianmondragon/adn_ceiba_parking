package com.example.parkingapp.data;

import com.example.parkingapp.BaseApplication;
import com.example.parkingapp.data.database.CilindrajeRules;

public class CilindrajeRepository {

    public CilindrajeRules getActiveCilindraje() {
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        try {
            return db.cilindrajeRulesDao().getActivo();

        } catch (Exception e) {
            return null;
        }
    }
}
