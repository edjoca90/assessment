package com.johanCardenas.TPS.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    @Column(nullable=true) 
    private LocalDateTime orderDate;
    @Column(nullable=false)
    private int units;
    @Column(nullable=false) 
    private int discountApplied = 0;
    @Column(nullable=true) 
    private boolean randomOrder = false; // para descuento del 50%
 
    @Column(nullable=false) 
    private int userId;

   @Column(nullable=false) 
    private int productId;

} 

