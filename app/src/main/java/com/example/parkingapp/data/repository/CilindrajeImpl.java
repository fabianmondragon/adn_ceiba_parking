package com.example.parkingapp.data.repository;

import com.example.parkingapp.BaseApplication;
import com.example.parkingapp.data.database.entity.CilindrajeRulesEntity;

public class CilindrajeImpl implements CilindrajeRepository {

    public CilindrajeRulesEntity getActiveCilindraje() {
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        try {
            return db.cilindrajeRulesDao().getActivo();

        } catch (Exception e) {
            return null;
        }
    }
}
