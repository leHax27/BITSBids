package com.bitsbids.demo.DBAccess;

import com.bitsbids.demo.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productDAO extends JpaRepository<Product, String> {
    void deleteById(String id);
}
