package com.example.parkingapp.data.repository;

import com.example.parkingapp.data.database.entity.CilindrajeRulesEntity;
import com.example.parkingapp.domain.model.CylindricalRules;

public interface CilindrajeRepository {
    CylindricalRules getActiveCilindraje();
}
