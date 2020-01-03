package com.elte.alkfejl.repositories;

import com.elte.alkfejl.entities.Recipe;
import com.elte.alkfejl.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
    Iterable<Recipe> findAllByCreatedBy(User user);
}
