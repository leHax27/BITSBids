package com.bitsbids.demo.services;

import com.bitsbids.demo.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface userService {

    List<User> getUsers();

    Optional<User> getUser(String id);

    User updateUser(User user);

    User addUser(User user);


    void deleteUser(String id);
}
