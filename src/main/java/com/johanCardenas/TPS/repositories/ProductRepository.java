package com.johanCardenas.TPS.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.johanCardenas.TPS.models.Product;
import java.util.List;


public interface  ProductRepository  extends JpaRepository<Product, Integer> {
    ArrayList<Product> findByActive(boolean active);
    ArrayList<Product> findByCategory(String category);

}
