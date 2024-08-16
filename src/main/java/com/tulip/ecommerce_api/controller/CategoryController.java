package com.tulip.ecommerce_api.controller;

import com.tulip.ecommerce_api.entity.Category;
import com.tulip.ecommerce_api.service.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
@Log4j2
@Tag(name = "category", description = "The category. Contains all the operations that can be performed for category.")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(path = "/all")
    public ResponseEntity<?> getAllCategoryList() throws Exception {
        List<Category> categoryDTOList = categoryService.getAllCategories();
        return ResponseEntity.ok(categoryDTOList);
    }

}
