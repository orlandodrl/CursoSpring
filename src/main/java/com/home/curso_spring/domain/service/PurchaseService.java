package com.home.curso_spring.domain.service;

import com.home.curso_spring.domain.dto.PurchaseDto;
import com.home.curso_spring.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<PurchaseDto> getAll() {
        return purchaseRepository.getAll();
    }

    public Optional<List<PurchaseDto>> getByClient(String clientId) {
        return purchaseRepository.getByClient(clientId);
    }

    public PurchaseDto save(PurchaseDto purchaseDto) {
        return purchaseRepository.save(purchaseDto);
    }

}
