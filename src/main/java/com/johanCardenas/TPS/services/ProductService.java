package com.johanCardenas.TPS.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johanCardenas.TPS.DTO.MostSoldProduct;
import com.johanCardenas.TPS.models.Product;
import com.johanCardenas.TPS.repositories.ProductRepository;


import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Transactional
    public Product createProduct(Product product) {        
        return productRepository.save(product);
    }
    public ArrayList<Product> getAllProducts() {
        return (ArrayList<Product>)productRepository.findAll();
    }
    public Product getProductById(Integer productId) {
        return productRepository.findById(productId)
        .orElseThrow(() -> 
        new EntityNotFoundException("Producto no encontrado")
        );
    }
    public ArrayList<Product> getProductsByCategory(String category) {
        return (ArrayList<Product>)productRepository.findByCategory(category);
    }
    public ArrayList<Product> getActiveProducts() {
        return (ArrayList<Product>)productRepository.findByActive(true);
    }
    @Transactional
    public boolean deleteProduct(Integer productId) {
        try {
            productRepository.deleteById(productId);
            return true;
        }catch(Exception err){
            return false;
        }
    }   
    public MostSoldProduct getMostSoldProduct() {
        ArrayList<MostSoldProduct> list = productRepository.getMostSoldProduct();
        if (list.isEmpty()) return null;
        return list.get(0);
    }
}
