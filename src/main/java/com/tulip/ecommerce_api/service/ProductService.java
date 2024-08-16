package com.tulip.ecommerce_api.service;

//import com.tulip.ecommerce_api.dto.ProductDTO;
import com.tulip.ecommerce_api.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(Long categoryId);
    Product getProductById(Long id);
}
