package com.example.parkingapp.data.repository;

import com.example.parkingapp.BaseApplication;
import com.example.parkingapp.data.database.entity.CilindrajeRulesEntity;
import com.example.parkingapp.domain.model.CylindricalRules;

public class CilindrajeImpl implements CilindrajeRepository {

    CilindrajeRulesEntity cilindrajeRulesEntity;
    CylindricalRules cilindricalRules;

    public CylindricalRules getActiveCilindraje() {
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        try {
            cilindrajeRulesEntity =  db.cilindrajeRulesDao().getActivo();
            cilindricalRules = new CylindricalRules (cilindrajeRulesEntity.getCylindricalMotorcycleta());
           return  cilindricalRules;
        } catch (Exception e) {
            return null;
        }
    }
}
