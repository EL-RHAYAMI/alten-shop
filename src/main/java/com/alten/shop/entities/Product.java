package com.alten.shop.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "code", length = 9, unique = true)
    private String code;
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private double price;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "inventory_status", length = 20)
    private String inventoryStatus;
    @Column(name = "category", length = 30)
    private String category;
    @Column(name = "image")
    private String image;
    @Column(name = "rating")
    private int rating;
}