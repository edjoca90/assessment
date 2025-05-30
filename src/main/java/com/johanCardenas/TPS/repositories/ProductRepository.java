package com.johanCardenas.TPS.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.johanCardenas.TPS.models.Product;

public interface  ProductRepository  extends JpaRepository<Product, Integer> {
    // ArrayList<Product> findByActiveTrue();
}
