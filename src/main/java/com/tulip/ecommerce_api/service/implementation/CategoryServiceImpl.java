package com.tulip.ecommerce_api.service.implementation;

import com.tulip.ecommerce_api.entity.Category;
import com.tulip.ecommerce_api.repository.CategoryRepository;
import com.tulip.ecommerce_api.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@AllArgsConstructor(onConstructor_ = @Autowired)
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }
}
