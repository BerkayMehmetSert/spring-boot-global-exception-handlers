package com.bms.globalexceptionhandlers.service;

import com.bms.globalexceptionhandlers.core.exceptions.BusinessException;
import com.bms.globalexceptionhandlers.core.exceptions.NotFoundException;
import com.bms.globalexceptionhandlers.core.messages.BusinessMessages;
import com.bms.globalexceptionhandlers.model.Product;
import com.bms.globalexceptionhandlers.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(int id, String name) {
        checkIfProductExists(name);

        var product = new Product();
        product.setId(id);
        product.setName(name);

        productRepository.save(product);
    }

    public void updateProduct(int id, String name) {
        var product = getProduct(id);
        product.setName(name);

        productRepository.save(product);
    }

    public void deleteProduct(int id) {
        var product = getProduct(id);
        productRepository.delete(product);
    }

    public Product getProductById(int id) {
        return getProduct(id);
    }

    public List<Product> getAllProducts() {
        var products = productRepository.findAll();

        if (products.isEmpty()) throw new NotFoundException(BusinessMessages.PRODUCT_LIST_EMPTY);

        return products;
    }

    private void checkIfProductExists(String name) {
        var product = productRepository.findByName(name);
        if (product != null) throw new BusinessException(BusinessMessages.PRODUCT_ALREADY_EXISTS);
    }

    private Product getProduct(int id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(BusinessMessages.PRODUCT_NOT_FOUND_BY_ID));
    }
}
