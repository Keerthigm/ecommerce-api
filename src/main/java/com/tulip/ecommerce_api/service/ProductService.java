package com.tulip.ecommerce_api.service;

import com.tulip.ecommerce_api.dto.ProductDTO;
import com.tulip.ecommerce_api.entity.Product;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProducts();
    List<ProductDTO> getProductsByCategory(Long categoryId);
    ProductDTO getProductById(Long id);
}
