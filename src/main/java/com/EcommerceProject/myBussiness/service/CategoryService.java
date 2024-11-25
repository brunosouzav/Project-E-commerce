package com.EcommerceProject.myBussiness.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EcommerceProject.myBussiness.model.Category;
import com.EcommerceProject.myBussiness.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
    private CategoryRepository repository;


	
	public Category createCategory(Category category) {
	        
	       return repository.save(category);
	    }
	
	public List<Category> listAllCategory(){
		return  repository.findAll();
	}

	
	public void deleteCategory(Long id) {
		 
		if (!repository.existsById(id)) {
	            throw new NoSuchElementException("Category with id " + id + " not found.");
	        }
		repository.deleteById(id);
	}
	
	
	public Category findCategoryById(Long id) {
	    return repository.findById(id)
	        .orElseThrow(() -> new NoSuchElementException("Category with id " + id + " not found."));
	}
	
	
	
}