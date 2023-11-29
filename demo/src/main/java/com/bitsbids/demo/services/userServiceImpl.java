package com.bitsbids.demo.services;

import com.bitsbids.demo.DBAccess.userDAO;
import com.bitsbids.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class userServiceImpl implements userService {

    @Autowired
    private userDAO userDao;

    @Override
    public List<User> getUsers() {
        System.out.println("Impl invoked");
        return userDao.findAll();
    }

    @Override
    public Optional<User> getUser(String id) {
        return userDao.findById(id);
    }

    @Override
    public User updateUser(User user) {
        // Check if the user with the given ID exists
        Optional<User> existingUser = userDao.findById(user.getId());

        if (existingUser.isPresent()) {
            // Update the existing user with the new data
            User updatedUser = existingUser.get();
            updatedUser.setUsername(user.getUsername());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setPhone(user.getPhone());
            updatedUser.setPassword(user.getPassword());
            updatedUser.setWallet_amt(user.getWallet_amt());
            updatedUser.setMoney(user.getMoney());

            // Save the updated user
            userDao.save(updatedUser);

            return updatedUser;
        } else {
            // If the user with the given ID is not found, you may handle this case accordingly
            // For now, just return null
            return null;
        }
    }

    @Override
    public User addUser(User user) {
        userDao.save(user);
        return user;
    }

    @Override
    public void deleteUser(String id) {
        userDao.deleteById(id);
    }
}
