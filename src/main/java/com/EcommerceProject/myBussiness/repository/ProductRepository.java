package com.EcommerceProject.myBussiness.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EcommerceProject.myBussiness.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
