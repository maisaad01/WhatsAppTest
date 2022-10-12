package com.example.whatsapptest.model;

import android.widget.ImageView;
import android.widget.TextView;

public class ChatModel {
    private String userName, Contants, timeChat;
    private int userImage;

    public ChatModel(String userName, String contants,String timeChat, int userImage) {
        this.userName = userName;
        this.Contants = contants;
        this.userImage = userImage;
        this.timeChat= timeChat;

    }

    public String getTimeChat() {
        return timeChat;
    }

    public void setTimeChat(String timeChat) {
        this.timeChat = timeChat;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContants() {
        return Contants;
    }

    public void setContants(String contants) {
        Contants = contants;
    }

    public int getUserImage() {
        return userImage;
    }

    public void setUserImage(int userImage) {
        this.userImage = userImage;
    }
}