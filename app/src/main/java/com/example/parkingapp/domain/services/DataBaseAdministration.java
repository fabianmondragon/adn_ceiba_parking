package com.example.parkingapp.domain.services;

import com.example.parkingapp.data.database.entity.CilindrajeRulesEntity;
import com.example.parkingapp.data.database.entity.ParkingEntity;
import com.example.parkingapp.data.database.entity.ParkingSpaceEntitiy;
import com.example.parkingapp.data.database.entity.PlateRulesEntity;
import com.example.parkingapp.data.database.entity.TariffEntity;
import com.example.parkingapp.data.repository.ManagmentDataBaseRepository;
import com.example.parkingapp.domain.model.Response;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class DataBaseAdministration {

    @Inject
    private ManagmentDataBaseRepository managmentDataBaseRepository;

    @Inject
    public DataBaseAdministration() {

    }

    public Response fillDataBase() {
        final ParkingEntity parkingEntity = new ParkingEntity(20, 10);
        final CilindrajeRulesEntity cilindrajeRulesEntity = new CilindrajeRulesEntity(150, 1);
        final List<ParkingSpaceEntitiy> parkingSpaceEntitiyList = new ArrayList() {{
            add(new ParkingSpaceEntitiy(false, null, 0));
            add(new ParkingSpaceEntitiy(false, null, 0));
            add(new ParkingSpaceEntitiy(false, null, 0));
            add(new ParkingSpaceEntitiy(false, null, 0));
            add(new ParkingSpaceEntitiy(false, null, 0));
            add(new ParkingSpaceEntitiy(false, null, 0));
            add(new ParkingSpaceEntitiy(false, null, 0));
            add(new ParkingSpaceEntitiy(false, null, 0));
            add(new ParkingSpaceEntitiy(false, null, 0));
            add(new ParkingSpaceEntitiy(false, null, 0));
            add(new ParkingSpaceEntitiy(false, null, 0));
            add(new ParkingSpaceEntitiy(false, null, 0));
            add(new ParkingSpaceEntitiy(false, null, 0));
            add(new ParkingSpaceEntitiy(false, null, 0));
            add(new ParkingSpaceEntitiy(false, null, 0));
            add(new ParkingSpaceEntitiy(false, null, 0));
            add(new ParkingSpaceEntitiy(false, null, 0));
            add(new ParkingSpaceEntitiy(false, null, 0));
            add(new ParkingSpaceEntitiy(false, null, 0));
            add(new ParkingSpaceEntitiy(false, null, 0));
            add(new ParkingSpaceEntitiy(false, null, 0));
            add(new ParkingSpaceEntitiy(false, null, 0));
            add(new ParkingSpaceEntitiy(false, null, 0));
            add(new ParkingSpaceEntitiy(false, null, 0));
            add(new ParkingSpaceEntitiy(false, null, 0));
            add(new ParkingSpaceEntitiy(false, null, 0));
            add(new ParkingSpaceEntitiy(false, null, 0));
            add(new ParkingSpaceEntitiy(false, null, 0));
            add(new ParkingSpaceEntitiy(false, null, 0));
            add(new ParkingSpaceEntitiy(false, null, 0));
        }};

        final TariffEntity tariffEntity = new TariffEntity(1000.0, 500.0, 8000.0, 4000.0, 2000.0);
        final PlateRulesEntity plateRulesEntity = new PlateRulesEntity("b", true);
        return managmentDataBaseRepository.fillDataBase(parkingEntity, parkingSpaceEntitiyList, cilindrajeRulesEntity, tariffEntity, plateRulesEntity);

    }


    public void freeUpDataBaseSpace() {
        managmentDataBaseRepository.freeUpSpace();
    }
}
