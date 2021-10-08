package com.home.curso_spring.web.controller;

import com.home.curso_spring.domain.dto.PurchaseDto;
import com.home.curso_spring.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/all")
    public ResponseEntity<List<PurchaseDto>> getAll() {
        return ResponseEntity.ok().body(purchaseService.getAll());
    }

    @GetMapping("/client/{idClient}")
    public ResponseEntity<List<PurchaseDto>> getByClient(@PathVariable("idClient") String clientId) {
        return ResponseEntity.of(purchaseService.getByClient(clientId));
    }

    @PostMapping
    public ResponseEntity<PurchaseDto> save(@RequestBody PurchaseDto purchaseDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(purchaseService.save(purchaseDto));
    }

}

