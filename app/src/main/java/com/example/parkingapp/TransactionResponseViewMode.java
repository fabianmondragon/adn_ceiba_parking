package com.example.parkingapp;

public class TransactionResponseViewMode {

    private boolean state;
    private  int transactionId;
    private String msg;

    public TransactionResponseViewMode(boolean state, int transactionId, String msg) {
        this.state = state;
        this.transactionId = transactionId;
        this.msg = msg;
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
}
