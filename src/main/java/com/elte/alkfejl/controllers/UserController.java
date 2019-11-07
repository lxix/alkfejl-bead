package com.elte.alkfejl.controllers;

import com.elte.alkfejl.entities.User;
import com.elte.alkfejl.repositories.UserRepository;
import com.elte.alkfejl.security.AuthenticatedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticatedUser authenticatedUser;

    @GetMapping("")
    public ResponseEntity<Iterable<User>> getAll() {
        return new ResponseEntity(userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("logoff")
    public ResponseEntity logoff() {
        authenticatedUser.setUser(null);
        return ResponseEntity.ok(0);
    }
}
