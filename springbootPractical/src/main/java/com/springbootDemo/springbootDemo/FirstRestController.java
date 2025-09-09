package com.springbootDemo.springbootDemo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class FirstRestController {

    @GetMapping("/first")
    public String getUI(){
        return "Hello From Springboot";
    }

      // URL: http://localhost:8080/users/101
    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") int userId) {
        return "User ID: " + userId;
    }

    // URL: http://localhost:8080/users?id=101
    @GetMapping
    public String getUserByQuery(@RequestParam("id") int userId) {
        return "User ID: " + userId;
    }

    // http://localhost:8080/users
    @PostMapping
    public User createUser(@RequestBody User user) {
        return user;
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> delUser(@PathVariable int id, @RequestBody User user) {
        user.setName("new_Name");
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delUser(@PathVariable int id) {
        return ResponseEntity.ok("USER WITH ID "+id+" deleted");
    }

    }
