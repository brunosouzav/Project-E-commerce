package com.EcommerceProject.myBussiness.dto;

import java.util.List;

import com.EcommerceProject.myBussiness.model.Role;

public record RecoveryUserDto(

        Long id,
        String email,
        List<Role> roles

) {
}