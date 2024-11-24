package com.EcommerceProject.myBussiness.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EcommerceProject.myBussiness.dto.CategoryDTO;
import com.EcommerceProject.myBussiness.model.Category;
import com.EcommerceProject.myBussiness.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
    private CategoryRepository categoryRepository;

  
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

   
    public Category createCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.name());
        category.setDescription(categoryDTO.description());

        if (categoryDTO.parentCategoryId() != null) {
            Category parentCategory = categoryRepository.findById(categoryDTO.parentCategoryId())
                    .orElseThrow(() -> new RuntimeException("Parent category not found"));
            category.setParentCategory(parentCategory);
        }

        return categoryRepository.save(category);
    }

  
    public Category updateCategory(Long id, CategoryDTO categoryDTO) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        category.setName(categoryDTO.name());
        category.setDescription(categoryDTO.description());

        if (categoryDTO.parentCategoryId() != null) {
            Category parentCategory = categoryRepository.findById(categoryDTO.parentCategoryId())
                    .orElseThrow(() -> new RuntimeException("Parent category not found"));
            category.setParentCategory(parentCategory);
        } else {
            category.setParentCategory(null); 
        }

        return categoryRepository.save(category);
    }


    public void deleteCategory(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new RuntimeException("Category not found");
        }
        categoryRepository.deleteById(id);
    }
}