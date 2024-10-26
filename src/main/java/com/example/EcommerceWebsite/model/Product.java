package com.example.EcommerceWebsite.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

//@Entity: Specifies that this class is an entity to be mapped to a table in the database.
//@Table(name = "product"): Specifies the table name.
//@Id: Marks the id field as the primary key.
//@GeneratedValue(strategy = GenerationType.IDENTITY): Uses auto-incrementing for id.
//@Column: Maps each field to a column in the database, specifying name, length, precision, and scale where needed.

@Entity
@Table(name = "product")
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "brand_name", length = 255)
    private String brandName;

    @Column(name = "main_category", length = 255)
    private String mainCategory;

    @Column(name = "sub_category", length = 255)
    private String subCategory;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    @Column(name = "manufacturing_date")
    private LocalDate manufacturingDate;

    // Override toString() to print product details
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", brandName='" + brandName + '\'' +
                ", mainCategory='" + mainCategory + '\'' +
                ", subCategory='" + subCategory + '\'' +
                ", expiryDate=" + expiryDate +
                ", manufacturingDate=" + manufacturingDate +
                '}';
    }
}

