package com.tulip.ecommerce_api.dto;

import com.tulip.ecommerce_api.entity.Category;
import com.tulip.ecommerce_api.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO extends Product {

    private Long id;
    private String title;
    private String description;
    private Double price;
    private Integer quantity;
    private Category category;
}
