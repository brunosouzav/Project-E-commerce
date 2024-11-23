package com.EcommerceProject.myBussiness.dto;

import com.EcommerceProject.myBussiness.enus.UserRole;

public record CreateUserDto(

        String email,
        String password,
        UserRole role

) {
}