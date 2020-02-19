package com.example.parkingapp.data.repository;

import com.example.parkingapp.BaseApplication;
import com.example.parkingapp.data.database.entity.CilindrajeRulesEntity;
import com.example.parkingapp.domain.interfaces_repository.CiylindricalRepository;
import com.example.parkingapp.domain.model.CylindricalRules;

public class CiylindricalImpl implements CiylindricalRepository {

    CilindrajeRulesEntity cilindrajeRulesEntity;
    CylindricalRules cilindricalRules;

    public CylindricalRules getActiveCilindraje() {
        final CeibaDataBase db = CeibaDataBase.getDatabase(BaseApplication.getAppContext());
        cilindrajeRulesEntity = db.cilindrajeRulesDao().getActivo();
        cilindricalRules = new CylindricalRules(cilindrajeRulesEntity.getCylindricalMotorcycleta());
        return cilindricalRules;
    }
}
