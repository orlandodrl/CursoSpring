package com.home.curso_spring.domain.dto;

import lombok.Data;

@Data
public class PurchaseItemDto {

    private int productId;
    private int quantity;
    private double total;
    private boolean active;

}

