package com.example.parkingapp;

import org.junit.Test;

import static org.junit.Assert.*;

public class TransactionResponseTest {

    @Test
    public void ConstructTransactionRepsonse_THreeParams_Success (){
        TransactionResponse transactionResponse = new TransactionResponse(true, 1, "Success");
        assertEquals(transactionResponse.getMsg(), "Success");
        assertEquals(transactionResponse.isState(), true);
        assertEquals(transactionResponse.getTransactionId(), 1);
    }


    @Test
    public void ConstructTransactionRepsonse_FourtParams_Success (){
        TransactionResponse transactionResponse = new TransactionResponse(true, 1, "Success", 1000);
        assertEquals(transactionResponse.getMsg(), "Success");
        assertEquals(transactionResponse.isState(), true);
        assertEquals(transactionResponse.getTransactionId(), 1);
        assertEquals(transactionResponse.getCost(), 1000);

    }


}