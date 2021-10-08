package com.home.curso_spring.domain.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class PurchaseDto {

    private int purchaseId;
    private String clientId;
    private LocalDateTime date;
    private String paymentMethod;
    private String comment;
    private String state;
    private List<PurchaseItemDto> items;

}
