package com.example.EcommerceWebsite.service;

import com.example.EcommerceWebsite.model.Product;
import com.example.EcommerceWebsite.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}
