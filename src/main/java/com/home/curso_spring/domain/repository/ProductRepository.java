package com.home.curso_spring.domain.repository;

import com.home.curso_spring.domain.dto.ProductDto;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<ProductDto> getAll();
    Optional<List<ProductDto>> getByCategory(int categoryId);
    Optional<List<ProductDto>> getScarseProducts(int quantity);
    Optional<ProductDto> getProduct(int productId);
    ProductDto save(ProductDto productDto);
    void delete (int productId);

}
