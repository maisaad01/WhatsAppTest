package com.example.whatsapptest.model;

public class CallModel {
    private String userNameCall , timeCall ;
    private int imageCall;

    public CallModel(String userNameCall, String timeCall, int imageCall) {
        this.userNameCall = userNameCall;
        this.timeCall = timeCall;
        this.imageCall = imageCall;
    }

    public String getUserNameCall() {
        return userNameCall;
    }

    public void setUserNameCall(String userNameCall) {
        this.userNameCall = userNameCall;
    }

    public String getTimeCall() {
        return timeCall;
    }

    public void setTimeCall(String timeCall) {
        this.timeCall = timeCall;
    }

    public int getImageCall() {
        return imageCall;
    }

    public void setImageCall(int imageCall) {
        this.imageCall = imageCall;
    }
}
