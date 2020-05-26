package com.mibe.recipe.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mibe.recipe.repository.*;
import com.mibe.recipe.domain.*;

import java.math.BigDecimal;

@Component
public class DataLoader implements CommandLineRunner {
    RecipeRepo recipeRepo;
    CategoryRepo categoryRepo;
    UnitOfMeasureRepo unitOfMeasureRepo;



    public DataLoader(RecipeRepo recipeRepo, CategoryRepo categoryRepo, UnitOfMeasureRepo unitOfMeasureRepo) {
        this.recipeRepo = recipeRepo;
        this.categoryRepo = categoryRepo;
        this.unitOfMeasureRepo = unitOfMeasureRepo;
    }

    @Override
    public void run(String args[]){
        loadRecipeIntoDatabase();
    }

    private void loadRecipeIntoDatabase() {
        UnitOfMeasure countUnit = findUnitOfMeasure("#");
        UnitOfMeasure gramsUnit = findUnitOfMeasure("g");
        UnitOfMeasure pinchUnit = findUnitOfMeasure("pc");
        UnitOfMeasure deciliterUnit = findUnitOfMeasure("dl");

        Recipe recipe = new Recipe();
        recipe.setDescription("Perfect Guacamole");
        recipe.setPrepTimeMin(10);
        recipe.setCookTimeMin(0);
        recipe.setServingCount(4);
        recipe.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole");
        recipe.setDirections("Just ripe avocados, salt, a squeeze of lime, onions, chiles, " +
                                "cilantro, and some chopped tomato. Serve it as a dip at your " +
                                "next party or spoon it on top of tacos for an easy dinner " +
                                "upgrade.");
        recipe.setSource("Simply recipes");
        recipe.setDifficulty(Difficulty.EASY);

        Ingredient ingredient = new Ingredient();
        ingredient.setDescription("Avocado");
        ingredient.setAmount(new BigDecimal(1));
        ingredient.setUnit(countUnit);
        recipe.addIngredient(ingredient);

        ingredient = new Ingredient();
        ingredient.setDescription("salt");
        ingredient.setAmount(new BigDecimal(1));
        ingredient.setUnit(pinchUnit);
        recipe.addIngredient(ingredient);

        ingredient = new Ingredient();
        ingredient.setDescription("lime");
        ingredient.setAmount(new BigDecimal(1));
        ingredient.setUnit(pinchUnit);
        recipe.addIngredient(ingredient);

        ingredient = new Ingredient ();
        ingredient.setDescription("onion");
        ingredient.setAmount(new BigDecimal(1));
        ingredient.setUnit(countUnit);
        recipe.addIngredient(ingredient);

        ingredient = new Ingredient();
        ingredient.setDescription("chile");
        ingredient.setAmount(new BigDecimal(25));
        ingredient.setUnit(gramsUnit);
        recipe.addIngredient(ingredient);

        ingredient = new Ingredient();
        ingredient.setDescription("chilto");
        ingredient.setAmount(new BigDecimal(25));
        ingredient.setUnit(gramsUnit);
        recipe.addIngredient(ingredient);

        ingredient = new Ingredient();
        ingredient.setDescription("tomato");
        ingredient.setAmount(new BigDecimal(200));
        ingredient.setUnit(gramsUnit);
        recipe.addIngredient(ingredient);

        Recipe guacamole = recipeRepo.save(recipe);

        recipe = new Recipe();
        recipe.setDescription("Spicy Grilled Chicken Tacos");
        recipe.setPrepTimeMin(30);
        recipe.setCookTimeMin(3);
        recipe.setServingCount(4);
        recipe.setSource("Simply recipes");
        recipe.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos");
        recipe.setDirections("First, I marinate the chicken briefly in a spicy paste of ancho " +
                              "chile powder, oregano, cumin, and sweet orange juice while the " +
                              "grill is heating, You can also use this time to prepare the taco " +
                              "toppings, Grill the chicken, then let it rest while you warm the " +
                             "tortillas, Now you are ready to assemble the tacos and dig in");
        recipe.setDifficulty(Difficulty.EASY);

        ingredient = new Ingredient();
        ingredient.setDescription("chiccken chips");
        ingredient.setAmount(new BigDecimal(500));
        ingredient.setUnit(gramsUnit);
        recipe.addIngredient(ingredient);
        
        ingredient = new Ingredient();
        ingredient.setDescription("ancho");
        ingredient.setAmount( new BigDecimal(1));
        ingredient.setUnit(pinchUnit);
        recipe.addIngredient(ingredient);

        ingredient = new Ingredient();
        ingredient.setDescription("spicy paste");
        ingredient.setAmount(new BigDecimal(20));
        ingredient.setUnit(deciliterUnit);
        recipe.addIngredient(ingredient);

        ingredient = new Ingredient();
        ingredient.setDescription("chile powder");
        ingredient.setAmount(new BigDecimal(1));
        ingredient.setUnit(pinchUnit);
        recipe.addIngredient(ingredient);

        ingredient = new Ingredient();
        ingredient.setDescription("oregano");
        ingredient.setAmount(new BigDecimal(1));
        ingredient.setUnit(pinchUnit);
        recipe.addIngredient(ingredient);

        ingredient = new Ingredient();
        ingredient.setDescription("cumin");
        ingredient.setAmount(new BigDecimal(1));
        ingredient.setUnit(pinchUnit);
        recipe.addIngredient(ingredient);

        ingredient = new Ingredient();
        ingredient.setDescription("orange juice");
        ingredient.setAmount(new BigDecimal(2));
        ingredient.setUnit(deciliterUnit);
        recipe.addIngredient(ingredient);

        ingredient = new Ingredient();
        ingredient.setDescription("Tacos");
        ingredient.setAmount(new BigDecimal(4));
        ingredient.setUnit(countUnit);
        recipe.addIngredient(ingredient);

        Recipe chicken = recipeRepo.save(recipe);
    }

    private UnitOfMeasure findUnitOfMeasure(String aCode) {
        return unitOfMeasureRepo.findByCode(aCode)
            .orElseGet(()->{
                    UnitOfMeasure unit = new UnitOfMeasure();
                    unit.setCode("unknown");
                    unit.setName("unknown unit of measure code " + aCode);
                    return unit;
                });
    }
}
