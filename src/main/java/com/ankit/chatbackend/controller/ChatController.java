package com.ankit.chatbackend.controller;

import com.ankit.chatbackend.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate; // dynamic topics for private messages 1 : 1 chats


    @MessageMapping("/message") // /app/message
    @SendTo("/chatroom/public") // topic chatroom
    public Message receivePublicMessage(@Payload Message message){
        return message;
    }

    public Message receivePrivateMessage(@Payload Message message){
        simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(),"/private",message); // /user/UserName/private/
        return message;
    }
}
