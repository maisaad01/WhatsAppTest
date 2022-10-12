package com.example.whatsapptest.model;

public class StatusModel {
    private String userNameStatus , timeStatus ;
    private int imageStatus;

    public StatusModel(String userNameStatus, String timeStatus, int imageStatus) {
        this.userNameStatus = userNameStatus;
        this.timeStatus = timeStatus;
        this.imageStatus = imageStatus;
    }

    public String getUserNameStatus() {
        return userNameStatus;
    }

    public void setUserNameStatus(String userNameStatus) {
        this.userNameStatus = userNameStatus;
    }

    public String getTimeStatus() {
        return timeStatus;
    }

    public void setTimeStatus(String timeStatus) {
        this.timeStatus = timeStatus;
    }

    public int getImageStatus() {
        return imageStatus;
    }

    public void setImageStatus(int imageStatus) {
        this.imageStatus = imageStatus;
    }
}
