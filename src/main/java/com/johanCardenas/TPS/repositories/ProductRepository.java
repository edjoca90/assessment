package com.johanCardenas.TPS.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import com.johanCardenas.TPS.DTO.MostSoldProduct;
import com.johanCardenas.TPS.models.Product;


public interface  ProductRepository  extends JpaRepository<Product, Integer> {
    ArrayList<Product> findByActive(boolean active);
    ArrayList<Product> findByCategory(String category);
    
    @Query(value = "CALL pr_getMostSold()", nativeQuery = true)
    ArrayList<MostSoldProduct> getMostSoldProduct();
}
