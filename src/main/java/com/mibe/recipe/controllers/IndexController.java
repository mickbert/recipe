package com.mibe.recipe.controllers;

import com.mibe.recipe.domain.Recipe;
import com.mibe.recipe.repository.RecipeRepo;
import com.mibe.recipe.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    RecipeService recipeService;

    public IndexController(RecipeService recipeRepo) {
        this.recipeService = recipeRepo;
    }

    @GetMapping({"","/index","/index.html"})
    public String processGetIndex(Model aModel){
        Iterable<Recipe> recipes = recipeService.getRecipies();
        aModel.addAttribute("recipeList",recipes);
        return "index";
    }
}
