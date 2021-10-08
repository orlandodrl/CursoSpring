package com.home.curso_spring.persistance.impl;

import com.home.curso_spring.domain.dto.PurchaseDto;
import com.home.curso_spring.domain.repository.PurchaseRepository;
import com.home.curso_spring.persistance.crud.CompraCrudRepository;
import com.home.curso_spring.persistance.entity.Compra;
import com.home.curso_spring.persistance.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {

    @Autowired
    private CompraCrudRepository compraCrudRepository;

    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<PurchaseDto> getAll() {
        return mapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<PurchaseDto>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId)
                .map(compras -> mapper.toPurchases(compras));
    }

    @Override
    public PurchaseDto save(PurchaseDto purchaseDto) {
        Compra compra = mapper.toCompra(purchaseDto);
        compra.getProductos().forEach(producto -> producto.setCompra(compra));
        return mapper.toPurchase(compraCrudRepository.save(compra));
    }

}
