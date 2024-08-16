package com.tulip.ecommerce_api.service.implementation;

import com.tulip.ecommerce_api.entity.Product;
import com.tulip.ecommerce_api.exception.ResourceNotFoundException;
import com.tulip.ecommerce_api.repository.ProductRepository;
import com.tulip.ecommerce_api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsByCategory(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }
}