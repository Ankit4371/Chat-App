package com.ankit.chatbackend.model;

import lombok.Data;

import lombok.*;

@NoArgsConstructor
@Data
public class Message {
    private String senderName;
    private String receiverName;
    private String message;
    private String date;
    private Status status;
}