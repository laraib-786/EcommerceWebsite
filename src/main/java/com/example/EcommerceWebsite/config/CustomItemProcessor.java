package com.example.EcommerceWebsite.config;

import com.example.EcommerceWebsite.model.Product;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Component
public class CustomItemProcessor implements ItemProcessor<Product, Product> {

    @Override
    public Product process(Product product) throws Exception {
        LocalDate expiryDate = product.getExpiryDate();

        // Calculate the date four months from now
        LocalDate thresholdDate = LocalDate.now().plus(4, ChronoUnit.MONTHS);

        // Check if the expiry date is after the threshold date
        if (expiryDate != null && expiryDate.isAfter(thresholdDate)) {
            return product; // Return the product if it is valid (not expiring in the next 4 months)
        } else {
            return null; // Skip the product by returning null
        }

    }
}
