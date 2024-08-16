package com.tulip.ecommerce_api.controller;

//mport org.springframework.beans.factory.annotation.Autowired;
import com.tulip.ecommerce_api.dto.ProductDTO;
import com.tulip.ecommerce_api.entity.Product;
import com.tulip.ecommerce_api.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/product")
@Log4j2
@Tag(name = "product", description = "The product. Contains all the operations that can be performed for product.")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/category/{categoryId}")
    public List<ProductDTO> getProductsByCategory(@PathVariable Long categoryId) {
        return productService.getProductsByCategory(categoryId);
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }
}
