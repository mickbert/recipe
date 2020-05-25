package com.mibe.recipe.repository;

import com.mibe.recipe.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RecipeRepo extends CrudRepository<Recipe,Long> {
    Optional<Recipe> findByDescription(String aDesc);
}
