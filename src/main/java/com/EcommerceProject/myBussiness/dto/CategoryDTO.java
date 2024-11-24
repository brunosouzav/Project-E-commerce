package com.EcommerceProject.myBussiness.dto;

public record CategoryDTO(
        String name,
        String description,
        Long parentCategoryId
) {}