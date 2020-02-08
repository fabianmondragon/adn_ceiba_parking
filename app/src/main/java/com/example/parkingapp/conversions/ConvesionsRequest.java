package com.example.parkingapp.conversions;

public class ConvesionsRequest {



    private int state;
    private String  msg;

    public ConvesionsRequest() {
        this.state = -1;
        this.msg = "";
    }
    public ConvesionsRequest (int state, String msg){
        this.state =state;
        this.msg = msg;

    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String  msg) {
        this.msg = msg;
    }
}
