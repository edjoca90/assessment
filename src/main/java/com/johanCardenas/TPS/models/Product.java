package com.johanCardenas.TPS.models;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long productId;

    @Column(nullable=false, length=100) 
    private String productName;
    @Column(nullable=false, length=50) 
    private String category;
    @Column(nullable=false, length=200) 
    private String description;
    @Column(nullable=false) 
    private Double price;
    @Column(nullable=true) 
    private boolean active = true;
    @Column(nullable=false)
    private int stock;
   

}

