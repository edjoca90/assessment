package com.johanCardenas.TPS.repositories;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.johanCardenas.TPS.DTO.FrequentClientDTO;
import com.johanCardenas.TPS.DTO.MostSoldProduct;
import com.johanCardenas.TPS.models.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    // Optional<User> findByEmail(String email);

    // Optional<User> findByUserName(String username);
     @Query(value = "CALL pr_getFrecuentClients()", nativeQuery = true)
    ArrayList<FrequentClientDTO> getFrecuentClientsTop5();
}
