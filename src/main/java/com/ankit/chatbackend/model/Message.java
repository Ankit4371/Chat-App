package com.ankit.chatbackend.model;

import lombok.Data;

@Data
public class Message {
    private String senderName;
    private String receiverName;
    private String messageData;
    private String date;
    private Status status;
}
