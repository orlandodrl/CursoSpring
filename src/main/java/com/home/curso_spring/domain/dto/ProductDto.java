package com.home.curso_spring.domain.dto;

import lombok.Data;

@Data
public class ProductDto {

    private int productId;
    private String name;
    private int categoryId;
    private double price;
    private int stock;
    private boolean active;
    private CategoryDto categoryDto;

}
