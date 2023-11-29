package com.bitsbids.demo.DBAccess;

import com.bitsbids.demo.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface messageDAO extends JpaRepository<Message, String> {

    List<Message> findByRecipientOrderByCreatedAtDesc(String recipient);
}
