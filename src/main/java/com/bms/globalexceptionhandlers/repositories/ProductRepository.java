package com.bms.globalexceptionhandlers.repositories;

import com.bms.globalexceptionhandlers.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findByName(String name);
}