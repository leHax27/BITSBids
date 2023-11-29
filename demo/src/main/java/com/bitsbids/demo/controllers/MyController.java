package com.bitsbids.demo.controllers;

import com.bitsbids.demo.entities.Message;
import com.bitsbids.demo.entities.Product;
import com.bitsbids.demo.entities.User;
import com.bitsbids.demo.services.MessageService;
import com.bitsbids.demo.services.productService;
import com.bitsbids.demo.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MyController {

    @Autowired
    private userService userService;

    @Autowired
    private productService productService;

    @Autowired
    private MessageService messageService;

    @GetMapping("/home")
    public String home() {
        return "Hello";
    }

    // User-related endpoints

    @GetMapping("/users")
    public List<User> getUsers() {
        return this.userService.getUsers();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUser(@PathVariable String id) {
        return this.userService.getUser(id);
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return this.userService.addUser(user);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User user) {
        // Set the ID of the user based on the path variable
        user.setId(id);

        // Call the update method in the service
        User updatedUser = userService.updateUser(user);

        if (updatedUser != null) {
            // If the update was successful, return the updated user and HTTP status 200 (OK)
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            // If the user with the given ID was not found, return HTTP status 404 (Not Found)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable String id) {
        try {
            this.userService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Product-related endpoints

    @GetMapping("/products")
    public List<Product> getProducts() {
        return this.productService.getProducts();
    }

    @GetMapping("/products/{id}")
    public Optional<Product> getProduct(@PathVariable String id) {
        return this.productService.getProduct(id);
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return this.productService.addProduct(product);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody Product product) {
        // Set the ID of the product based on the path variable
        product.setId(id);

        // Call the update method in the service
        Product updatedProduct = productService.updateProduct(product);

        if (updatedProduct != null) {
            // If the update was successful, return the updated product and HTTP status 200 (OK)
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } else {
            // If the product with the given ID was not found, return HTTP status 404 (Not Found)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable String id) {
        try {
            this.productService.deleteProduct(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/messages")
    public Message sendMessage(@RequestBody Message message) {

        return this.messageService.saveMessage(message);
    }

    @GetMapping("/messages/{recipientId}")
    public List<Message> getMessages(@PathVariable String recipientId) {
        // Retrieve messages for the specified recipient
        return messageService.getMessagesByRecipientId(recipientId);
    }
}
