package com.mibe.recipe.repository;

import com.mibe.recipe.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepo extends CrudRepository<Category, Long> {
    Optional<Category> findByName(String aDesc);
}
