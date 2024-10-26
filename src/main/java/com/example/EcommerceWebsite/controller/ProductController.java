package com.example.EcommerceWebsite.controller;


import com.example.EcommerceWebsite.model.Product;
import com.example.EcommerceWebsite.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        System.out.println("Product in controller----" + product);
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
    }

}
