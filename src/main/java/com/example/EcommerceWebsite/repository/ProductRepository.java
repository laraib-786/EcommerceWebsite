package com.example.EcommerceWebsite.repository;

import com.example.EcommerceWebsite.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
