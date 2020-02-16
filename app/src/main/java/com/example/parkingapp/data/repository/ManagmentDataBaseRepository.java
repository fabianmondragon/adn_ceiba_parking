package com.example.parkingapp.data.repository;

import com.example.parkingapp.data.database.entity.CilindrajeRulesEntity;
import com.example.parkingapp.data.database.entity.ParkingEntity;
import com.example.parkingapp.data.database.entity.ParkingSpaceEntitiy;
import com.example.parkingapp.data.database.entity.PlateRulesEntity;
import com.example.parkingapp.data.database.entity.TariffEntity;
import com.example.parkingapp.domain.model.Response;

import java.util.List;

public interface ManagmentDataBaseRepository {
    Response fillDataBase(final ParkingEntity parkingEntity, final List<ParkingSpaceEntitiy> parkingSpaceEntitiyList, final CilindrajeRulesEntity cilindrajeRulesEntity, final TariffEntity tariffEntity, final PlateRulesEntity plateRulesEntity);

    void freeUpSpace();
}
