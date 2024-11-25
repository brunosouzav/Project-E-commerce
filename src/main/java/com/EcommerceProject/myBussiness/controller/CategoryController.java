package com.EcommerceProject.myBussiness.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EcommerceProject.myBussiness.model.Category;
import com.EcommerceProject.myBussiness.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	@Autowired
    private CategoryService service;

	@PostMapping
	public ResponseEntity<Category> createCategory(@RequestBody Category category) {
	    Category newCategory = service.createCategory(category);
	    return new ResponseEntity<>(newCategory, HttpStatus.CREATED);
	}
	
	
	 @GetMapping
	public ResponseEntity<List<Category>> getAllCategory(){
		List<Category> categorie = service.listAllCategory();
		return new ResponseEntity<>(categorie, HttpStatus.OK);
	}
	
	 @GetMapping("/{id}")
	    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
	        Category category = service.findCategoryById(id);
	        return ResponseEntity.ok(category);
	    }
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteCategory(@ PathVariable Long id){
		service.deleteCategory(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}