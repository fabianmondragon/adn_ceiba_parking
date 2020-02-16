package com.example.parkingapp.domain.services;

import com.example.parkingapp.data.repository.CilindrajeImpl;
import com.example.parkingapp.data.repository.CilindrajeRepository;
import com.example.parkingapp.domain.model.CylindricalRules;

public class CilindrajeRulesOperations {

    CilindrajeRepository cilindrajeRepository;

    public CilindrajeRulesOperations() {
        this.cilindrajeRepository = new CilindrajeImpl();
    }

    public CylindricalRules getRules() {
        return cilindrajeRepository.getActiveCilindraje();
    }
}
