package com.elte.alkfejl.repositories;

import com.elte.alkfejl.entities.Recipe;
import com.elte.alkfejl.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
    List<Recipe> findAllByCreatedBy(User user);
}
