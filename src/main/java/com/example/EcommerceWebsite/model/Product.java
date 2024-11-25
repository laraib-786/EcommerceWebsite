package com.example.EcommerceWebsite.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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
@NoArgsConstructor
@Setter
@Getter
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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "expiry_date")
    private LocalDate expiryDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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

    public LocalDate getExpiryDate() {
        return expiryDate;
    }


    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public void setId(long id) {
        this.id =  id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setMainCategory(String mainCategory) {
        this.mainCategory = mainCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
}

