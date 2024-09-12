package com.alten.shop.dots.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Setter;

@Builder
@Setter
public class ProductResDto {

    @JsonProperty(value = "id")
    private Long id;
    @JsonProperty(value = "code")
    private String code;
    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "description")
    private String description;
    @JsonProperty(value = "price")
    private double price;
    @JsonProperty(value = "quantity")
    private int quantity;
    @JsonProperty(value = "inventoryStatus")
    private String inventoryStatus;
    @JsonProperty(value = "category")
    private String category;
    @JsonProperty(value = "image")
    private String image;
    @JsonProperty(value = "rating")
    private int rating;

}
