package com.example.parkingapp.domain.services;

import com.example.parkingapp.data.repository.CiylindricalImpl;
import com.example.parkingapp.data.repository.CiylindricalRepository;
import com.example.parkingapp.domain.model.CylindricalRules;

public class CylindricalRulesOperations {

    CiylindricalRepository ciylindricalRepository;

    public CylindricalRulesOperations() {
        this.ciylindricalRepository = new CiylindricalImpl();
    }

    public CylindricalRules getRules() {
        return ciylindricalRepository.getActiveCilindraje();
    }
}
