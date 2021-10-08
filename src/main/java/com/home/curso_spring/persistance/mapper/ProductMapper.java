package com.home.curso_spring.persistance.mapper;

import com.home.curso_spring.domain.dto.ProductDto;
import com.home.curso_spring.persistance.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

    @Mapping(source = "idProducto", target = "productId")
    @Mapping(source = "nombre", target = "name")
    @Mapping(source = "idCategoria", target = "categoryId")
    @Mapping(source = "precioVenta", target = "price")
    @Mapping(source = "cantidadStock", target = "stock")
    @Mapping(source = "estado", target = "active")
    @Mapping(source = "categoria", target = "categoryDto")
    ProductDto toProduct(Producto producto);

    List<ProductDto> toProducts(List<Producto> productos);

    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras", ignore = true)
    Producto toProducto(ProductDto productDto);

}
