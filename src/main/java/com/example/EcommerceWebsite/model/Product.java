package com.example.EcommerceWebsite.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "product")
public class Product {

    int id
}
