package com.mibe.recipe.repository;

import com.mibe.recipe.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepo extends CrudRepository<Ingredient, Long> {
}
