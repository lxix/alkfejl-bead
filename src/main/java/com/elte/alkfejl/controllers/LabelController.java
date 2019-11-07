package com.elte.alkfejl.controllers;

import com.elte.alkfejl.entities.Label;
import com.elte.alkfejl.entities.Recipe;
import com.elte.alkfejl.repositories.LabelRepository;
import com.elte.alkfejl.repositories.UserRepository;
import com.elte.alkfejl.security.AuthenticatedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("label")
public class LabelController {

    @Autowired
    private LabelRepository labelRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticatedUser authenticatedUser;

    @GetMapping("")
    public ResponseEntity<Iterable<Recipe>> getAll() {
        return new ResponseEntity(labelRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Label> update(@RequestBody Label entity) {
        entity.setCreatedBy(authenticatedUser.getUser());
        entity.setUpdatedBy(authenticatedUser.getUser());
        return ResponseEntity.ok(labelRepository.save(entity));
    }

}
