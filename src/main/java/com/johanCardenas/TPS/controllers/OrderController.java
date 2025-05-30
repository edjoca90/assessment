package com.johanCardenas.TPS.controllers;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.johanCardenas.TPS.models.Order;
import com.johanCardenas.TPS.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @GetMapping()
    public ArrayList<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
    @PostMapping()
    public ResponseEntity<Order> create(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.createOrder(order));
    }
    @DeleteMapping("/del")
    public ResponseEntity<?> delete(@RequestBody Map<String, Integer> body) {
        Integer id= body.get("orderId");
        boolean ok = orderService.deleteOrder(id);
        if(ok){
            return  ResponseEntity.ok("Se elimino el registro con id "+ id);
        }else{
            return ResponseEntity.internalServerError().body("No pudo eliminar el registro con id"+ id);
        }        
    }
}
