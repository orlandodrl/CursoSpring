package com.home.curso_spring.persistance.mapper;

import com.home.curso_spring.domain.dto.CategoryDto;
import com.home.curso_spring.persistance.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(source = "idCategoria", target = "categoryId")
    @Mapping(source = "descripcion", target = "category")
    @Mapping(source = "estado", target = "active")
    CategoryDto toCategory(Categoria categoria);
    
    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(CategoryDto categoryDto);
    
}
