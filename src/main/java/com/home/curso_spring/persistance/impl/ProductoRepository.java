package com.home.curso_spring.persistance.impl;

import com.home.curso_spring.domain.dto.ProductDto;
import com.home.curso_spring.domain.repository.ProductRepository;
import com.home.curso_spring.persistance.crud.ProductoCrudRepository;
import com.home.curso_spring.persistance.entity.Producto;
import com.home.curso_spring.persistance.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {

    @Autowired
    private ProductMapper mapper;

    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    @Override
    public List<ProductDto> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<ProductDto>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<ProductDto>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThan(quantity);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<ProductDto> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        Producto producto = mapper.toProducto(productDto);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int productId){
        productoCrudRepository.deleteById(productId);
    }

}
