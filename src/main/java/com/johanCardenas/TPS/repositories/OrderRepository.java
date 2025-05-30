package com.johanCardenas.TPS.repositories;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.johanCardenas.TPS.models.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{
    
    
}
