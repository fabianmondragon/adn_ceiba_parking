package com.example.parkingapp.data.repository;

import com.example.parkingapp.BaseApplication;
import com.example.parkingapp.data.database.entity.CilindrajeRulesEntity;
import com.example.parkingapp.domain.model.CylindricalRules;
import com.example.parkingapp.domain.repository.CylindricalRepository;

public class CylindricalImpl implements CylindricalRepository {

    CilindrajeRulesEntity cilindrajeRulesEntity;
    CylindricalRules cilindricalRules;

    public CylindricalRules getActiveCylindrical() {
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        cilindrajeRulesEntity = db.cilindrajeRulesDao().getActivo();
        cilindricalRules = new CylindricalRules(cilindrajeRulesEntity.getCylindricalMotorcycleta());
        return cilindricalRules;
    }
}
