package com.johanCardenas.TPS.models;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @Column(nullable=false, length=100)
    private String userName;
    @Column(nullable=false, length=256)
    private String password;
    @Column(nullable=false, length=100)
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(nullable=false, length=100)
    private Boolean isFrequent = false; // usado para descuento del 5%

    
    public enum Role {
    ADMIN, CUSTOMER
}
   
}
