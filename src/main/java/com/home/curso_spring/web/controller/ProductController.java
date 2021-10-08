package com.home.curso_spring.web.controller;

import com.home.curso_spring.domain.dto.ProductDto;
import com.home.curso_spring.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<ProductDto>> getAll(){
        return ResponseEntity.ok().body(productService.getAll());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable("productId") int productId){
        return ResponseEntity.of(productService.getProduct(productId));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ProductDto>> getByCategory(@PathVariable("categoryId") int categoryId){
        return ResponseEntity.of(productService.getByCategory(categoryId));
    }

    @PostMapping
    public ResponseEntity<ProductDto> save(@RequestBody ProductDto productDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(productDto));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Boolean> delete(@PathVariable("productId") int productId){
        return productService.delete(productId) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}
