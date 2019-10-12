package com.elte.alkfejl.controllers;

import com.elte.alkfejl.entities.Recipe;
import com.elte.alkfejl.repositories.RecipeRepository;
import com.elte.alkfejl.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("recipe")
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public ResponseEntity<Iterable<Recipe>> getAll() {
        return new ResponseEntity(recipeRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> get(@PathVariable long id) {
        return new ResponseEntity(recipeRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Recipe> update(@RequestBody Recipe entity){
        Optional<Recipe> baseEntity = recipeRepository.findById(entity.getId());

        if(baseEntity.isPresent()){
            recipeRepository.save(entity);
            return new ResponseEntity(recipeRepository.findById(entity.getId()), HttpStatus.OK) ;
        }

        return ResponseEntity.notFound().build();
    }
}
