package com.home.curso_spring.domain.service;

import com.home.curso_spring.domain.dto.ProductDto;
import com.home.curso_spring.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDto> getAll(){
        return productRepository.getAll();
    }

    public Optional<ProductDto> getProduct(int productId){
        return productRepository.getProduct(productId);
    }

    public Optional<List<ProductDto>> getByCategory(int categoryId){
        return productRepository.getByCategory(categoryId);
    }

    public ProductDto save(ProductDto productDto){
        return productRepository.save(productDto);
    }

    public boolean delete(int productId){
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }

}
