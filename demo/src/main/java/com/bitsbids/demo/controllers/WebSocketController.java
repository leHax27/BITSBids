package com.bitsbids.demo.controllers;

import com.bitsbids.demo.entities.Message;
import com.bitsbids.demo.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class WebSocketController {

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @Autowired
    private MessageService messageService;

    @MessageMapping("/chat.sendMessage")
    public void sendMessage(@Payload Message message, Principal principal) {
        // Set the sender based on the authenticated user
        message.setSender(principal.getName());

        // Save the message to the database
        messageService.saveMessage(message);

        // Send the message to the destination
        messagingTemplate.convertAndSendToUser(
                message.getRecipient(), "/queue/private", message);
    }

    @MessageMapping("/chat.addUser")
    public void addUser(@Payload Message message, Principal principal) {
        // Store the user in the session
        messagingTemplate.convertAndSendToUser(
                message.getRecipient(), "/queue/private", message);
    }
}
