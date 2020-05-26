package com.mibe.recipe.controllers;

import com.mibe.recipe.domain.Recipe;
import com.mibe.recipe.repository.RecipeRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    RecipeRepo recipeRepo;

    public IndexController(RecipeRepo recipeRepo) {
        this.recipeRepo = recipeRepo;
    }

    @GetMapping({"","/index","/index.html"})
    public String processGetIndex(Model aModel){
        Iterable<Recipe> recipes = recipeRepo.findAll();
        aModel.addAttribute("recipeList",recipes);
        return "index";
    }
}
