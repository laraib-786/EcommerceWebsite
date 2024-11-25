package com.example.EcommerceWebsite.config;

import com.example.EcommerceWebsite.model.Product;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProductFieldSetMapper implements FieldSetMapper<Product> {
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Adjust as per date format in CSV

    @Override
    public Product mapFieldSet(FieldSet fieldSet) throws BindException {
        Product product = new Product();
        product.setId(fieldSet.readLong("id"));
        product.setName(fieldSet.readString("name"));
        product.setPrice(fieldSet.readBigDecimal("price"));
        product.setBrandName(fieldSet.readString("brandName"));
        product.setMainCategory(fieldSet.readString("mainCategory"));
        product.setSubCategory(fieldSet.readString("subCategory"));
        product.setManufacturingDate(LocalDate.parse(fieldSet.readString("manufacturingDate"), DATE_FORMAT));
        product.setExpiryDate(LocalDate.parse(fieldSet.readString("expiryDate"), DATE_FORMAT));
        return product;
    }
}
