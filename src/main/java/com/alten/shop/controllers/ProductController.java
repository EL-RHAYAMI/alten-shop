package com.alten.shop.controllers;

import com.alten.shop.controllers.api.ProductApi;
import com.alten.shop.dots.requests.ProductReqDto;
import com.alten.shop.dots.responses.ProductResDto;
import com.alten.shop.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController implements ProductApi {

    private final ProductService productService;

    @Override
    public ResponseEntity<ProductResDto> create(ProductReqDto dto) {
        return ResponseEntity.ok(productService.create(dto));
    }

    @Override
    public ResponseEntity<List<ProductResDto>> retrieveAll() {
        return ResponseEntity.ok(productService.retrieveAll());
    }

    @Override
    public ResponseEntity<ProductResDto> retrieveDetails(Long id) {
        return ResponseEntity.ok(productService.retrieveDetails(id));
    }

    @Override
    public ResponseEntity<ProductResDto> update(Long id, Map<String, Object> fields) {
        return ResponseEntity.ok(productService.update(id, fields));
    }

    @Override
    public ResponseEntity<Void> remove(Long id) {
        productService.remove(id);
        return ResponseEntity.noContent().build();
    }
}