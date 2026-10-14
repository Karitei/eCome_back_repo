package com.hs.e.Com.service;

import com.hs.e.Com.entity.Category;
import com.hs.e.Com.exception.CategoryNotFoundException;
import com.hs.e.Com.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id){
        return categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found for id:" +id));
    }
}
