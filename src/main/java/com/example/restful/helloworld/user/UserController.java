package com.example.restful.helloworld.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserDAOService service;

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        User user = service.findOne(id);

        if (user == null) {
            throw new UserNotFountException(String.format("ID ('%s) not fount", id));
        }

        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User saveUser = service.save(user);

        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/{id}")
                .buildAndExpand(saveUser.getId())
                .toUri();

        return ResponseEntity.created((uri)).build();
    }
    
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        User user = service.deleteById(id);

        if (user == null) {
            throw new UserNotFountException(String.format("Delete User Not Found = %s", id));
        }

    }

    @PutMapping("/users/{id}")
    public String updateUser (@PathVariable int id ,@RequestBody User users) {

        User user = service.updateUser(id, users);

        if(user == null) {
             throw new UserNotFountException(String.format("Update user not Found = %s", id));
        }

        return String.format("update complete id = %s", id);
    }
}
