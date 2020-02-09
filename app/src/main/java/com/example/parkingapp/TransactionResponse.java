package com.example.parkingapp;

public class TransactionResponse {



    private boolean state;
    private  int transactionId;
    private String msg;
    private long cost;

    public TransactionResponse(boolean state, int transactionId, String msg) {
        this.state = state;
        this.transactionId = transactionId;
        this.msg = msg;
    }

    public TransactionResponse(boolean state, int transactionId, String msg, long cost) {
        this.state = state;
        this.transactionId = transactionId;
        this.msg = msg;
        this.cost = cost;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }
}
