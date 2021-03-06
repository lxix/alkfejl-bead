package com.elte.alkfejl.controllers;

import com.elte.alkfejl.entities.Label;
import com.elte.alkfejl.entities.Recipe;
import com.elte.alkfejl.entities.Role;
import com.elte.alkfejl.repositories.LabelRepository;
import com.elte.alkfejl.repositories.RecipeRepository;
import com.elte.alkfejl.repositories.UserRepository;
import com.elte.alkfejl.security.AuthenticatedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("recipe")
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticatedUser authenticatedUser;

    @Autowired
    private LabelRepository labelRepository;

    @GetMapping("")
    public ResponseEntity<Iterable<Recipe>> getAll() {
        return new ResponseEntity(recipeRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> get(@PathVariable long id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        if (!recipe.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> update(@PathVariable Long id, @RequestBody Recipe recipe) {
        Optional<Recipe> oRecipe = recipeRepository.findById(id);
        if (oRecipe.isPresent() && (authenticatedUser.getUser().getId().equals(oRecipe.get().getCreatedBy().getId())
                || authenticatedUser.getUser().getRole().equals(Role.ROLE_ADMIN))) {
            recipe.setId(id);
            recipe.setUpdatedBy(authenticatedUser.getUser());
            return ResponseEntity.ok(recipeRepository.save(recipe));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("")
    public ResponseEntity<Recipe> update(@RequestBody Recipe entity) {
        entity.setCreatedBy(authenticatedUser.getUser());
        entity.setUpdatedBy(authenticatedUser.getUser());
        return ResponseEntity.ok(recipeRepository.save(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Recipe> delete(@PathVariable Long id) {
        Optional<Recipe> oRecipe = recipeRepository.findById(id);
        if (oRecipe.isPresent() &&
                (authenticatedUser.getUser().getId().equals(oRecipe.get().getCreatedBy().getId())
                        || authenticatedUser.getUser().getRole().equals(Role.ROLE_ADMIN))) {
            recipeRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("createdby/{id}")
    public ResponseEntity<Recipe> getByCreatedUser(@PathVariable Long id){
        return new ResponseEntity(
                recipeRepository.findAllByCreatedBy(
                        userRepository.findById(id).get()
                ),
                HttpStatus.OK);
    }

    @GetMapping("/{id}/labels")
    public ResponseEntity<Iterable<Label>> messages(@PathVariable Long id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        if (!recipe.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe.get().getLabel());
    }
}
