package com.johanCardenas.TPS.controllers;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.johanCardenas.TPS.DTO.MostSoldProduct;
import com.johanCardenas.TPS.models.Order;
import com.johanCardenas.TPS.models.Product;
import com.johanCardenas.TPS.services.ProductService;

import io.micrometer.core.ipc.http.HttpSender;


@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
     @PostMapping()
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return ResponseEntity.ok(productService.createProduct(product));
    }

    @GetMapping()
    public ArrayList<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    @PostMapping("/byId")
    public ResponseEntity<?> getProductById(@RequestBody Map<String, Integer> body) {
        Integer id= body.get("productId");
         try {
            Product product= productService.getProductById(id);
            return ResponseEntity.ok(product);
         } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado");
         }
    }
    @PostMapping("/byCategory")
    public ResponseEntity<?> getProductsByCategory(@RequestBody Map<String, String> body) {
        String category= body.get("category");
        ArrayList<Product> products= productService.getProductsByCategory(category);
        if(!products.isEmpty()){
            return  ResponseEntity.ok(products);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay productos de esa categoria");
        }         
    }
    @GetMapping("/active")
    public ResponseEntity<?> getProductsByActive() {        
        ArrayList<Product> products= productService.getActiveProducts();
        if(!products.isEmpty()){
            return  ResponseEntity.ok(products);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay productos activos");
        }         
    }

    @DeleteMapping("/del")
    public ResponseEntity<?> delete(@RequestBody Map<String, Integer> body) {
        Integer id= body.get("productId");
        boolean ok = productService.deleteProduct(id);
        if(ok){
            return  ResponseEntity.ok("Se elimino el registro con id "+ id);
        }else{
            return ResponseEntity.internalServerError().body("No pudo eliminar el registro con id"+ id);
        }        
    }
    @GetMapping("/mostSold")
    public MostSoldProduct getMostSoldProduct() {
        return productService.getMostSoldProduct();
    }
}
