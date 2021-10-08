package com.home.curso_spring.domain.repository;

import com.home.curso_spring.domain.dto.PurchaseDto;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {

    List<PurchaseDto> getAll();

    Optional<List<PurchaseDto>> getByClient(String clientId);

    PurchaseDto save(PurchaseDto purchaseDto);

}
