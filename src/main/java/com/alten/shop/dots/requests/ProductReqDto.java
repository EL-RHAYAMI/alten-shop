package com.alten.shop.dots.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductReqDto {

    @NotBlank(message = "The code should not be blank")
    @NotEmpty(message = "The code should not be empty")
    @NotNull(message = "The code should not be null")
    private String code;

    @NotBlank(message = "The name should not be blank")
    @NotEmpty(message = "The name should not be empty")
    @NotNull(message = "The name should not be null")
    private String name;

    @NotBlank(message = "The description should not be blank")
    @NotEmpty(message = "The description should not be empty")
    @NotNull(message = "The description should not be null")
    private String description;
    private double price;
    private int quantity;

    @NotBlank(message = "The inventory status should not be blank")
    @NotEmpty(message = "The inventory status should not be empty")
    @NotNull(message = "The inventory status should not be null")
    private String inventoryStatus;

    @NotBlank(message = "The category status should not be blank")
    @NotEmpty(message = "The category status should not be empty")
    @NotNull(message = "The category status should not be null")
    private String category;
    private String image;
    private int rating;
}