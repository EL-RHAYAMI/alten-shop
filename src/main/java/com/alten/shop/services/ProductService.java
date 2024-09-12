package com.alten.shop.services;

import com.alten.shop.dots.requests.ProductReqDto;
import com.alten.shop.dots.responses.ProductResDto;

import java.util.List;
import java.util.Map;

public interface ProductService {
    ProductResDto create(ProductReqDto dto);

    List<ProductResDto> retrieveAll();

    ProductResDto retrieveDetails(Long id);

    ProductResDto update(Long id, Map<String, Object> fields);

    void remove(Long id);
}
