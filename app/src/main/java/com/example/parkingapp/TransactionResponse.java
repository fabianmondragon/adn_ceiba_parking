package com.example.parkingapp;

public class TransactionResponse {

    private boolean state;
    private int transactionId;
    private String message;
    private long cost;

    public TransactionResponse(boolean state, int transactionId, String message) {
        this.state = state;
        this.transactionId = transactionId;
        this.message = message;
    }

    public TransactionResponse(boolean state, int transactionId, String message, long cost) {
        this.state = state;
        this.transactionId = transactionId;
        this.message = message;
        this.cost = cost;
    }

    public boolean isState() {
        return state;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public String getMessage() {
        return message;
    }

    public long getCost() {
        return cost;
    }
}