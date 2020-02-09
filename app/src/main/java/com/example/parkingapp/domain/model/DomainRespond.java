package com.example.parkingapp.domain.model;

public class DomainRespond {

    private String msg;
    private boolean state;
    private int tipeTransaction;

    public int getTipeTransaction() {
        return tipeTransaction;
    }

    public void setTipeTransaction(int tipeTransaction) {
        this.tipeTransaction = tipeTransaction;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
