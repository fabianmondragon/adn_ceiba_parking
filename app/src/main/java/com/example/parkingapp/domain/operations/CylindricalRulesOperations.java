package com.example.parkingapp.domain.operations;

import com.example.parkingapp.BaseApplication;
import com.example.parkingapp.domain.repository.CylindricalRepository;
import com.example.parkingapp.domain.model.CylindricalRules;

import javax.inject.Inject;

public class CylindricalRulesOperations {

    @Inject
    CylindricalRepository cylindricalRepository;

    public CylindricalRulesOperations() {
        ((BaseApplication)(BaseApplication.getAppContext().getApplicationContext())).getAppComponent().inject(this);
    }

    public CylindricalRules getRules() {
        return cylindricalRepository.getActiveCylindrical();
    }
}
