package com.EcommerceProject.myBussiness.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EcommerceProject.myBussiness.exceptions.ProductNotFoundException;
import com.EcommerceProject.myBussiness.model.Product;
import com.EcommerceProject.myBussiness.repository.ProductRepository;

@Service
public class ProductService {

    

    @Autowired
    public ProductRepository productRepository;

 
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
    
    public Product findProductById(Long id) {
        return productRepository.findById(id)
            .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + id));
    }
    
  
    public Product updateProduct(Long id, Product updatedProduct) {
       
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException("Product not found with ID: " + id);
        }

        updatedProduct.setId(id);  
        return productRepository.save(updatedProduct);
    }

    public void deleteProduct(Long id) {
        
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException("Product not found with ID: " + id);
        }

        productRepository.deleteById(id);
    }
}