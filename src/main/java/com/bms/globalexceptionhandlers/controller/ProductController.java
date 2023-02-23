package com.bms.globalexceptionhandlers.controller;

import com.bms.globalexceptionhandlers.model.Product;
import com.bms.globalexceptionhandlers.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProductById(int id) {
        return productService.getProductById(id);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public void createProduct(int id, String name) {
        productService.createProduct(id, name);
    }

    @PutMapping("/{id}")
    public void updateProduct(int id, String name) {
        productService.updateProduct(id, name);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(int id) {
        productService.deleteProduct(id);
    }
}
