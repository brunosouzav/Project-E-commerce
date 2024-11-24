package com.EcommerceProject.myBussiness.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EcommerceProject.myBussiness.model.Product;
import com.EcommerceProject.myBussiness.repository.ProductRepository;

@Service
public class ProductService {

    

    @Autowired
    public ProductRepository productRepository;

 
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    
    public Product updateProduct(Long id, Product updatedProduct) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found.");
        }

       
        updatedProduct.setId(id);  
        return productRepository.save(updatedProduct);
    }

   
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found.");
        }

        productRepository.deleteById(id);
    }
}