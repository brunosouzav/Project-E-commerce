package com.EcommerceProject.myBussiness.service;
import org.springframework.security.core.Authentication;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.EcommerceProject.myBussiness.config.SecurityConfig;
import com.EcommerceProject.myBussiness.dto.CreateUserDto;
import com.EcommerceProject.myBussiness.dto.EmailDto;
import com.EcommerceProject.myBussiness.dto.LoginUserDto;
import com.EcommerceProject.myBussiness.dto.RecoveryJwtTokenDto;
import com.EcommerceProject.myBussiness.exceptions.EmailAlreadyRegisteredException;
import com.EcommerceProject.myBussiness.exceptions.LoginNotFoundException;
import com.EcommerceProject.myBussiness.model.Role;
import com.EcommerceProject.myBussiness.model.User;
import com.EcommerceProject.myBussiness.model.UserDetailsImpl;
import com.EcommerceProject.myBussiness.repository.UserRepository;



@Service
public class UserService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityConfig securityConfig;

    @Autowired 
    private EmailService emailService;
    
    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public RecoveryJwtTokenDto authenticateUser(LoginUserDto loginUserDto) {
       
    	 if (loginUserDto.email() == null || loginUserDto.email().isBlank()) {
    	        throw new LoginNotFoundException("Email cannot be null or empty.");
    	    }

    	   
    	    Optional<User> existingUser = userRepository.findByEmail(loginUserDto.email());
    	    if (existingUser.isEmpty()) {
    	        throw new LoginNotFoundException("Email not found in the system.");
    	    }

    	
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginUserDto.email(), loginUserDto.password());

        
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

       
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        
        return new RecoveryJwtTokenDto(jwtTokenService.generateToken(userDetails));
    }

    
    public void createUser(CreateUserDto createUserDto) {
    	
    	Optional<User> existingUser = userRepository.findByEmail(createUserDto.email());
    	if (existingUser.isPresent()) {
    		
    		throw new EmailAlreadyRegisteredException();
    	} 
    		
    	Role role = Role.builder().name(createUserDto.role()).build();
        User newUser = User.builder()
        		.userName(createUserDto.userName())
                .email(createUserDto.email())
                .password(securityConfig.passwordEncoder().encode(createUserDto.password()))
                .roles(List.of(role))
                .build();

        userRepository.save(newUser);
        
        EmailDto emailDto = new EmailDto(
                newUser.getEmail(),  
                "Bem-vindo ao nosso sistema!", 
                "Olá " + newUser.getEmail() + "Obrigado por se cadastrar em nosso sistema. Estamos felizes em tê-lo conosco!" 
            );
        
        try {
            
            emailService.sendEmail(emailDto);
        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }
}