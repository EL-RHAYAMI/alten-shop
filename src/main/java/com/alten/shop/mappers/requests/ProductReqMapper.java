package com.alten.shop.mappers.requests;

import com.alten.shop.dots.requests.ProductReqDto;
import com.alten.shop.entities.Product;
import org.mapstruct.Mapper;

@Mapper
public interface ProductReqMapper {
    Product toEntity(ProductReqDto dto);
    ProductReqDto toDto(Product entity);
}
