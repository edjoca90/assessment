package com.johanCardenas.TPS.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    @Column(nullable=false) 
    private LocalDateTime orderDate;
    @Column(nullable=false)
    private int units;
    @Column(nullable=false) 
    private Double discountApplied;
    @Column(nullable=true) 
    private boolean randomOrder = false; // para descuento del 50%

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

} 

