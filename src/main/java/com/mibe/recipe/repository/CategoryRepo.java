package com.mibe.recipe.repository;

import com.mibe.recipe.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepo extends CrudRepository<Category, Long> {
}
