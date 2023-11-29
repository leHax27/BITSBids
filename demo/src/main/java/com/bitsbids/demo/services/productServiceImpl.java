package com.bitsbids.demo.services;

import com.bitsbids.demo.DBAccess.productDAO;
import com.bitsbids.demo.DBAccess.userDAO;
import com.bitsbids.demo.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class productServiceImpl implements productService {

    @Autowired
    private productDAO productDao;

    @Override
    public List<Product> getProducts() {
        return productDao.findAll();
    }

    @Override
    public Optional<Product> getProduct(String id) {
        return productDao.findById(id);
    }

    @Override
    public Product updateProduct(Product product) {
        Optional<Product> existingProduct = productDao.findById(product.getId());

        if (existingProduct.isPresent()) {
            Product updatedProduct = existingProduct.get();
            updatedProduct.setName(product.getName());
            updatedProduct.setDescription(product.getDescription());
            updatedProduct.setBidPrice(product.getBidPrice());
            updatedProduct.setBasePrice(product.getBasePrice());
            updatedProduct.setImageKey(product.getImageKey());

            productDao.save(updatedProduct);
            return updatedProduct;
        } else {
            return null;
        }
    }

    @Override
    public Product addProduct(Product product) {
        productDao.save(product);
        return product;
    }

    @Override
    public void deleteProduct(String id) {
        productDao.deleteById(id);
    }
}
