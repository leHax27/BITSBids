package com.bitsbids.demo.services;

import com.bitsbids.demo.DBAccess.messageDAO;
import com.bitsbids.demo.entities.Message;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private messageDAO messageDao;

    @Autowired
    private userService userService;

    @Autowired
    private userServiceImpl userServiceImpl;

    @Override
    public List<Message> getMessagesByRecipient(String recipient) {
        return null;
    }



    @Transactional
    @Override
    public Message saveMessage(Message message) {
        message.setCreatedAt(LocalDateTime.now());
        messageDao.save(message);
        return message;
    }




    @Override
    public List<Message> getMessagesByRecipientId(String recipientId) {
        return messageDao.findByRecipientOrderByCreatedAtDesc(recipientId);
    }
}
