package com.example.parkingapp.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConstantTest {

    @Test
    public void verifyConstat_MsgTransaction(){
        assertTrue(Constant.REGISTER_SUCCESSFULL.equals("Registro exitoso"));
        assertTrue(Constant.REGISTER_UNSUCCEFULL.equals("Ocurrio un problema, intente nuevamente"));
        assertTrue(Constant.COSTO_TOTAL.equals("Su costo total es de: "));
        assertTrue(Constant.INCOMPLETED_INFORMATION.equals("Información incompleta"));
    }

    @Test
    public void verifyConstat_TypeTransaction(){
        assertTrue(Constant.SET_CAR==1);
        assertTrue(Constant.SET_MOTORCYCLE == 2);
        assertTrue(Constant.SET_COST == 3);
        assertTrue(Constant.SET_MOTORCYCLE_NO_AUTORIZED == 4);
    }

}