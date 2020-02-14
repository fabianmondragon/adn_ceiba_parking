package com.example.parkingapp.data.repository;

import com.example.parkingapp.data.database.entity.CilindrajeRulesEntity;
import com.example.parkingapp.data.database.entity.ParkingEntity;
import com.example.parkingapp.data.database.entity.ParkingSpaceEntitiy;
import com.example.parkingapp.data.database.entity.PlateRulesEntity;
import com.example.parkingapp.data.database.entity.TariffEntity;

import java.util.List;

public interface ManagmentDataBaseRepository {
    void fillDataBase(final ParkingEntity parkingEntity, final List<ParkingSpaceEntitiy> parkingSpaceEntitiyList, final CilindrajeRulesEntity cilindrajeRulesEntity, final TariffEntity tariffEntity, final PlateRulesEntity plateRulesEntity);

    void freeUpSpace() ;
}
