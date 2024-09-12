package com.alten.shop.services.impl;

import com.alten.shop.dots.requests.ProductReqDto;
import com.alten.shop.dots.responses.ProductResDto;
import com.alten.shop.entities.Product;
import com.alten.shop.exceptions.EntityAlreadyExistException;
import com.alten.shop.exceptions.FieldNotFoundException;
import com.alten.shop.mappers.requests.ProductReqMapper;
import com.alten.shop.mappers.response.ProductResMapper;
import com.alten.shop.repositories.ProductRepository;
import com.alten.shop.services.ProductService;
import com.alten.shop.validators.ObjectValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductReqMapper productReqMapper;
    private final ProductResMapper productResMapper;
    private final ObjectValidator<ProductReqDto> productValidator;

    @Override
    public ProductResDto create(ProductReqDto dto) {
        productValidator.validate(dto);

        if (productRepository.findByCode(dto.getCode()).isPresent()) {
            throw new EntityAlreadyExistException("Product already exists");
        }

        return productResMapper.toDto(
                productRepository.save(
                        productReqMapper.toEntity(dto)
                )
        );
    }

    @Override
    public List<ProductResDto> retrieveAll() {

        return productRepository.findAll().stream()
                .map(productResMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResDto retrieveDetails(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found"));
        return productResMapper.toDto(product);
    }

    @Override
    public ProductResDto update(Long id, Map<String, Object> fields) {

        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));

        fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Product.class, key);
            if(field == null) throw new FieldNotFoundException("Field '" +key + "' not found");
            field.setAccessible(true);
            ReflectionUtils.setField(field, existingProduct, value);
        });

        productValidator.validate(productReqMapper.toDto(existingProduct));

        return productResMapper.toDto(
                productRepository.save(existingProduct)
        );
    }

    @Override
    public void remove(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found"));
        productRepository.delete(product);
    }
}
