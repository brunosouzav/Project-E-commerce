package com.EcommerceProject.myBussiness.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EcommerceProject.myBussiness.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByEmail(String email);
	
}
