package com.bitsbids.demo.services;

import com.bitsbids.demo.entities.Product;

import java.util.List;
import java.util.Optional;

public interface productService {

    List<Product> getProducts();

    Optional<Product> getProduct(String id);

    Product updateProduct(Product product);

    Product addProduct(Product product);

    void deleteProduct(String id);
}
