package com.bitsbids.demo.services;

import com.bitsbids.demo.entities.Message;

import java.util.List;

public interface MessageService {

    List<Message> getMessagesByRecipient(String recipient);



    Message saveMessage(Message message);


    List<Message> getMessagesByRecipientId(String recipientId);
}
