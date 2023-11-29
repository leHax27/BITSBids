package com.bitsbids.demo.DBAccess;

import com.bitsbids.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userDAO extends JpaRepository<User, String> {

    // Change the method signature
    void deleteById(String id);
}
