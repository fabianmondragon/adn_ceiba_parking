package com.example.parkingapp.domain.services;

import com.example.parkingapp.data.repository.CiylindricalRepository;
import com.example.parkingapp.domain.model.CylindricalRules;

import javax.inject.Inject;

public class CylindricalRulesOperations {

    @Inject
    CiylindricalRepository ciylindricalRepository;

    public CylindricalRulesOperations() {
    }

    public CylindricalRules getRules() {
        return ciylindricalRepository.getActiveCilindraje();
    }
}
