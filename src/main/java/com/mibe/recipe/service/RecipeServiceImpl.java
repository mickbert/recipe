package com.mibe.recipe.service;

import com.mibe.recipe.domain.Recipe;
import com.mibe.recipe.repository.RecipeRepo;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepo recipeRepo;

    public RecipeServiceImpl(RecipeRepo recipeRepo) {
        this.recipeRepo = recipeRepo;
    }

    @Override
    public Set<Recipe> getRecipies() {
        Set<Recipe> recipes = new HashSet<>();
        recipeRepo.findAll().iterator().forEachRemaining(recipes::add);
        return recipes;
    }
}
