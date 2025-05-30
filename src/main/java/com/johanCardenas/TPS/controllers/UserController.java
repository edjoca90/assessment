package com.johanCardenas.TPS.controllers;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.johanCardenas.TPS.models.User;
import com.johanCardenas.TPS.services.UserService;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<User> create(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping()
    public ArrayList<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @PostMapping("/byId")
    public ResponseEntity<?> getUserById(@RequestBody Map<String, Integer> body) {
        Integer id= body.get("userId");
         try {
            User user= userService.getUserById(id);
            return ResponseEntity.ok(user);
         } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
         }
    }
    @DeleteMapping("/del")
    public ResponseEntity<?> delete(@RequestBody Map<String, Integer> body) {
        Integer id= body.get("userId");
        boolean ok = userService.deleteUser(id);
        if(ok){
            return  ResponseEntity.ok("Se elimino el registro con id "+ id);
        }else{
            return ResponseEntity.internalServerError().body("No pudo eliminar el modulo con id"+ id);
        }
        
    }
    
}
