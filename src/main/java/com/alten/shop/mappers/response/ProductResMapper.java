package com.alten.shop.mappers.response;

import com.alten.shop.dots.responses.ProductResDto;
import com.alten.shop.entities.Product;
import org.mapstruct.Mapper;

@Mapper
public interface ProductResMapper {
    Product toEntity(ProductResDto dto);
    ProductResDto toDto(Product entity);
}
