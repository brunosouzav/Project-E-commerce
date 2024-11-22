package com.EcommerceProject.myBussiness.model;

import com.EcommerceProject.myBussiness.enus.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "userId")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@Size(min = 3, max = 20, message = "O nome de usuário deve ter entre 3 e 20 caracteres.")
	private String userName;
	
	@NotNull
	@Column(unique = true)
	private String email;
	
	@NotNull
	@Size(min = 3, max = 20, message = "Senha deve ter entre 3 e 20 caracteres.")
	private String password;
	
	@Enumerated(EnumType.STRING) 
	private UserRole role;
}
