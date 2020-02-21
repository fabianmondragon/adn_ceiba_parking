package com.example.parkingapp.domain.exceptions;

import com.example.parkingapp.data.database.DataBaseAdministration;

public class ParkingException extends Exception{

    public ParkingException(String message) {
        super(message);
    }

}
