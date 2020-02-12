package com.example.parkingapp.domain;

import java.util.Calendar;

public class DomainValidationsParking {

    public boolean isValid(String plateId) {
        int day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        if (plateId.startsWith("A")) {
            if (day == 1 || day == 4) {
                return true;
            }else {
                return false;
            }
        }
        return true;
    }
}
